package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressPage {


    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "edit")
    private List<WebElement> editButtons;

    private WebElement editSecondButton;


    @FindBy(id = "shipping_company")
    private WebElement shippingCompanyField;

    @FindBy(name = "save_address")
    private WebElement editButtonSave;

    @FindBy(className = "woocommerce-message")
    private WebElement messageDiv;

    private String expectedDivMessage = "Adres został zmieniony.";


    public void clickEditSecondButton() {
        editSecondButton.click();
    }

    public void editShippingCompany() {
        shippingCompanyField.clear();
        shippingCompanyField.sendKeys("mirex");
    }

    public void clickEditButtonSave() {
        editButtonSave.click();
    }

    public String getActualMessageText() {
        return messageDiv.getText();
    }

    public String getExpectedDivMessage() {
        return expectedDivMessage;
    }

    public void initEditSecondButton() {
        if (editButtons != null && editButtons.size() > 1) {
            editSecondButton = editButtons.get(1);
        } else {
            throw new IllegalStateException("Edit buttons are not loaded or less than 2 elements found.");
        }
    }


}
