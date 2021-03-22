package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
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

    private  String SportLounge = "//*[text()='Sport & Lounge']";

    public SelenideElement SelectSport(){
        return $x(SportLounge);
    }

    private  String PopUp = "//*[text()='Sport & Lounge']";

    public  SelenideElement PopUpA(){
        return $x(PopUp);
    }

    private  String popDialog = "[id='heading-dialog-0']";

    public SelenideElement Dialog (){
        return $(popDialog);
    }

    private String closeDialogButton = "[class='fabric-plain-button-element fix fabric-modal-utility-close-button']";

    public SelenideElement ClDialogButton(){
        return $(closeDialogButton);
    }

    private String Size = "//*[text()='Size']";

    public SelenideElement size(){
        return $x(Size);
    }

    private String seletSsize = "[data-value='S']";

    public SelenideElement Ssize(){
        return $(seletSsize);
    }


    private String Style = "//*[text()='Style']";

    public SelenideElement style(){
        return $x(Style);
    }

    private String fullZip = "[data-value='Full-Zips']";

    public SelenideElement FullZip(){
        return $(fullZip);
    }

    private String color  = "//*[text()='Color']";

    public  SelenideElement Color(){
        return $x(color);
    }

    private String ValueBlck = "[data-value='Black']";
    public SelenideElement valueBlack(){
        return $(ValueBlck);
    }

    private String  listOfLingeries = "[class='fabric-product-stacks-component']";
    public SelenideElement list(){
        return $(listOfLingeries);
    }
}
