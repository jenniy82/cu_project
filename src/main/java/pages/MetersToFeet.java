package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetersToFeet extends PageMethods{
String metersValue;
String metersFieldName = "argumentConv";
String dropDownName = "format";
String dropDownValue = "Decimal";

    public MetersToFeet(WebDriver driver, String metersValue){
        super(driver);
        this.metersValue = metersValue;
    }

    public void populateMetersField(){

        setField(metersValue,metersFieldName);


    }

    public void selectDecimal(){
        dropDownSelect(dropDownName,dropDownValue);
    }


    public double getActualFeet(String answer) {
        Pattern pattern = Pattern.compile("^.*m= (.*)ft");
        Matcher matcher = pattern.matcher(answer);
        String actualFeet = null;
        if (matcher.find()) {
            actualFeet = matcher.group(1);
        }
        Double actualFeetD = Double.parseDouble(actualFeet);
        return actualFeetD;
    }
    public double getExpectedFeet(){
        Double expectedMeters = Double.parseDouble(metersValue)*3.2808;
        return expectedMeters;

    }
}
