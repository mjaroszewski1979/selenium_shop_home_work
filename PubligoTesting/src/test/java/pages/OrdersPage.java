package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class OrdersPage {


    private WebDriver driver;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    private String correctOrdersUrl = "http://www.selenium-shop.pl/moje-konto/orders/";

    private String correctOrdersTitle = "Moje konto – Selenium Shop Automatyzacja Testów";


    public String getOrdersActualUrl() {
        return driver.getCurrentUrl();
    }

    public String getActualOrdersTitle() {
        return driver.getTitle();
    }

    public String getCorrectOrdersTitle() {
        return correctOrdersTitle;
    }

    public String getCorrectOrdersUrl() {
        return correctOrdersUrl;
    }




}
