package pages;

import helpers.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    private WebDriver driver;
    private Waits wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);

    }

    private String correctBasketUrl = "http://www.selenium-shop.pl/koszyk/";
    private String correctBasketTitle = "Koszyk – Selenium Shop Automatyzacja Testów";

    private int correctNumberOfItems = 6;


    @FindBy(className = "menu-item")
    private List<WebElement> menuItems;

    @FindBy(xpath = "//a[contains(text(), 'Koszyk')]")
    private WebElement menuBasket;

    @FindBy(xpath = "//a[contains(text(), 'Moje konto')]")
    private WebElement menuMojeKonto;

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(className = "entry-title")
    private WebElement productName;


    private String firstProductUrl;
    private String secondProductUrl;
    ArrayList<String> correctMenuItemsNames = new ArrayList<String>() {{
        add("STRONA GŁÓWNA");
        add("ANKIETA");
        add("KOSZYK");
        add("MOJE KONTO");
        add("SKLEP");
        add("ZAMÓWIENIE");
    }};
    ArrayList<String> actualMenuItemNames = new ArrayList<>();



    public int numberOfMenuItems() {
        return menuItems.size();
    }

    public int getCorrectNumberOfItems() {
        return correctNumberOfItems;
    }

    public void clickBasketPageLink() {
        menuBasket.click();
    }

    public String getCorrectBasketUrl() {
        return correctBasketUrl;
    }

    public String getCorrectBasketTitle() {
        return correctBasketTitle;
    }

    public String getCurrentBasketPageUrl() {
        clickBasketPageLink();
        return driver.getCurrentUrl();
    }

    public String getCurrentBasketPageTitle() {
        clickBasketPageLink();
        return driver.getTitle();
    }

    public void goToLoginPage() {
        menuMojeKonto.click();
    }

    public void goToBasketPage() {
        wait.waitForClickability(menuBasket).click();
    }


    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void buyFirstProduct() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByClassName('shop-item-title')[1].click()");
        firstProductUrl = driver.getCurrentUrl();
        clickAddToCartButton();
    }
    public void buySecondProduct() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementsByClassName('shop-item-title')[2].click()");
        secondProductUrl = driver.getCurrentUrl();
        clickAddToCartButton();
    }

    public String getFirstProductUrl() {
        return firstProductUrl;
    }

    public String getSecondProductUrl() {
        return secondProductUrl;
    }

    public ArrayList<String> getActualMenuItemsNames() {
        for(WebElement element: menuItems) {
            actualMenuItemNames.add(element.getText());
        }

        return actualMenuItemNames;
    }


    public ArrayList<String> getCorrectMenuItemsNames() {
        return correctMenuItemsNames;
    }

}


