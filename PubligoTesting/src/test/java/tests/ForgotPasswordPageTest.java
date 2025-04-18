package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ForgotPasswordPageTest extends TestBase{


    private MainPage mainPage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;




    @BeforeMethod
    public void setUpForgotPasswordPage() {

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);


    }


    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyForgotPageUrl() {
        mainPage.goToLoginPage();
        loginPage.clickForgotPasswordButton();

        Assert.assertEquals(forgotPasswordPage.getForgotActualUrl(), forgotPasswordPage.getCorrectForgotUrl(), "Current url is not equal to expected one");

    }

    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyForgotPageTitle() {
        mainPage.goToLoginPage();
        loginPage.clickForgotPasswordButton();

        Assert.assertEquals(forgotPasswordPage.getActualForgotTitle(), forgotPasswordPage.getCorrectForgotTitle(), "Current title is not equal to expected one");

    }


}
