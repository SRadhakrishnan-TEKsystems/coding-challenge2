package coding.challenge2.restCountriesRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public abstract class CountryDataRequest {
    private String path;
    private Client client;
    private WebTarget target;
    private String finalPath;
}
