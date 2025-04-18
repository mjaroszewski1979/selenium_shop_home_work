package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewOrderPage {


    private WebDriver driver;

    public NewOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }




    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddress;

    @FindBy(id = "billing_postcode")
    private WebElement billingPostcode;

    @FindBy(id = "billing_city")
    private WebElement billingCity;

    @FindBy(id = "billing_phone")
    private WebElement billingPhone;

    @FindBy(id = "billing_email")
    private WebElement billingEmail;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    public void performPlacingOrder() {
        firstName.clear();
        firstName.sendKeys("Jan");
        lastName.clear();
        lastName.sendKeys("Kowalskiq");
        billingAddress.clear();
        billingAddress.sendKeys("armiiq krajowej");
        billingPostcode.clear();
        billingPostcode.sendKeys("60-123");
        billingCity.clear();
        billingCity.sendKeys("poznanq");
        billingPhone.clear();
        billingPhone.sendKeys("876453121");
        billingEmail.clear();
        billingEmail.sendKeys("kowqqal@gmail.com");
        placeOrderButton.click();
    }






}
