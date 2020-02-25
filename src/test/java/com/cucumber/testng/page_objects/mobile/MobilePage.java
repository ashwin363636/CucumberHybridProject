package com.cucumber.testng.page_objects.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobilePage extends MobileBasePage{

    public void testMolile() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver1=capabilities();
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver1.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver1.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
    }

    public static  AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver;
        File appDir = new File("src/test/resources/apks");
        File app = new File(appDir, "General-Store.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;
    }
}
