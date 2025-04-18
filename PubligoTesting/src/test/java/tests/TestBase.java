package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import config.ExtentReportManager;
import config.PropertiesReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


import java.lang.reflect.Method;
import java.util.Base64;

public class TestBase {
    public WebDriver driver = null;
    private static ExtentReports extent = ExtentReportManager.getInstance();
    protected ExtentTest test;

    private static final String url = PropertiesReader.read("url");
    private static final String browser = PropertiesReader.read("browser");

    @BeforeMethod
    public void setUp(Method method) {

        test = extent.createTest(method.getName());

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-application-cache");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--start-maximized");
            edgeOptions.addArguments("--disable-popup-blocking");
            edgeOptions.addArguments("--disable-application-cache");
            driver = new EdgeDriver(edgeOptions);

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            firefoxOptions.addPreference("browser.cache.disk.enable", false);
            firefoxOptions.addPreference("dom.webnotifications.enabled", false);
            driver = new FirefoxDriver(firefoxOptions);

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }


        driver.get(url);
    }

    @AfterMethod
    public void cleanUp(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test NIEPOWODZENIE: " + result.getThrowable());
            test.addScreenCaptureFromBase64String(takeScreenshot(), "Zrzut ekranu z błędem");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test zakończył się sukcesem");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test został pominięty: " + result.getThrowable());
        }

        driver.quit();
        extent.flush(); // 🔹 Zapisujemy raport HTML po każdym teście
    }

    private String takeScreenshot() {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return Base64.getEncoder().encodeToString(screenshot);
    }

}
