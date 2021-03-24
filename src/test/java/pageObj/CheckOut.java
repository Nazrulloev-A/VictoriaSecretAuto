package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class CheckOut {

    private WebDriver driver;

    public CheckOut(WebDriver driver) {
        this.driver = driver;
    }

    private String CheckOut = "//*[text()='Check Out']";

    public SelenideElement ChOut() {
        return $x(CheckOut);
    }
}
