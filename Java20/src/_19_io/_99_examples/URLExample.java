package _19_io._99_examples;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("HTTP Response Code: " + responseCode);

            InputStream inputStream = connection.getInputStream();
            // Read data from inputStream
            // ...

            inputStream.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

