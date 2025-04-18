package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class DashboardPageTest extends TestBase{

    private DashboardPage dashboardPage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private LoggedInPage loggedInPage;



    @BeforeMethod
    public void setUpDashboardPage() {

        dashboardPage = new DashboardPage(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        loggedInPage = new LoggedInPage(driver);

    }


    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyDashboardPageUrl() {
        mainPage.goToLoginPage();
        loginPage.performLogin();
        loggedInPage.clickDashboardButton();

        Assert.assertEquals(dashboardPage.getDashboardActualUrl(), dashboardPage.getCorrectDashboardUrl(), "Current url is not equal to expected one");

    }

    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyDashboardPageTitle() {
        mainPage.goToLoginPage();
        loginPage.performLogin();
        loggedInPage.clickDashboardButton();

        Assert.assertEquals(dashboardPage.getActualDasboardTitle(), dashboardPage.getCorrectDashboardTitle(), "Current title is not equal to expected one");

    }


}
