package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;
import java.util.List;

public class ShopSelenium extends TestBase {





    @Test
    public void verifyMainPageTitle() {

        String correctMainTitle = "Selenium Shop Automatyzacja Testów";

        WebElement menuMain = driver.findElement(By.xpath("//*[@id=\"menu-item-133\"]/a"));
        menuMain.click();
        String currentMainTitle = driver.getTitle();

        System.out.println("Tytul strony "  + currentMainTitle);

        Assert.assertEquals(currentMainTitle, correctMainTitle, "Current title is not equal to expected one");

    }

    @Test
    public void verifyMainPageUrl() {

        String correctMainUrl = "http://www.selenium-shop.pl/";

        WebElement menuMain = driver.findElement(By.xpath("//*[@id=\"menu-item-133\"]/a"));
        menuMain.click();
        String currentMainUrl = driver.getCurrentUrl();

        System.out.println("Url strony "  + currentMainUrl);

        Assert.assertEquals(currentMainUrl, correctMainUrl, "Current url is not equal to expected one");

    }

    @Test
    public void verifyAnkietaPageTitle() {

        String correctAnkietaTitle = "Ankieta – Selenium Shop Automatyzacja Testów";

        WebElement menuAnkieta = driver.findElement(By.xpath("//*[@id=\"menu-item-134\"]/a"));
        menuAnkieta.click();
        String currentAnkietaTitle = driver.getTitle();

        System.out.println("Tytul strony "  + currentAnkietaTitle);

        Assert.assertEquals(currentAnkietaTitle, correctAnkietaTitle, "Current title is not equal to expected one");

    }

    @Test
    public void verifyAnkietaPageUrl() {

        String correctAnkietaUrl = "http://www.selenium-shop.pl/o-nas/";

        WebElement menuAnkieta = driver.findElement(By.xpath("//*[@id=\"menu-item-134\"]/a"));
        menuAnkieta.click();
        String currentAnkietaUrl = driver.getCurrentUrl();

        System.out.println("Url strony "  + currentAnkietaUrl);

        Assert.assertEquals(currentAnkietaUrl, correctAnkietaUrl, "Current url is not equal to expected one");

    }


    @Test
    public void verifySklepPageTitle() {

        String correctSklepTitle = "Produkty – Selenium Shop Automatyzacja Testów";

        WebElement menuSklep = driver.findElement(By.xpath("//*[@id=\"menu-item-137\"]/a"));
        menuSklep.click();
        String currentSklepTitle = driver.getTitle();

        System.out.println("Tytul strony "  + currentSklepTitle);

        Assert.assertEquals(currentSklepTitle, correctSklepTitle, "Current title is not equal to expected one");

    }

    @Test
    public void verifySklepPageUrl() {

        String correctSklepUrl = "http://www.selenium-shop.pl/sklep/";

        WebElement menuSklep = driver.findElement(By.xpath("//*[@id=\"menu-item-137\"]/a"));
        menuSklep.click();
        String currentSklepUrl = driver.getCurrentUrl();

        System.out.println("Url strony "  + currentSklepUrl);

        Assert.assertEquals(currentSklepUrl, correctSklepUrl, "Current url is not equal to expected one");

    }



    @Test
    public void verifyNumberOfProducts() {


        // Pobranie listy wszystkich elementów menu nawigacyjnego na stronie
        List<WebElement> productItems = driver.findElements(By.className("shop-item"));

        // Sprawdzenie, czy liczba elementów w menu jest zgodna z oczekiwaną wartością (6)
        Assert.assertEquals(productItems.size(), 8, "Liczba elementów w menu nie jest zgodna z oczekiwaną wartością (10)");

    }



    public void performAction(String locatorType, String action, String locatorValue, String inputText) {
        WebElement element;

        // Wybór lokalizatora
        switch (locatorType.toLowerCase()) {
            case "id":
                element = driver.findElement(By.id(locatorValue));
                break;
            case "xpath":
                element = driver.findElement(By.xpath(locatorValue));
                break;
            case "classname":
                element = driver.findElement(By.className(locatorValue));
                break;
            case "name":
                element = driver.findElement(By.name(locatorValue));
                break;
            case "css":
                element = driver.findElement(By.cssSelector(locatorValue));
                break;
            default:
                throw new IllegalArgumentException("Nieobsługiwany typ lokalizatora: " + locatorType);
        }

        // Wykonanie akcji
        switch (action.toLowerCase()) {
            case "click":
                element.click();
                break;
            case "sendkeys":
                element.clear();
                element.sendKeys(inputText);
                break;
            default:
                throw new IllegalArgumentException("Nieobsługiwana akcja: " + action);
        }
    }

    @Test
    public void verifyNumberOfOrders() {




        performAction("xpath","click", "//a[contains(text(), 'Zamówienia')]","");

        // Pobranie listy wszystkich elementów menu nawigacyjnego na stronie
        List<WebElement> orderItems = driver.findElements(By.className("woocommerce-orders-table__cell-order-number"));

        // Sprawdzenie, czy liczba elementów w menu jest zgodna z oczekiwaną wartością (6)
        Assert.assertEquals(orderItems.size(), 10, "Liczba elementów w menu nie jest zgodna z oczekiwaną wartością (10)");

    }

    @Test
    public void verifySuccessfulBuyProcess() {

        // Tworzenie obiektu do wykonywania JavaScriptu w przeglądarce
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // Kliknięcie w drugi produkt na liście (indeks 1) przy użyciu JavaScriptu
        js.executeScript("document.getElementsByClassName('shop-item-title')[1].click()");
        // Wpisanie ilości produktu (5 sztuk)
        performAction("name", "sendkeys", "quantity", "5");
        // Kliknięcie przycisku "Dodaj do koszyka"
        performAction("name", "click", "add-to-cart", "");
        // Przejście do strony koszyka
        performAction("xpath", "click", "//a[contains(text(), 'Koszyk')]", "");
        // Wybór metody dostawy – zaznaczenie odpowiedniego radio buttona
        WebElement shippingRadioButton = driver.findElement(By.id("shipping_method_0_flat_rate1"));
        // Zaznaczenie opcji jeśli nie jest wybrana
        if (!shippingRadioButton.isSelected()) {
            shippingRadioButton.click();
        }
        // Odświeżenie strony, aby zatwierdzić wybór dostawy
        driver.navigate().refresh();
        // Przejście do strony finalizacji zamówienia
        performAction("className", "click", "checkout-button", "");
        // Wypełnienie formularza zamówienia – dane osobowe i adresowe
        performAction("id", "sendkeys", "billing_first_name", "Marcin");
        performAction("id", "sendkeys", "billing_last_name", "Kowalski");
        performAction("id", "sendkeys", "billing_address_1", "armii krajowej");
        performAction("id", "sendkeys", "billing_postcode", "61-300");
        performAction("id", "sendkeys", "billing_city", "poznan");
        performAction("id", "sendkeys", "billing_phone", "500300400");
        performAction("id", "sendkeys", "billing_email", "marcin@gmail.com");
        // Kliknięcie przycisku „Zamawiam”
        performAction("id", "click", "place_order", "");
        // Oczekiwanie na pojawienie się komunikatu potwierdzającego złożenie zamówienia
        WebElement successParagraph = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//p[contains(text(), 'Dziękujemy. Otrzymaliśmy Twoje zamówienie.')]")));
        // Sprawdzenie, czy treść komunikatu potwierdzającego jest zgodna z oczekiwanym tekstem
        String successMessage = "Dziękujemy. Otrzymaliśmy Twoje zamówienie.";
        Assert.assertEquals(successParagraph.getText(), successMessage);

    }

}
