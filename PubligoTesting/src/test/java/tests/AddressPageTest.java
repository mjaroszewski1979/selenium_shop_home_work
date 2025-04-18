package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class AddressPageTest extends TestBase{

    private AccountDetails accountDetailsPage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private LoggedInPage loggedInPage;
    private AddressPage addressPage;



    @BeforeMethod
    public void setUpAddressPage() {

        accountDetailsPage = new AccountDetails(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        loggedInPage = new LoggedInPage(driver);
        addressPage = new AddressPage(driver);

    }


    @Test
    public void verifyAddressEditionSuccess() {
        mainPage.goToLoginPage();
        loginPage.performLogin();
        loggedInPage.clickAddressButton();
        addressPage.initEditSecondButton();
        addressPage.clickEditSecondButton();
        addressPage.editShippingCompany();
        addressPage.clickEditButtonSave();

        Assert.assertEquals(addressPage.getActualMessageText(), addressPage.getExpectedDivMessage(), "Adres nie został zmieniony.");

    }


}
