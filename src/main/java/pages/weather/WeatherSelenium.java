package pages.weather;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WeatherSelenium {
    WebDriverWait wait;
    WebDriver driver;
    @FindBy(xpath = "//*[@id='LocationSearch_input']")
    WebElement e;

    @FindBy(xpath = "//*[@id='LocationSearch_listbox-0']")
    WebElement dropDownSelection;
    public WeatherSelenium(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void setZipCode(String zipCode)  {
        System.out.println(driver.getCurrentUrl());
        wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        while(true){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(e)).sendKeys(zipCode);
            break;
        }
        catch (Exception e) {
            System.out.println("trying to click a button");
        }
        }
        wait.until(ExpectedConditions.elementToBeClickable(dropDownSelection)).click();


    }

    public Double getTemperatureSelenium(){
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("CurrentConditions--tempValue--MHmYY"))));
        WebElement temperatureValue = driver.findElement(By.className("CurrentConditions--tempValue--MHmYY"));
        String tempValueResult = temperatureValue.getText();
        String test = StringUtils.chop(tempValueResult);
        Double tempResult = Double.parseDouble(test);
        return tempResult;
    }



}
