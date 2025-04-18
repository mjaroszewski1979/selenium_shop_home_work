package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ForgotPasswordPage {


    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    private String correctForgotUrl = "http://www.selenium-shop.pl/moje-konto/lost-password/";

    private String correctForgotTitle = "Moje konto – Selenium Shop Automatyzacja Testów";


    public String getForgotActualUrl() {
        return driver.getCurrentUrl();
    }

    public String getActualForgotTitle() {
        return driver.getTitle();
    }

    public String getCorrectForgotTitle() {
        return correctForgotTitle;
    }

    public String getCorrectForgotUrl() {
        return correctForgotUrl;
    }




}
