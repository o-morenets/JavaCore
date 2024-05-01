package misc.jersey;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import java.util.List;

public class CurrenciesJSON {

    public static void main(String[] args) {
        ClientConfig clientConfig = new DefaultClientConfig();

        // Create Client based on Config
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");

        Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
                .header("content-type", MediaType.APPLICATION_JSON);

        ClientResponse response = builder.get(ClientResponse.class);

        // Status 200 is successful.
        if (response.getStatus() != 200) {
            System.out.println("Failed with HTTP Error code: " + response.getStatus());
            String error = response.getEntity(String.class);
            System.out.println("Error: " + error);
            return;
        }

        GenericType<List<Currency>> generic = new GenericType<List<Currency>>() {
            // No thing
        };

        List<Currency> list = response.getEntity(generic);

        System.out.println("Output from Server .... \n");

        for (Currency currency : list) {
            System.out.println("-------------------------------------");
            System.out.println(currency);
        }
    }
}
