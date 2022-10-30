package pages.weather;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static java.lang.Math.abs;

public class WeatherApi {
String apiUrl;
String authenticationToken;
String zipCode;

    public WeatherApi(String apiUrl, String authenticationToken, String zipCode){
            this.apiUrl = apiUrl;
            this.authenticationToken = authenticationToken;
            this.zipCode = zipCode;
    }

    public Float getAPIWeather(){
        RestAssured.baseURI = "http://api.weatherapi.com";
        String response = given().log().all().queryParam("key",authenticationToken).queryParam("q",zipCode).queryParam("aqi","no").when().log().all().get("/v1/current.json").then().log().all().extract().response().asString();
        JsonPath js = new JsonPath(response);
        Float temp = js.get("current.temp_f");
        System.out.println(temp);
        return temp;
    }

}
