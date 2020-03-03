package com.cucumber.testng.step_definition;

import com.cucumber.testng.action.MobileActions;
import io.cucumber.java.en.Given;

import java.net.MalformedURLException;

public class MobileStepDef {

    private MobileActions mobileActions;

    public MobileStepDef(MobileActions mobileActions) {
        this.mobileActions = mobileActions;
    }

    @Given("Open mobile app")
    public void open_mobile_app() throws MalformedURLException {
        mobileActions.launchMobileApplication();
    }

    @Given("Open Application in mobile view and Enter url")
    public void open_Application_in_mobile_view_and_Enter_url() throws MalformedURLException {
        mobileActions.launchMobileWebApplication();
    }
}
