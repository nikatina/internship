package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import java.util.List;


public class TestREST {

    static String rapidapi_host = "wft-geo-db.p.rapidapi.com";
    static String rapidapi_key = "eb23de97femsh4f5d685c10d83ebp1130aajsne3e1df75a403";

    @Test
    public void testLocales() {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                queryParam("offset", "100").
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/locales").
                then().
                assertThat().
                body("links[0].rel", equalTo("first"));
    }

    @Test
    public void testCurrencies() {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                queryParam("offset", "10").
                queryParam("hateoasMode", true).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/currencies").
                then().
                assertThat().
                body("data[1].code", equalTo("AZN")).
                body("metadata.totalCount", equalTo(205));
    }

    @Test
    public void testTimezones() {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/timezones").
                then().
                assertThat().
                body("links[1].rel", equalTo("next"));
    }

    @Test
    public void testCities() {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/geo/cities/Q60").
                then().
                assertThat().
                body("data.name", equalTo("New York City"));
    }

    @Test
    public void testCountries() {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/geo/countries").
                then().
                assertThat().
                body("data[0].code", equalTo("VA"));
    }
}
