package stackOverflow.json.account;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class AccountTest {

    public static void main(String[] args) {
        ClientConfig config = new DefaultClientConfig();
//        config.getClasses().add(JacksonJaxbJsonProvider.class);
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

        Client c = Client.create(config);

        WebResource webResource = c.resource("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");

        WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
                .header("content-type", MediaType.APPLICATION_JSON);

//        WebResource resource = c.resource(InterviewRefinitiv.BASE_URI);
        ClientResponse response = builder.get(ClientResponse.class);

        List<Account> accounts
                = response.getEntity(new GenericType<List<Account>>(){});

        StringBuilder sb = new StringBuilder("=== Accounts ===\n");
        for (Account account: accounts) {
            sb.append("Name: ").append(account.getName()).append(", ")
                    .append("Type: ").append(account.getType()).append("\n");
        }
        sb.append("==================");
        System.out.println(sb.toString());
    }
}
