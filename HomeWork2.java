import config.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;
import java.util.List;

public class HomeWork2 extends TestBase {

    private static final String login = PropertiesReader.read("login");
    private static final String password = PropertiesReader.read("password");


    /**
     * Metoda `loginToShop()` realizuje proces logowania użytkownika do sklepu internetowego.
     *
     * Krok po kroku wykonuje następujące czynności:
     * 1. Przechodzi do strony logowania poprzez kliknięcie w zakładkę "Moje konto".
     * 2. Wprowadza nazwę użytkownika do pola loginu.
     * 3. Wprowadza hasło użytkownika do pola hasła.
     * 4. Kliknięciem przycisku logowania wysyła formularz logowania.
     *
     * Metoda zakłada, że pola `login` oraz `password` są dostępne jako zmienne w klasie
     * i zawierają poprawne dane do logowania.
     *
     * Jest to metoda pomocnicza wykorzystywana w wielu testach, gdzie wymagane jest wcześniejsze zalogowanie się do konta użytkownika.
     */
    public void loginToShop() {

        // Znalezienie i kliknięcie w menu "Moje konto", aby przejść do strony logowania
        WebElement menuMojeKonto = driver.findElement(By.xpath("//a[contains(text(), 'Moje konto')]"));
        menuMojeKonto.click();

        // Znalezienie pola loginu i wpisanie nazwy użytkownika
        WebElement loginInput = driver.findElement(By.id("username"));
        loginInput.sendKeys(login);

        // Znalezienie pola hasła i wpisanie hasła użytkownika
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        // Znalezienie i kliknięcie przycisku logowania
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
    }


    /**
     * Metoda `performAction` służy do wykonywania podstawowych akcji na elementach strony internetowej.
     * Pozwala zredukować powtarzający się kod poprzez zdefiniowanie uniwersalnej metody do:
     *
     * - lokalizowania elementu przy pomocy różnych typów lokalizatorów (id, xpath, className, name, css),
     * - wykonywania na nim określonej akcji, takiej jak kliknięcie (click) lub wpisanie tekstu (sendKeys).
     *
     * Parametry:
     * @param locatorType  – typ lokalizatora (np. "id", "xpath", "name", "classname", "css")
     * @param action       – akcja do wykonania na elemencie (np. "click", "sendkeys")
     * @param locatorValue – wartość lokalizatora (np. ID elementu, xpath)
     * @param inputText    – tekst do wpisania, używany tylko w przypadku akcji "sendkeys"
     *
     * Przykład użycia:
     * performAction("id", "sendkeys", "username", "JanKowalski");
     * performAction("xpath", "click", "//button[@type='submit']", "");
     */
    public void performAction(String locatorType, String action, String locatorValue, String inputText) {
        WebElement element;

        // Wybór lokalizatora w zależności od typu (np. id, xpath, className itd.)
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

        // Wykonanie wskazanej akcji na znalezionym elemencie
        switch (action.toLowerCase()) {
            case "click":
                // Kliknięcie w element
                element.click();
                break;
            case "sendkeys":
                // Wyczyszczenie pola i wpisanie tekstu
                element.clear();
                element.sendKeys(inputText);
                break;
            default:
                throw new IllegalArgumentException("Nieobsługiwana akcja: " + action);
        }
    }

    /**
     * Test sprawdzający, czy na stronie sklepu wyświetla się odpowiednia liczba produktów.
     * W tym przypadku test oczekuje, że na stronie widoczne będą dokładnie 8 produkty.
     */
    @Test
    public void verifyNumberOfProducts() {


        // Pobranie listy wszystkich elementów menu nawigacyjnego na stronie
        List<WebElement> productItems = driver.findElements(By.className("shop-item"));

        // Sprawdzenie, czy liczba elementów w menu jest zgodna z oczekiwaną wartością (6)
        Assert.assertEquals(productItems.size(), 8, "Liczba elementów w menu nie jest zgodna z oczekiwaną wartością (10)");

    }

    /**
     * Test sprawdzający, czy liczba złożonych zamówień widocznych na koncie użytkownika
     * jest zgodna z oczekiwaną wartością (w tym przypadku 10).
     */
    @Test
    public void verifyNumberOfOrders() {

        // Logowanie do sklepu przy pomocy wcześniej zdefiniowanej metody pomocniczej
        loginToShop();

        // Kliknięcie w zakładkę „Zamówienia” w panelu użytkownika
        performAction("xpath","click", "//a[contains(text(), 'Zamówienia')]","");

        // Pobranie listy wszystkich elementów menu nawigacyjnego na stronie
        List<WebElement> orderItems = driver.findElements(By.className("woocommerce-orders-table__cell-order-number"));

        // Sprawdzenie, czy liczba elementów w menu jest zgodna z oczekiwaną wartością (6)
        Assert.assertEquals(orderItems.size(), 10, "Liczba elementów w menu nie jest zgodna z oczekiwaną wartością (10)");

    }

    /**
     * Test automatyczny `verifySuccessfulBuyProcess` symuluje pełny proces zakupowy w sklepie internetowym
     * — od dodania produktu do koszyka aż po złożenie zamówienia i weryfikację komunikatu potwierdzającego.
     *
     * Krok po kroku:
     * 1. Kliknięcie w wybrany produkt przy użyciu JavaScript.
     * 2. Wpisanie ilości (5 sztuk) i dodanie produktu do koszyka.
     * 3. Przejście do strony koszyka, wybór metody dostawy i odświeżenie strony.
     * 4. Przejście do finalizacji zamówienia.
     * 5. Wypełnienie formularza z danymi klienta (imię, nazwisko, adres, kontakt).
     * 6. Złożenie zamówienia.
     * 7. Oczekiwanie na pojawienie się komunikatu potwierdzającego złożenie zamówienia.
     * 8. Weryfikacja, czy wyświetlony komunikat zgadza się z oczekiwanym tekstem.
     *
     * Celem testu jest potwierdzenie, że cały proces zakupowy działa prawidłowo i kończy się poprawnym komunikatem.
     */
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
