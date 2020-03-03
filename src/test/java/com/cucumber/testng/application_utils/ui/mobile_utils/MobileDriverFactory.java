package com.cucumber.testng.application_utils.ui.mobile_utils;

import com.cucumber.testng.project_constants.enams.BrowserType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileUtils.getConnectedDevices;
import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileUtils.launchAllEmulators;
import static com.cucumber.testng.page_objects.UIBasePage.setDriver;
import static com.cucumber.testng.project_constants.constants.Settings.CHROME_DRIVER_PATH;

public class MobileDriverFactory {

    public synchronized static void createAppDriverInstance(BrowserType browserType) throws MalformedURLException {
        launchAllEmulators();
        setDriver(new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities(browserType, false)));
    }

    public synchronized static void createWebDriverInstance(BrowserType browserType) throws MalformedURLException {
        launchAllEmulators();
        setDriver(new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities(browserType, true)));
    }

    public static DesiredCapabilities androidCapabilities(BrowserType browserType, boolean isWebTest) {
        AndroidDriver<AndroidElement> driver;
        File app = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (isWebTest) {
            capabilities.setCapability("deviceName", getConnectedDevices().get(0));
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "10.0");
            capabilities.setCapability("browserName", browserType.name());
            capabilities.setCapability("chromedriverExecutable", CHROME_DRIVER_PATH);

        } else {
            File appDir = new File("src/test/resources/apks");
            app = new File(appDir, "General-Store.apk");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability("fullReset", "False");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 25);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getConnectedDevices().get(0));
        }
        capabilities.setCapability("noReset", true);

        return capabilities;
    }
}
