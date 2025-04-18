package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class OrdersPageTest extends TestBase{

    private OrdersPage ordersPage;
    private MainPage mainPage;
    private LoginPage loginPage;
    private LoggedInPage loggedInPage;



    @BeforeMethod
    public void setUpOrdersPage() {

        ordersPage = new OrdersPage(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        loggedInPage = new LoggedInPage(driver);

    }


    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyOrdersPageUrl() {
        mainPage.goToLoginPage();
        loginPage.performLogin();
        loggedInPage.clickOrdersButton();

        Assert.assertEquals(ordersPage.getOrdersActualUrl(), ordersPage.getCorrectOrdersUrl(), "Current url is not equal to expected one");

    }

    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyOrdersPageTitle() {
        mainPage.goToLoginPage();
        loginPage.performLogin();
        loggedInPage.clickOrdersButton();

        Assert.assertEquals(ordersPage.getActualOrdersTitle(), ordersPage.getCorrectOrdersTitle(), "Current title is not equal to expected one");

    }


}
