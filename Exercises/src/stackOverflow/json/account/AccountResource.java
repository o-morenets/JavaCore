package stackOverflow.json.account;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class AccountResource {
    @GET
    @Path("/account") // route to a specific method.re
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveDataIntoHash() {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("Stack", "Savings", 111));
        accounts.add(new Account("Overflow", "Checkings", 222));
        GenericEntity generic = new GenericEntity<List<Account>>(accounts){};
        return Response.status(200).entity(generic).build();
    }
}