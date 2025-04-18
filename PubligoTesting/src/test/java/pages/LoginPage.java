package pages;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private static final String login = PropertiesReader.read("login");
    private static final String password = PropertiesReader.read("password");
    private static final String tempMail = PropertiesReader.read("tempMail");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(id = "reg_email")
    private WebElement registrationInput;

    @FindBy(className = "woocommerce-form-register__submit")
    private WebElement registrationButton;

    @FindBy(linkText = "Wyloguj się")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"post-9\"]/div/div/div/p[1]/strong[1]")
    private WebElement messageStrong;

    @FindBy(linkText = "Nie pamiętasz hasła?")
    private WebElement forgotPasswordButton;







    public void performLogin() {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void performRegistration() {
        registrationInput.clear();
        registrationInput.sendKeys(tempMail);
        registrationButton.click();
    }

    public String cropEmail(String email) {
        if (email != null && email.contains("@")) {
            return email.substring(0, email.indexOf("@"));
        }
        return "";
    }

    public void clickForgotPasswordButton() {
        forgotPasswordButton.click();
    }


    public String getActualMessage() {
        return cropEmail(tempMail);

    }

    public String getMessageStrongText() {
        return messageStrong.getText();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }






}
