package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;


    }



    private String newTab = "//*[text()='NEW!']";

    public SelenideElement getNewTab() {
        return $x(newTab);
    }
}
