package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageMethods {

WebDriver driver;
//WebDriverWait wait;

    public PageMethods(WebDriver driver){
        this.driver = driver;
        //this.wait = wait;
    }

    public void clickOnElement(WebElement element){

        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click()", element);
    }
    public void setField(String value, String elementName){

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementName)));
        WebElement element = driver.findElement(By.id(elementName));
        element.sendKeys(value);

    }
    public String getAnswer(){
        WebElement answerField = driver.findElement(By.id("answer"));
        String answer = answerField.getText();
        return answer;

    }

    public WebElement findElementByText(String text){
       WebElement element =  driver.findElement(By.linkText(text));
       return element;
    }
    public void dropDownSelect(String dropDownName, String value){

        Select dropDown = new Select(driver.findElement(By.id(dropDownName)));
        dropDown.selectByVisibleText(value);
    }
}
