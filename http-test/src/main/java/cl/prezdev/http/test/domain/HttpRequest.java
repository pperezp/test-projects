package cl.prezdev.http.test.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class HttpRequest {

    private URL url;
    private HttpMethod httpMethod;
    private Map<String, String> headers;
    private String body;

    public HttpRequest() {
        this.headers = new HashMap<>();
    }

    public boolean hasHeaders() {
        return this.headers != null;
    }

    public HttpRequest addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public HttpRequest setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public HttpRequest setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
        return this;
    }

    public HttpResponse call() throws IOException {
        HttpURLConnection httpURLConnection = this.buildHttpUrlConnection();

        if (this.body != null) {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            // TODO: arreglar esto de UTF-8
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            outputStreamWriter.write(this.body);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            outputStream.close();
        }

        httpURLConnection.connect();

        HttpResponse httpResponse = new HttpResponse();

        httpResponse.setCode(httpURLConnection.getResponseCode());
        httpResponse.setHeaders(httpURLConnection.getHeaderFields());
        httpResponse.setResponse(httpURLConnection);

        return httpResponse;
    }

    private HttpURLConnection buildHttpUrlConnection() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(httpMethod.name());

        if (httpMethod == HttpMethod.POST) {
            httpURLConnection.setDoOutput(true);
        }

        addHeaders(httpURLConnection);
        return httpURLConnection;
    }

    private void addHeaders(HttpURLConnection httpURLConnection) {
        if (hasHeaders()) {
            headers.forEach(httpURLConnection::setRequestProperty);
        }
    }

    public HttpRequest body(String body) {
        this.body = body;
        return this;
    }

    public HttpRequest setBasicAuth(String user, String password) {
        String userCredentials = String.format("%s:%s", user, password);
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
        return addHeader("Authorization", basicAuth);
    }

    public HttpRequest setBearerToken(String bearerToken) {
        return addHeader("Authorization", "Bearer " + bearerToken);
    }
}
