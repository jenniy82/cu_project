package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MetricsConversionsHP extends PageMethods {
    String baseUrl = "https://www.metric-conversions.org/";
    public MetricsConversionsHP(WebDriver driver){
        super(driver);
        driver.get(baseUrl);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".main")));
//        System.out.println(driver.getCurrentUrl());
    }

    public void ClickTemperatureButton(){
       WebElement tempButton = findElementByText("Temperature");
       clickOnElement(tempButton);

    }
    public void ClickWeightButton(){
        WebElement weightButton = findElementByText("Weight");
        clickOnElement(weightButton);
    }
    public void ClickLengthButton(){
        WebElement lengthButton = findElementByText("Length");
        clickOnElement(lengthButton);
    }


}
