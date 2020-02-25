package com.cucumber.testng.action;

import com.cucumber.testng.application_utils.web_utils.WebDriverFactory;
import com.cucumber.testng.page_objects.mobile.MobilePage;
import com.cucumber.testng.page_objects.web.BoxPage;
import com.cucumber.testng.page_objects.web.LoginPage;
import com.cucumber.testng.page_objects.web.MenuPage;
import com.cucumber.testng.project_constants.constants.Settings;

import java.net.MalformedURLException;

import static com.cucumber.testng.application_utils.web_utils.WebApplicationLauncher.launchAUT;

public class MobileActions {

    private MobilePage mobilePage;

    public MobileActions(MobilePage mobilePage){
        this.mobilePage = mobilePage;
    }

    public void launchMobileApplication() throws MalformedURLException {
        mobilePage.testMolile();
    }
}
