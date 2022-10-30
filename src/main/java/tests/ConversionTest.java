package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.text.DecimalFormat;
import java.time.Duration;

public class ConversionTest extends WebDriverInit{




    @Test()
    public void convertCelsiusToFahrenhite(){
        String celsiusValue = "20";
        MetricsConversionsHP conversionsHP = new MetricsConversionsHP(driver);
        conversionsHP.ClickTemperatureButton();
        Temperature tempPage = new Temperature(driver);
        tempPage.clickCelsiusToFahrenheit();
        CelsiusToFahrenheit celsiusToFahrenheitP = new CelsiusToFahrenheit(driver,celsiusValue);
        celsiusToFahrenheitP.populateCelsiusField();
        String answer = celsiusToFahrenheitP.getAnswer();
        double actualFarenheit = celsiusToFahrenheitP.getActualFahrenheit(answer);
        double expectedFarhenheit = celsiusToFahrenheitP.getExpectedFarenheit();
        Assert.assertEquals(actualFarenheit,expectedFarhenheit);

    }

    @Test()
    public void convertMetersToFeet(){
        String metersValue = "20";
        MetricsConversionsHP conversionsHP = new MetricsConversionsHP(driver);
        System.out.println(driver.getTitle());
        conversionsHP.ClickLengthButton();
        Length lenghtPage = new Length(driver);
        lenghtPage.clickMetersToFeet();
        MetersToFeet m2fPage = new MetersToFeet(driver,  metersValue);
        m2fPage.populateMetersField();
        m2fPage.selectDecimal();
        String answer = m2fPage.getAnswer();
        double actualFeet = m2fPage.getActualFeet(answer);
        actualFeet =Double.parseDouble(new DecimalFormat("##.##").format(actualFeet));
        System.out.println(actualFeet);
        double expectedFeet = m2fPage.getExpectedFeet();
        expectedFeet =Double.parseDouble(new DecimalFormat("##.##").format(expectedFeet));
        Assert.assertEquals(actualFeet,expectedFeet);

    }
    @Test()
    public void convertOuncesToGrams(){
        String ouncesValue = "23";
        MetricsConversionsHP conversionsHP = new MetricsConversionsHP(driver);
        conversionsHP.ClickWeightButton();
        Weight waightPage = new Weight(driver);
        waightPage.clickOuncesToGrams();
        OuncesToGrams o2GPage = new OuncesToGrams(driver,  ouncesValue);
        o2GPage.populateOuncesField();
        String answer = o2GPage.getAnswer();
        double actualGrams = o2GPage.getActualGrams(answer);
        actualGrams =Double.parseDouble(new DecimalFormat("##.##").format(actualGrams));
        System.out.println(actualGrams);
        double expectedGrams = o2GPage.getExpectedGrams();
        expectedGrams =Double.parseDouble(new DecimalFormat("##.##").format(expectedGrams));
        Assert.assertEquals(actualGrams,expectedGrams);

    }


}

