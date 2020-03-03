package com.cucumber.testng.application_utils.ui.mobile_utils;

import com.cucumber.testng.page_objects.mobile.MobilePage;

import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileObjects.waitforElementTobevisible;

public class MobileApplicationLauncher {

    private static final String NAME_FIELD_INPUT = "//*[@resource-id='com.androidsample.generalstore:id/nameField']";

    public static MobilePage launchMobileAUT() {
        waitforElementTobevisible(NAME_FIELD_INPUT);
        return new MobilePage();
    }
}
