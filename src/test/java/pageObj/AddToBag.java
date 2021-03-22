package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class AddToBag {

    private WebDriver driver;

    public AddToBag(WebDriver driver){
        this.driver = driver;
    }


    private String  addToBag = "//*[text()='Add to Bag']";

    public SelenideElement AddToBag(){
        return $x(addToBag);
    }
}
