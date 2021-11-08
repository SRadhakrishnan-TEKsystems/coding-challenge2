package coding.challenge2.restCountriesRequest;

import coding.challenge2.restCountries.CapitalCity;
import coding.challenge2.restCountriesResponse.CapitalCityResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class CapitalCityRequest extends CountryDataRequest {
    private static String PATH = "https://restcountries.com/v3.1/name/";
    private Client client;
    private WebTarget target;
    private String finalPath;

    private CapitalCityRequest(String countryInput) {
        this.finalPath = pathEncoder(countryInput);
        client = ClientBuilder.newBuilder()
                .build();
        target = client.target(UriBuilder.fromPath(finalPath).queryParam("fullText", "true"));
    }

    private String pathEncoder(String countryInput) {
        return PATH + countryInput;
    }

    public static CapitalCityRequest getInstance(String countryInput) {
        return new CapitalCityRequest(countryInput);
    }

    protected CapitalCity get() {
        Response response = null;
        try {
            response = target.request().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        CapitalCity capitalCity = CapitalCityResponse.getInstance(response).get();
        return capitalCity;
    }
}

