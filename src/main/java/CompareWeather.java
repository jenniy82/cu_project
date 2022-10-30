import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.weather.WeatherApi;
import pages.weather.WeatherSelenium;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static java.lang.Math.abs;

public class CompareWeather {
    String apiURL = "http://api.weatherapi.com";
    String weatherURL = "http://www.weather.com";
    String authenticationToken = "fbada4f830d340228ea144358223010";
    String zipCode = "20852";

    WebDriver driver;

    @BeforeTest
    public void setDriver(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(weatherURL);

            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        }


    @Test
    public void compareApiVsWeb() {
        WeatherSelenium weatherSelenium = new WeatherSelenium(driver);
        weatherSelenium.setZipCode(zipCode);
        Double weatherTemp = weatherSelenium.getTemperatureSelenium();
        WeatherApi weatherApi = new WeatherApi(apiURL,authenticationToken,zipCode );
        Float apiWeatherTemp = weatherApi.getAPIWeather();
        System.out.println("weatherapi: "+apiWeatherTemp);
        System.out.println("weather selenium: "+weatherTemp);
        Double resultsGap = (abs(apiWeatherTemp-weatherTemp)/((apiWeatherTemp+weatherTemp)/2))*100;
        System.out.println(resultsGap);
        Assert.assertTrue(resultsGap<10,"The gap is: "+resultsGap+"% it's more then 10%");

}


    @AfterTest
    public void quitDriver(){
        driver.quit();
    }
}
