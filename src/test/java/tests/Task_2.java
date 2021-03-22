package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.victoriassecret.com/us/");


        WebDriverRunner.setWebDriver(driver);
    }


   @org.testng.annotations.Test
    public void validateWebElement(){

       $x("//*[text()='NEW!']").shouldBe(Condition.visible).hover();
       Assert.assertEquals("NEW!", $x("//*[text()='NEW!']").text());

       $x("//*[text()='Sport & Lounge']").shouldBe(Condition.visible).click();
       Assert.assertEquals("Sport & Lounge", $x("//*[text()='Sport & Lounge']").text());

       $x("//*[text()='Sport & Lounge']").waitUntil(Condition.appears, 6000);

       if($("[id='heading-dialog-0']").is(Condition.appears)) {
           $("[class='fabric-plain-button-element fix fabric-modal-utility-close-button']").click();
       }

       $x("//*[text()='Size']").closest("button").shouldBe(Condition.visible).hover();
       Assert.assertEquals("Size", $x("//*[text()='Size']").text());

       driver.close();




    }
    @org.testng.annotations.Test
    public void validateWebElementNegative() {

        $x("//*[text()='NEW!']").shouldBe(Condition.visible).hover();
        Assert.assertEquals("NEW!1", $x("//*[text()='NEW!']").text());

        driver.close();

    }
}
