package com.cucumber.testng.application_utils.ui.web_utils;

import com.cucumber.testng.project_constants.enams.BrowserType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.cucumber.testng.page_objects.UIBasePage.getDriver;
import static com.cucumber.testng.page_objects.UIBasePage.setDriver;
import static com.cucumber.testng.project_constants.constants.Settings.CHROME_DRIVER_PATH;
import static com.cucumber.testng.project_constants.constants.Settings.toBeRunOnZalenium;
import static java.lang.System.getProperty;

public class WebDriverFactory {
    public static final int IMPLICITLY_WAIT = 25;//in seconds
    private static final String VIEW = "view";

    public synchronized static void createDriverInstance(BrowserType browserType) throws IOException {
        if (browserType.name().toLowerCase().contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            RemoteWebDriver _driver;
            if (toBeRunOnZalenium) {
                _driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getChromeCapabilities());
            } else {
                _driver = new ChromeDriver();
            }
            setWebDimensions(_driver);
            _driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
            setDriver(_driver);
        }
    }

    private static Capabilities getChromeCapabilities() {
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        return cap;
    }

    private static void setWebDimensions(RemoteWebDriver driver) throws IOException {
        Properties dimensionProfile = new Properties();
        //Load the Property file available in same package
        InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\cucumber\\testng\\configs\\Web_profile\\" + getProperty(VIEW).toLowerCase() + ".properties");
        dimensionProfile.load(inputStream);
        driver.manage().window().setSize(new Dimension(Integer.parseInt(dimensionProfile.getProperty("browser.width")), Integer.parseInt(dimensionProfile.getProperty("browser.height"))));
    }

    public static void closeDriver() {
        getDriver().quit();
    }
}
