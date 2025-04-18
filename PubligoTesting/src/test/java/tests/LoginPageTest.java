package tests;

import config.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginPageTest extends TestBase{

    private LoginPage loginPage;
    private MainPage mainPage;

    private static final String tempMail = PropertiesReader.read("tempMail");


    @BeforeMethod
    public void setUpLoginPage() {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    public void verifyRegistrationSuccess() {
        mainPage.goToLoginPage();
        loginPage.performRegistration();
        System.out.println(loginPage.getActualMessage());
        System.out.println(loginPage.getMessageStrongText());


        Assert.assertTrue(loginPage.getActualMessage().equals(loginPage.getMessageStrongText()) && loginPage.isLogoutButtonDisplayed());


    }





}
