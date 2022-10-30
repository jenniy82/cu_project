package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Temperature extends PageMethods {

    WebElement element = driver.findElement(By.linkText("Celsius to Fahrenheit"));
    public Temperature(WebDriver driver){

        super(driver);
    }
    public void clickCelsiusToFahrenheit(){

        clickOnElement(element);
    }

}
