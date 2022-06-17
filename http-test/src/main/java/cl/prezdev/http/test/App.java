package cl.prezdev.http.test;

import cl.prezdev.http.test.domain.HttpRequest;
import org.springframework.http.HttpMethod;

import java.io.*;
import java.util.Base64;
import java.util.logging.Logger;

public class App {
    private static final Logger logger;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        logger = Logger.getLogger(App.class.getName());
    }

    public static void main(String[] args) throws IOException {
        getTestService();
    }

    private static void getTestService() throws IOException {
        logger.info((new HttpRequest()
                .setHttpMethod(HttpMethod.GET)
                .setUrl("http://prez.awto.pro/msadvancebooking/version")
                .addHeader("Accept", "application/json")
                .call().toString()));

        logger.info(new HttpRequest()
                .setHttpMethod(HttpMethod.POST)
                .setUrl("http://prez.awto.pro/awto/api/v1/advance-booking/bookings")
                .setBasicAuth("83130", "f897fbb0-2a0b-4fbe-826c-782c8fbe635c")
                .addHeader("Content-Type", "application/json")
                .body("{\n" +
                        "    \"vehicleTypeId\": 3,\n" +
                        "    \"startZoneId\": 1030,\n" +
                        "    \"startDatetime\": 1650888000000,\n" +
                        "    \"endDatetime\": 1682424000000\n" +
                        "}")
                .call().toString());
    }
}
