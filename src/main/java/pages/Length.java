package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Length extends PageMethods
{
    WebElement element = findElementByText("Meters to Feet");

    public Length(WebDriver driver){

        super(driver);
    }
    public void clickMetersToFeet(){

        clickOnElement(element);
    }
}
