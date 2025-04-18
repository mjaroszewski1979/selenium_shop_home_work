package tests;

import config.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class OrderReceivedPageTest extends TestBase{


    private MainPage mainPage;
    private BasketPage basketPage;
    private NewOrderPage newOrderPage;
    private OrderReceivedPage orderReceivedPage;

    private static final String url = PropertiesReader.read("url");




    @BeforeMethod
    public void setUpOrderReceivedPage() {


        mainPage = new MainPage(driver);
        basketPage = new BasketPage(driver);
        newOrderPage = new NewOrderPage(driver);
        orderReceivedPage = new OrderReceivedPage(driver);


    }


    @Test(priority = 10, enabled = true, description = "to jest fajny test")
    public void verifyBuyingProcess() {
        mainPage.buyFirstProduct();
        driver.get(url);
        mainPage.buySecondProduct();
        mainPage.goToBasketPage();
        basketPage.selectShippingRadioButton();
        basketPage.performCheckout();
        newOrderPage.performPlacingOrder();


        Assert.assertTrue((orderReceivedPage.isFirstProductDisplayed(mainPage.getFirstProductUrl())) &&
                (orderReceivedPage.isSecondProductDisplayed(mainPage.getSecondProductUrl())));
    }




}
