package com.cucumber.testng.application_utils.ui.web_utils;

import com.cucumber.testng.page_objects.web.ifmdx.LoginPage;
import com.cucumber.testng.page_objects.web.zb_pages.ZBLandingPage;
import com.cucumber.testng.project_constants.constants.Settings;

import static com.cucumber.testng.page_objects.UIBasePage.getDriver;

public class WebApplicationLauncher {

    public static LoginPage launchWebAUT() {
        getDriver().get(Settings.IMX_URL);
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }

    public static ZBLandingPage launchWebZeroMoney() {
        getDriver().get(Settings.ZB_URL);
        return new ZBLandingPage();
    }
}
