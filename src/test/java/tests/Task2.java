package tests;


import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pageObj.HomePage;

import java.util.concurrent.TimeUnit;

public class Task2 {

    private WebDriver driver;
    private HomePage homepage;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.victoriassecret.com/us/");


        WebDriverRunner.setWebDriver(driver);
        homepage = new HomePage(driver);
    }

    @org.testng.annotations.Test
    public void validateHomePage(){

        homepage.getNewTab().hover();
        driver.close();

    }

}
