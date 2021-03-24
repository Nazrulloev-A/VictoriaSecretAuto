package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CheckOutAsGuest {

    private WebDriver driver;

    public CheckOutAsGuest(WebDriver driver) {
        this.driver = driver;
    }

    private String checkOutAsGuest = "[class='fabric-primary-grey-button-element checkoutAsGuestButton']";

    public SelenideElement asGuest() {
        return $(checkOutAsGuest);
    }

    private String price = "[class='fabric-h2-typography-element price']";

    public SelenideElement prize() {
        return $(price);
    }
}
