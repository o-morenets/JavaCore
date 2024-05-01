package stackOverflow.jsonParse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HhApi {

    public static void main(String[] args) throws Exception {

//        Console console = new Console();
//        Console.console();
//        HhApi hhApi = new HhApi();
        hhApiCountriesList();
    }

    public static void hhApiCountriesList() {

        String hh = "https://api.hh.ru/areas/countries";

        HttpURLConnection connection = null;
        StringBuilder sb;
        try {
            connection = (HttpURLConnection) new URL(hh).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(500);
            connection.setReadTimeout(500);

            connection.connect();

            sb = new StringBuilder();
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                System.out.println(sb.toString());
            } else {
                System.out.println("FAIL :" + connection.getResponseCode() + ", " + connection.getResponseMessage());
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
