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
                {"cHIna","Beijing"},
                {"Mexico","Mexico City"}
        };
    }

    @DataProvider(name = "incorrectCountryNameProvider")
    public Object[][] provideIncorrectCountryName(){
        return new Object[][]{
                {"United"},
                {"USA"},
                {"123"},
                {"united sates of america"}
        };
    }

    @Test(dataProvider = "properCountryNameProvider" , groups = {"smoke"})
    public void returnsCorrectCapitalCityForCorrectInput(String countryInput, String expectedCapitalCity) {
        List<String> expectedCountryCapitalList=new ArrayList<>();
        expectedCountryCapitalList.add(expectedCapitalCity);
        CapitalCity actual = CapitalCityRequest.getInstance(countryInput).get();
        CapitalCity expected = new CapitalCity(expectedCountryCapitalList);
        Assert.assertEquals(actual, expected, "The city received is incorrect:");
    }

    @Test(dataProvider = "incorrectCountryNameProvider" , groups = {"acceptance"})
    public void returnsNullForIncorrectInput(String countryInput){
        CapitalCity actual = CapitalCityRequest.getInstance(countryInput).get();
        CapitalCity expected =null;
        Assert.assertEquals(actual,expected);
    }
}