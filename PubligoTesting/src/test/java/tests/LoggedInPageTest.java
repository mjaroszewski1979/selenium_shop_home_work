package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoggedInPage;
import pages.LoginPage;


public class LoggedInPageTest extends TestBase{

    private LoggedInPage loggedInPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpLoggedInPage() {

        loggedInPage = new LoggedInPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void verifyLoginWithCorrectCredentials() {

        loginPage.performLogin();

        Assert.assertTrue(loggedInPage.isLogoutButtonIsDisplayed());


    }


}
