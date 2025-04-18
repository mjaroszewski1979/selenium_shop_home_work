package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class DownloadsPageTest extends TestBase{

    private DownloadsPage downloadsPage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private LoggedInPage loggedInPage;



    @BeforeMethod
    public void setUpDownloadsPage() {

        downloadsPage = new DownloadsPage(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        loggedInPage = new LoggedInPage(driver);

    }


    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyDownloadsPageUrl() {
        mainPage.goToLoginPage();
        loginPage.performLogin();
        loggedInPage.clickDownloadsButton();

        Assert.assertEquals(downloadsPage.getDownloadsActualUrl(), downloadsPage.getCorrectDownloadsUrl(), "Current url is not equal to expected one");

    }

    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyDownloadsPageTitle() {
        mainPage.goToLoginPage();
        loginPage.performLogin();
        loggedInPage.clickDashboardButton();

        Assert.assertEquals(downloadsPage.getActualDownloadsTitle(), downloadsPage.getCorrectDownloadsTitle(), "Current title is not equal to expected one");

    }


}
