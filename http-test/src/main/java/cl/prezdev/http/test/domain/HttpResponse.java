package cl.prezdev.http.test.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class HttpResponse {

    private int code;
    private StringBuilder response;
    private Map<String, List<String>> headers;

    // TODO: Clean this method
    public void setResponse(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = getInputStream(httpURLConnection);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        response = new StringBuilder();
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }

        bufferedReader.close();
    }

    private InputStream getInputStream(HttpURLConnection httpURLConnection) throws IOException {
        if (isOkResponse()) {
            return httpURLConnection.getInputStream();
        } else {
            return httpURLConnection.getErrorStream();
        }
    }

    public boolean isOkResponse() {
        return this.code >= 200 && this.code < 300;
    }

}
