package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage {


    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    @FindBy(id = "shipping_method_0_flat_rate1")
    private WebElement shippingRadioButton;


    @FindBy(className = "checkout-button")
    private WebElement checkoutButton;


   public void selectShippingRadioButton() {
       if (!shippingRadioButton.isSelected()) {
           shippingRadioButton.click();
       }
   }

   public void performCheckout() {
       selectShippingRadioButton();
       driver.navigate().refresh();
       checkoutButton.click();

   }


}
