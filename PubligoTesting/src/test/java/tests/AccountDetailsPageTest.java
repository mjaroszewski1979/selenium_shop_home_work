package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountDetails;
import pages.LoggedInPage;
import pages.LoginPage;
import pages.MainPage;

public class AccountDetailsPageTest extends TestBase{

    private AccountDetails accountDetailsPage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private LoggedInPage loggedInPage;



    @BeforeMethod
    public void setUpAccountDetailsPage() {

        accountDetailsPage = new AccountDetails(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        loggedInPage = new LoggedInPage(driver);
    }


    @Test
    public void verifyChangePasswordForm() {
        mainPage.goToLoginPage();
        loginPage.performLogin();
        loggedInPage.goToAccountDetails();

        Assert.assertTrue(
                (accountDetailsPage.getLabelCurrentPassword().equals(accountDetailsPage.getLabelCurrentPasswordText())) &&
                        (accountDetailsPage.getLabelNewPassword().equals(accountDetailsPage.getLabelNewPasswordText())) &&
                        (accountDetailsPage.getLabelConfirmPassword().equals(accountDetailsPage.getLabelConfirmPasswordText())),
                "Rzeczywisty tekst etykiet nie zgadza się z oczekiwanymi wartościami"

        );




    }


}
