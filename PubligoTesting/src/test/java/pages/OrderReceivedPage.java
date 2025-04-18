package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderReceivedPage {


    private WebDriver driver;


    public OrderReceivedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }





    public boolean isFirstProductDisplayed(String url) {
        String xpathFirst = String.format("//a[contains(@href, '%s')]", url);
        WebElement firstProduct  = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(xpathFirst)));
        return firstProduct.isDisplayed();
    }

    public boolean isSecondProductDisplayed(String url) {
        String xpathSecond = String.format("//a[contains(@href, '%s')]", url);
        WebElement secondProduct  = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath(xpathSecond)));
        return secondProduct.isDisplayed();
    }





}
