package com.cucumber.testng.action;

import com.cucumber.testng.application_utils.ui.mobile_utils.MobileDriverFactory;
import com.cucumber.testng.page_objects.mobile.MobilePage;
import com.cucumber.testng.page_objects.web.LoginPage;
import com.cucumber.testng.project_constants.constants.Settings;

import java.net.MalformedURLException;

import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileApplicationLauncher.launchMobileAUT;
import static com.cucumber.testng.application_utils.ui.web_utils.WebApplicationLauncher.launchWebZeroMoney;

public class MobileActions {

    private MobilePage mobilePage;
    private LoginPage loginPage;

    public MobileActions(MobilePage mobilePage, LoginPage loginPage) {
        this.mobilePage = mobilePage;
        this.loginPage = loginPage;
    }

    public void launchMobileApplication() throws MalformedURLException {
        MobileDriverFactory.createAppDriverInstance(Settings.BrowserType);
        launchMobileAUT()
                .testMobile();
    }

    public void launchMobileWebApplication() throws MalformedURLException {
        MobileDriverFactory.createWebDriverInstance(Settings.BrowserType);
        launchWebZeroMoney()
                .search();
    }
}
