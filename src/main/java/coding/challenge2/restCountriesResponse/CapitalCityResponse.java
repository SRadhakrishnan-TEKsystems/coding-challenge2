package coding.challenge2.restCountriesResponse;

import coding.challenge2.restCountries.CapitalCity;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import javax.ws.rs.core.Response;
import java.util.List;

public class CapitalCityResponse extends CountryDataResponse {
    private final String body;
    private final int statusCode;

    private CapitalCityResponse(Response response) {
        statusCode = response.getStatus();
        body = response != null ? response.readEntity(String.class) : null;
    }

    public static CapitalCityResponse getInstance(Response response) {
        return new CapitalCityResponse(response);
    }

    public CapitalCity get() {
        Gson gson = new Gson();
        List<CapitalCity> capitalCityList = gson.fromJson(body, new TypeToken<List<CapitalCity>>() {
        }.getType());
        return capitalCityList.get(0);
    }
}
