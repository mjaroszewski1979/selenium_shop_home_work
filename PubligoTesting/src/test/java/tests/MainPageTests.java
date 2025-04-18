package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;


public class MainPageTests extends TestBase{

    private MainPage mainPage;

    @BeforeMethod
    public void setUpMainPage() {
        mainPage = new MainPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyNavbarMenuItemsCount() {


        // Sprawdzenie, czy liczba elementów w menu jest zgodna z oczekiwaną wartością (6)
        Assert.assertEquals(mainPage.numberOfMenuItems(), mainPage.getCorrectNumberOfItems(), "Liczba elementów w menu nie jest zgodna z oczekiwaną wartością (6)");
    }

    @Test(priority = 30, enabled = true)
    public void verifyBasketPageUrl() {
        Assert.assertEquals(mainPage.getCurrentBasketPageUrl(), mainPage.getCorrectBasketUrl(), "Current url is not equal to expected one");
    }

    @Test(priority = 20, enabled = true, description = "to jest fajny test")
    public void verifyBasketPageTitle() {
        Assert.assertEquals(mainPage.getCurrentBasketPageTitle(), mainPage.getCorrectBasketTitle(), "Current title is not equal to expected one");
    }

    @Test(priority = 20, enabled = true, description = "to jest fajny test")
    public void verifyNavbarItemsNames() {
        Assert.assertEquals(mainPage.getActualMenuItemsNames(), mainPage.getCorrectMenuItemsNames(), "dupa jsiu");
    }

}
