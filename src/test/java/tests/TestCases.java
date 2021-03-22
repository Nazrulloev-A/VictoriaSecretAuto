package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pageObj.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {

    private WebDriver driver;
    private HomePage homepage;
    private AddToBag addToBag;
    private CheckOut checkOut;
    private CheckOutAsGuest checkOutAsGuest;
    private  HeaderText headerText;

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.victoriassecret.com/us/");


        WebDriverRunner.setWebDriver(driver);
        homepage = new HomePage(driver);
        addToBag = new AddToBag(driver);
        checkOut = new CheckOut(driver);
        checkOutAsGuest = new CheckOutAsGuest(driver);
        headerText = new HeaderText(driver);

    }

    @org.testng.annotations.Test
    public void validateHomePage(){

        homepage.getNewTab().hover();
        homepage.SelectSport().click();
        homepage.PopUpA().waitUntil(Condition.appears, 6000);
        homepage.Dialog().is(Condition.appears);
        homepage.ClDialogButton().click();
        homepage.size().closest("button").hover();
        homepage.Ssize().click();
        homepage.style().closest("button").hover();
        homepage.FullZip().click();
        homepage.Color().closest("button").hover();
        homepage.valueBlack().click();
        homepage.Color().closest("button").click();
        List<SelenideElement> listOfLingeries = homepage.list().$$("li");
        listOfLingeries.stream().filter(product -> product.scrollTo().text().contains("Stretch Fleece Front-zip Hoodie"))
                .findFirst().get().click();
        addToBag.AddToBag().closest("button").scrollTo().click();
        checkOut.ChOut().waitUntil(Condition.appears,5000).closest("button").scrollTo().click();
        checkOutAsGuest.asGuest().click();
        double price = Double.parseDouble(checkOutAsGuest.prize().text().replace("$", ""));
        System.out.println(price);
        Assert.assertEquals("Merchandise Subtotal", headerText.HeaderText().text());
        Assert.assertTrue(54.50 == price);
        driver.close();
        driver.quit();








    }

}
