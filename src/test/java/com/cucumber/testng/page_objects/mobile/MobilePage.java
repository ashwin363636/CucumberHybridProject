package com.cucumber.testng.page_objects.mobile;

import com.cucumber.testng.page_objects.UIBasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileObjects.click;
import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileObjects.input;

public class MobilePage extends UIBasePage {

    private static final By NAME_FIELD_INPUT = MobileBy.xpath("//*[@resource-id='com.androidsample.generalstore:id/nameField']");
    private static final By SUBMIT_BTN = MobileBy.id("com.androidsample.generalstore:id/btnLetsShop");

    public void testMobile() {
        input(NAME_FIELD_INPUT, "Hello");
        click(SUBMIT_BTN);
    }
}
