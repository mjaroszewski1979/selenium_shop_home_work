package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class DownloadsPage {


    private WebDriver driver;

    public DownloadsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    private String correctDownloadsUrl = "http://www.selenium-shop.pl/moje-konto/downloads/";

    private String correctDownloadsTitle = "Moje konto – Selenium Shop Automatyzacja Testów";


    public String getDownloadsActualUrl() {
        return driver.getCurrentUrl();
    }

    public String getActualDownloadsTitle() {
        return driver.getTitle();
    }

    public String getCorrectDownloadsTitle() {
        return correctDownloadsTitle;
    }

    public String getCorrectDownloadsUrl() {
        return correctDownloadsUrl;
    }




}
