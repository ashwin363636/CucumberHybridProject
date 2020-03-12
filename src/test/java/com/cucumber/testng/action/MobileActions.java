package com.cucumber.testng.action;

import com.cucumber.testng.application_utils.ui.mobile_utils.MobileDriverFactory;
import com.cucumber.testng.project_constants.constants.Settings;

import java.net.MalformedURLException;

import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileApplicationLauncher.launchMobileAUT;

public class MobileActions {


    public MobileActions() {
    }

    public void launchMobileApplication() throws MalformedURLException {
        MobileDriverFactory.createAppDriverInstance(Settings.BrowserType, false);
        launchMobileAUT()
                .testMobile();
    }
}
