package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OuncesToGrams extends PageMethods{

    String ouncesValue;
    String ouncesFieldName = "argumentConv";
//    String dropDownName = "format";
//    String dropDownValue = "Decimal";

    public OuncesToGrams(WebDriver driver, String ouncesValue){
        super(driver);
        this.ouncesValue = ouncesValue;
    }

    public void populateOuncesField(){

        setField(ouncesValue,ouncesFieldName);


    }

//    public void selectDecimal(){
//        dropDownSelect(dropDownName,dropDownValue);
//    }


    public double getActualGrams(String answer) {
        Pattern pattern = Pattern.compile("^.*oz= (.*)g");
        Matcher matcher = pattern.matcher(answer);
        String actualGrams = null;
        if (matcher.find()) {
            actualGrams = matcher.group(1);
        }
        Double actualGramsD = Double.parseDouble(actualGrams);
        return actualGramsD;
    }
    public double getExpectedGrams(){
        Double expectedOunces = Double.parseDouble(ouncesValue)/0.035274;
        return expectedOunces;

    }
}
