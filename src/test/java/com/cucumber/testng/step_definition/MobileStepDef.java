package com.cucumber.testng.step_definition;

import com.cucumber.testng.action.BoxActions;
import com.cucumber.testng.action.LoginActions;
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
}
