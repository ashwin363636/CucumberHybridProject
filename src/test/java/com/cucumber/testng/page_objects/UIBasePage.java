package com.cucumber.testng.page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UIBasePage {

    private static ThreadLocal<RemoteWebDriver> drivers = new ThreadLocal<RemoteWebDriver>();

    public static synchronized void setDriver(RemoteWebDriver driver) {
        drivers.set(driver);
    }

    public static synchronized RemoteWebDriver getDriver() {
        if (isMobileDriver()) {
            return ((AppiumDriver<WebElement>) drivers.get());
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
}
