package com.cucumber.testng.page_objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.cucumber.testng.application_utils.ui.web_utils.WebDriverFactory.IMPLICITLY_WAIT;

public class UIBasePage {

    private static ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<RemoteWebDriver>();

    public static synchronized void setDriver(RemoteWebDriver driver) {
        drivers.set(driver);
    }

    public static synchronized RemoteWebDriver getDriver() {
        drivers.get().manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
        if (isMobileDriver()) {
            return ((AndroidDriver) drivers.get());
        } else
            return drivers.get();

    }

    public static boolean isMobileDriver() {
        if (drivers.get() instanceof AndroidDriver) {
            return true;
        } else {
            return false;
        }
    }

    public static AndroidDriver getAndroidDriver() {
        return (AndroidDriver) getDriver();
    }

    /*Method to get Class from a String value*/
    public Object getClassOf(String pattern) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(pattern).newInstance();
    }
}
