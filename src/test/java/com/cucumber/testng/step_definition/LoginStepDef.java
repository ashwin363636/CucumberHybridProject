package com.cucumber.testng.step_definition;

import com.cucumber.testng.action.BoxActions;
import com.cucumber.testng.action.LoginActions;
import com.cucumber.testng.model.LoginCredentials;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginStepDef {

    private LoginCredentials loginCredentials;
    private LoginActions loginActions;
    private BoxActions boxActions;

    public LoginStepDef(LoginActions loginActions, BoxActions boxActions, LoginCredentials loginCredentials) {
        this.loginActions = loginActions;
        this.boxActions = boxActions;
        this.loginCredentials = loginCredentials;
    }

    @Given("^Open Application and Enter url$")
    public void open_Application_and_Enter_url() throws IOException {
        System.out.println("Calling Login Action to launch  the application");
        loginActions.launchApplication();
    }

    @When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter(String username, String password) {
        System.out.println("Perform Login Action");
        this.loginCredentials.setUsername(username);
        this.loginCredentials.setPassword(password);
        loginActions.performLogin(loginCredentials);
    }

    @Then("^verify I see Logout Link$")
    public void verify_I_see_Logout_Link() {
        System.out.println("Verifying logout link");
        assertTrue(loginActions.isLogoutLinkVisible());
    }

    @Then("^I see failed status$")
    public void i_see_failed_status() throws Throwable {
        System.out.println("Assert a failure");
        assertTrue(false, "Testing error handling");
    }

    @Then("I can access the box name in Login Step defination")
    public void i_can_access_the_box_name_in_Login_Step_defination() {
        System.out.println("Box number in Login step defination class access from Box Action class " + boxActions.getBoxNameFromBoxAction());
    }

    @Then("I can access the box name in Login Action")
    public void i_can_access_the_box_name_in_Login_Action() {
        loginActions.dummyMethod();
    }
}
