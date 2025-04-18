package pages;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class LoggedInPage {


    private WebDriver driver;

    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[contains(text(), 'Wyloguj')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(), 'Szczegóły konta')]")
    private WebElement accountDetailsButton;

    @FindBy(xpath = "//a[contains(text(), 'Adresy')]")
    private WebElement addressButton;

    @FindBy(xpath = "//a[contains(text(), 'Kokpit')]")
    private WebElement dashboardButton;

    @FindBy(xpath = "//a[contains(text(), 'Zamówienia')]")
    private WebElement ordersButton;

    @FindBy(xpath = "//a[contains(text(), 'Pliki do pobrania')]")
    private WebElement downloadsButton;

    public void goToAccountDetails() {
        accountDetailsButton.click();
    }

    public boolean isLogoutButtonIsDisplayed() {
        boolean status = logoutButton.isDisplayed();

        return status;
    }

    public void clickAddressButton() {
        addressButton.click();
    }

    public void clickDashboardButton() {
        dashboardButton.click();
    }

    public void clickOrdersButton() {
        ordersButton.click();
    }

    public void clickDownloadsButton() {
        downloadsButton.click();
    }






}
