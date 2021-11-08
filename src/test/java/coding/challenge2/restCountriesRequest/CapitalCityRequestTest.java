package coding.challenge2.restCountriesRequest;

import coding.challenge2.restCountries.CapitalCity;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class CapitalCityRequestTest {
    @DataProvider(name="properCountryNameProvider")
    public Object[][] provideProperCountryName(){
        return new Object[][]{
                {"United States","Washington, D.C."},
                {"India","New Delhi"},
                {"Peru","Lima"},
                {"peru","Lima"},
                {"PERU","Lima"},
                {"Dominican Republic","Santo Domingo"},
                {"San Marino","City of San Marino"},
                {"china","Beijing"},
        };
    }

    @Test(dataProvider = "properCountryNameProvider" , groups = {"smoke"})
    public void returnsCorrectCapitalCityForValidInput(String countryInput, String expectedCapitalCity) {
        List<String> expectedCountryCapitalList=new ArrayList<>();
        expectedCountryCapitalList.add(expectedCapitalCity);
        CapitalCity actual = CapitalCityRequest.getInstance(countryInput).get();
        CapitalCity expected = new CapitalCity(expectedCountryCapitalList);
        Assert.assertEquals(actual, expected, "The city received is incorrect:");
    }
}