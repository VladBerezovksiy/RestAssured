package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GsonTest {

    public static final String EXPECTED_JSON = "{\n" +
            "  \"firstname\": \"testes\",\n" +
            "  \"lastname\": \"tester\",\n" +
            "  \"totalprice\": 101,\n" +
            "  \"depositpaid\": true,\n" +
            "  \"bookingdates\": {\n" +
            "    \"checkin\": \"2015-11-12\",\n" +
            "    \"checkout\": \"2015-12-07\"\n" +
            "  },\n" +
            "  \"additionalneeds\": \"Message\"\n" +
            "}";

    @Test
    public void serialiseTest() {
        Booking actualModel = new Booking();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String actualJson = gson.toJson(actualModel);
        assertThat(actualJson, equalTo(EXPECTED_JSON));
    }

    @Test
    public void deserializeTest() {
        Booking expectedModel = Booking.builder().firstname("FAILED").build();
        Booking actualModel = new Gson().fromJson(EXPECTED_JSON, Booking.class);
        assertThat(actualModel, equalTo(expectedModel));
    }

}
