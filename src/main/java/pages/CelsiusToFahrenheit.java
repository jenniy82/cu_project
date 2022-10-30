package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CelsiusToFahrenheit extends PageMethods{
//    WebDriver driver;
//    WebDriverWait wait;
    String celsiusFieldName = "argumentConv";
    String celsiusValue;
    public CelsiusToFahrenheit(WebDriver driver,String celsiusValue){
        super(driver);
        this.celsiusValue = celsiusValue;
    }

    public void populateCelsiusField(){

            setField(celsiusValue,celsiusFieldName);


    }

//    public String getAnswer(){
//        WebElement answerField = driver.findElement(By.id("answer"));
//        String answer = answerField.getText();
//        return answer;
//
//    }
    public double getActualFahrenheit(String answer) {
        Pattern pattern = Pattern.compile("^.*C= (.*)°F");
        Matcher matcher = pattern.matcher(answer);
        String actualFarhenheit = null;
        if (matcher.find()) {
            actualFarhenheit = matcher.group(1);
        }
        Double actualFarhenheitD = Double.parseDouble(actualFarhenheit);
        return actualFarhenheitD;
    }
    public double getExpectedFarenheit(){
        Double expectedFarhenheit = Double.parseDouble(celsiusValue)*1.8000+32;
        return expectedFarhenheit;

    }
}
