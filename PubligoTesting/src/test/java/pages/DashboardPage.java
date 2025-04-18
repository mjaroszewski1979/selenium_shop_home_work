package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class DashboardPage {


    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    private String correctDashboardUrl = "http://www.selenium-shop.pl/moje-konto/";

    private String correctDasboardTitle = "Moje konto – Selenium Shop Automatyzacja Testów";


    public String getDashboardActualUrl() {
        return driver.getCurrentUrl();
    }

    public String getActualDasboardTitle() {
        return driver.getTitle();
    }

    public String getCorrectDashboardTitle() {
        return correctDasboardTitle;
    }

    public String getCorrectDashboardUrl() {
        return correctDashboardUrl;
    }




}
