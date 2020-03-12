package com.cucumber.testng.application_utils.ui.mobile_utils;

import com.cucumber.testng.project_constants.constants.Settings;
import com.cucumber.testng.project_constants.enams.BrowserType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileUtils.getConnectedDevices;
import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileUtils.launchAllEmulators;
import static com.cucumber.testng.page_objects.UIBasePage.setDriver;
import static com.cucumber.testng.project_constants.constants.Settings.CHROME_DRIVER_74_PATH;

public class MobileDriverFactory {

    public synchronized static void createAppDriverInstance(BrowserType browserType, boolean isWebTest) throws MalformedURLException {
        launchAllEmulators();
        setDriver(new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities(browserType, isWebTest)));
    }

    public static DesiredCapabilities androidCapabilities(BrowserType browserType, boolean isWebTest) {
        File app = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getConnectedDevices().get(0));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("noReset", true);
        if (isWebTest) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserType.name());
            capabilities.setCapability("chromedriverExecutable", CHROME_DRIVER_74_PATH);
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
        } else {
            File appDir = new File("src/test/resources/apks");
            app = new File(appDir, Settings.GS_APP);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability("fullReset", "False");
            capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 25);

        }
        return capabilities;
    }
}
