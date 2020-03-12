package com.cucumber.testng.step_definition;

import com.cucumber.testng.action.MobileActions;
import com.cucumber.testng.action.ZeroBankAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class MobileStepDef {

    private MobileActions mobileActions;
    private ZeroBankAction zeroBankAction;

    public MobileStepDef(MobileActions mobileActions, ZeroBankAction zeroBankAction) {
        this.mobileActions = mobileActions;
        this.zeroBankAction = zeroBankAction;
    }

    @Given("Open mobile app")
    public void open_mobile_app() throws MalformedURLException {
        mobileActions.launchMobileApplication();
    }

    @Given("Open Application in mobile view and Enter url")
    public void open_Application_in_mobile_view_and_Enter_url() throws MalformedURLException {
        zeroBankAction.launchMobileWebApplication();
    }

    @When("user enter {string} and {string} in Zero BAnk App")
    public void user_enter_and_in_Zero_BAnk_App(String username, String password) {
        zeroBankAction.loginToZeroBank(username, password);
    }
}
