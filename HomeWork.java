import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork extends TestBase{

    public void loginToShop() {

        // Znalezienie i kliknięcie w menu "Moje konto", aby przejść do strony logowania
        WebElement menuMojeKonto = driver.findElement(By.xpath("//a[contains(text(), 'Moje konto')]"));
        menuMojeKonto.click();

        // Znalezienie pola loginu i wpisanie nazwy użytkownika
        WebElement loginInput = driver.findElement(By.id("username"));
        loginInput.sendKeys("UserTest1");

        // Znalezienie pola hasła i wpisanie hasła użytkownika
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Automatyzacjaselenium1");

        // Znalezienie i kliknięcie przycisku logowania
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
    };


    @Test
    public void verifyChangePasswordForm() {

        // Logowanie do sklepu przed przejściem do formularza zmiany hasła
        loginToShop();

        // Znalezienie i kliknięcie przycisku "Szczegóły konta", aby przejść do ustawień konta
        WebElement accountDetailsButton = driver.findElement(By.xpath("//a[contains(text(), 'Szczegóły konta')]"));
        accountDetailsButton.click();

        // Znalezienie etykiety dla pola "Aktualne hasło"
        WebElement labelCurrentPassword = driver.findElement(By.xpath("//label[contains(text(), 'Aktualne hasło (pozostaw puste, aby nie zmieniać)')]"));

        // Znalezienie etykiety dla pola "Nowe hasło"
        WebElement labelNewPassword = driver.findElement(By.xpath("//label[contains(text(), 'Nowe hasło (pozostaw puste, aby nie zmieniać)')]"));

        // Znalezienie etykiety dla pola "Potwierdź nowe hasło"
        WebElement labelConfirmPassword = driver.findElement(By.xpath("//label[contains(text(), 'Potwierdź nowe hasło')]"));

        // Oczekiwane teksty etykiet formularza zmiany hasła
        String labelCurrentPasswordText = "Aktualne hasło (pozostaw puste, aby nie zmieniać)";
        String labelNewPasswordText = "Nowe hasło (pozostaw puste, aby nie zmieniać)";
        String labelConfirmPasswordText = "Potwierdź nowe hasło";

        // Sprawdzenie, czy rzeczywiste teksty etykiet zgadzają się z oczekiwanymi wartościami
        Assert.assertTrue(
                (labelConfirmPassword.getText().equals(labelConfirmPasswordText)) &&
                        (labelNewPassword.getText().equals(labelNewPasswordText)) &&
                        (labelCurrentPassword.getText().equals(labelCurrentPasswordText)),
                "Rzeczywisty tekst etykiet nie zgadza się z oczekiwanymi wartościami"

        );

    }

    @Test
    public void verifyDownloadFilesSectionText() {

        // Logowanie do sklepu przed przejściem do sekcji "Pliki do pobrania"
        loginToShop();

        // Znalezienie i kliknięcie przycisku "Pliki do pobrania", aby przejść do odpowiedniej sekcji
        WebElement downloadFilesButton = driver.findElement(By.xpath("//a[contains(text(), 'Pliki do pobrania')]"));
        downloadFilesButton.click();

        // Znalezienie elementu z wiadomością informującą o braku dostępnych plików
        WebElement messageDiv = driver.findElement(By.className("woocommerce-Message--info"));

        // Oczekiwany tekst komunikatu w sekcji "Pliki do pobrania"
        String messageDivText = "Pliki do pobrania nie są jeszcze dostępne.";

        // Sprawdzenie, czy rzeczywisty tekst komunikatu jest zgodny z oczekiwanym
        Assert.assertTrue(messageDiv.getText().contains(messageDivText),
                "Tekst komunikatu nie zawiera oczekiwanej frazy: " + messageDivText);


    }

    @Test
    public void verifyNavbarMenuItemsCount() {

        // Pobranie listy wszystkich elementów menu nawigacyjnego na stronie
        List<WebElement> menuItems = driver.findElements(By.className("menu-item"));

        // Sprawdzenie, czy liczba elementów w menu jest zgodna z oczekiwaną wartością (6)
        Assert.assertEquals(menuItems.size(), 6, "Liczba elementów w menu nie jest zgodna z oczekiwaną wartością (6)");
    }


}
