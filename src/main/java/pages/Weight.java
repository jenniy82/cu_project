package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Weight extends PageMethods
    {
        WebElement element = findElementByText("Ounces to Grams");

    public Weight(WebDriver driver){

        super(driver);
    }
        public void clickOuncesToGrams(){

        clickOnElement(element);
    }
    }

