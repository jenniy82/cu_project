package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverInit {
    WebDriver driver;
    //WebDriverWait wait;

    @BeforeTest
    public void Init(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://www.metric-conversions.org/");
//
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".main")));
//      System.out.println(driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    @AfterTest
    public void QuitDriver(){
        driver.quit();
    }


}
