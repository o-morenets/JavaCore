package ms_graph_api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;

/**
 * Libs (v 2.11+): jackson-databind, jackson-core (see lib/ folder)
 * Needs graph-api.properties in classpath
 */
public class GraphApiClient {

    private static String clientId;
    private static String clientSecret;
    private static String tenantId;
    private static String redirectUri;

    public static void main(String[] args) throws Exception {
        loadConfig();

        Scanner scanner = new Scanner(System.in);
        HttpClient httpClient = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        // 1. Показати користувачу URL для авторизації
        String authUrl = "https://login.microsoftonline.com/" + tenantId + "/oauth2/v2.0/authorize" +
                "?client_id=" + clientId +
                "&response_type=code" +
                "&redirect_uri=" + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8) +
                "&response_mode=query" +
                "&scope=" + URLEncoder.encode("https://graph.microsoft.com/User.Read", StandardCharsets.UTF_8) +
                "&state=12345";

        System.out.println("Перейдіть за цим URL у браузері:");
        System.out.println(authUrl);
        System.out.println("\nПісля входу скопіюйте значення параметра ?code=... і вставте тут:");

        // 2. Прийняти код з редіректу вручну
        String code = scanner.nextLine();

        // 3. Обмін коду на токен
        String tokenUrl = "https://login.microsoftonline.com/" + tenantId + "/oauth2/v2.0/token";
        String body = "client_id=" + URLEncoder.encode(clientId, StandardCharsets.UTF_8) +
                "&scope=" + URLEncoder.encode("https://graph.microsoft.com/.default", StandardCharsets.UTF_8) +
                "&code=" + URLEncoder.encode(code, StandardCharsets.UTF_8) +
                "&redirect_uri=" + URLEncoder.encode(redirectUri, StandardCharsets.UTF_8) +
                "&grant_type=authorization_code" +
                "&client_secret=" + URLEncoder.encode(clientSecret, StandardCharsets.UTF_8);

        HttpRequest tokenRequest = HttpRequest.newBuilder()
                .uri(URI.create(tokenUrl))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        HttpResponse<String> tokenResponse = httpClient.send(tokenRequest, HttpResponse.BodyHandlers.ofString());
        JsonNode tokenJson = objectMapper.readTree(tokenResponse.body());

        if (tokenJson.has("error")) {
            System.out.println("❌ Помилка авторизації:");
            System.out.println(tokenJson.toPrettyString());
            return;
        }

        String accessToken = tokenJson.get("access_token").asText();
        System.out.println("\n✅ Access Token:");
        System.out.println(accessToken);

        // 4. Виклик Microsoft Graph API: /me
        HttpRequest graphRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://graph.microsoft.com/v1.0/me"))
                .header("Authorization", "Bearer " + accessToken)
                .GET()
                .build();

        HttpResponse<String> graphResponse = httpClient.send(graphRequest, HttpResponse.BodyHandlers.ofString());
        JsonNode userJson = objectMapper.readTree(graphResponse.body());

        System.out.println("\n👤 Користувач:");
        System.out.println(userJson.toPrettyString());
    }

    private static void loadConfig() throws IOException {
        Properties props = new Properties();

        try (var inputStream = GraphApiClient.class.getClassLoader().getResourceAsStream("graph-api.properties")) {
            if (inputStream == null) {
                throw new IOException("❌ Не знайдено graph-api.properties у classpath");
            }
            props.load(inputStream);
        }

        clientId = props.getProperty("clientId");
        clientSecret = props.getProperty("clientSecret");
        tenantId = props.getProperty("tenantId");
        redirectUri = props.getProperty("redirectUri");
    }
}
