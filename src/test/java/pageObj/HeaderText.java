package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class HeaderText {

    private WebDriver driver;

    public HeaderText(WebDriver driver) {
        this.driver = driver;
    }


    private String headerText = "[class='fabric-accordion-utility-item-header-text']";

    public SelenideElement HeaderText() {
        return $(headerText);
    }
}
