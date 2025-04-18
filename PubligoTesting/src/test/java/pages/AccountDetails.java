package pages;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDetails {


    private WebDriver driver;

    public AccountDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//label[contains(text(), 'Aktualne hasło (pozostaw puste, aby nie zmieniać)')]")
    private WebElement labelCurrentPassword;

    @FindBy(xpath = "//label[contains(text(), 'Nowe hasło (pozostaw puste, aby nie zmieniać)')]")
    private WebElement labelNewPassword;

    @FindBy(xpath = "//label[contains(text(), 'Potwierdź nowe hasło')]")
    private WebElement labelConfirmPassword;




    private String labelCurrentPasswordText = "Aktualne hasło (pozostaw puste, aby nie zmieniać)";
    private String labelNewPasswordText = "Nowe hasło (pozostaw puste, aby nie zmieniać)";
    private String labelConfirmPasswordText = "Potwierdź nowe hasło";



    public String getLabelCurrentPassword() {
        return labelCurrentPassword.getText();
    }

    public String getLabelNewPassword() {
        return labelNewPassword.getText();
    }

    public String getLabelConfirmPassword() {
        return labelConfirmPassword.getText();
    }

    public String getLabelCurrentPasswordText() {
        return labelCurrentPasswordText;
    }

    public String getLabelNewPasswordText() {
        return labelNewPasswordText;
    }

    public String getLabelConfirmPasswordText() {
        return labelConfirmPasswordText;
    }




}
