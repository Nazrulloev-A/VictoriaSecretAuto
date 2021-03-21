import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public static void main(String[] args) {

        open("https://www.victoriassecret.com/us/");

        $x("//*[text()='NEW!']").hover();


        $x("//*[text()='Sport & Lounge']").click();



        $x("//*[text()='Sport & Lounge']").waitUntil(Condition.appears, 6000);

        if($("[id='heading-dialog-0']").is(Condition.appears)) {
            $("[class='fabric-plain-button-element fix fabric-modal-utility-close-button']").click();
        }

        $x("//*[text()='Size']").closest("button").hover();
        $("[data-value='S']").click();

        $x("//*[text()='Style']").closest("button").hover();
        $("[data-value='Full-Zips']").click();

        $x("//*[text()='Color']").closest("button").hover();
        $("[data-value='Black']").click();
        $x("//*[text()='Color']").closest("button").click();



        List<SelenideElement> listOfLingeries = $("[class='fabric-product-stacks-component']").$$("li");

        listOfLingeries.stream().filter(product -> product.scrollTo().text().contains("Stretch Fleece Front-zip Hoodie")).findFirst().get().click();

        $x("//*[text()='Add to Bag']").closest("button").scrollTo().click();
        $x("//*[text()='Check Out']").waitUntil(Condition.appears,5000).closest("button").scrollTo().click();
        $("[class='fabric-primary-grey-button-element checkoutAsGuestButton']").click();

        double price = Double.parseDouble($("[class='fabric-h2-typography-element price']").text().replace("$", ""));
        System.out.println(price);
        Assert.assertEquals("Merchandise Subtotal", $("[class='fabric-accordion-utility-item-header-text']").text());
        Assert.assertTrue(54.50 == price);

    }
}
