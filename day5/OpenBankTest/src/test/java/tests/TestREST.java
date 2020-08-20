package tests;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TestREST {

    static String rapidapi_host = "wft-geo-db.p.rapidapi.com";
    static String rapidapi_key = "eb23de97femsh4f5d685c10d83ebp1130aajsne3e1df75a403";

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @Test
    public void testLocales() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                queryParam("offset", "100").
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/locales").
                then().
                assertThat().
                body("links[0].rel", equalTo("first"));
        Thread.sleep(500);

    }

    @Test
    public void testCurrencies() throws InterruptedException {
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
        Thread.sleep(800);
    }

    @Test
    public void testTimezones() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/locale/timezones").
                then().
                assertThat().
                body("links[1].rel", equalTo("next"));
        Thread.sleep(1000);
    }

    @Test
    public void testCities() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/geo/cities/Q60").
                then().
                assertThat().
                body("data.name", equalTo("New York City"));
        Thread.sleep(1000);
    }

    @Test
    public void testCountries() throws InterruptedException {
        given().
                header("x-rapidapi-host", rapidapi_host).
                header("x-rapidapi-key", rapidapi_key).
                when().
                get("https://wft-geo-db.p.rapidapi.com/v1/geo/countries").
                then().
                assertThat().
                body("data[0].code", equalTo("VA"));
        Thread.sleep(500);
    }
}
