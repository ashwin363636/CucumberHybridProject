package com.cucumber.testng.step_definition;

import com.cucumber.testng.action.BoxActions;
import com.cucumber.testng.action.LoginActions;
import com.cucumber.testng.model.LoginCredentials;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cucumber.testng.utilities.misc_utils.StringUtililties.randomString;

public class BoxStepDef {
    private BoxActions boxActions;
    private LoginActions loginActions;
    private LoginCredentials loginCredentials;

    public BoxStepDef(LoginActions loginActions, BoxActions boxActions, LoginCredentials loginCredentials){
        this.loginActions = loginActions;
        this.boxActions = boxActions;
        this.loginCredentials = loginCredentials;
    }

    @When("Create a Box")
    public void create_a_Box() {
       String randomString =  randomString(6);
        System.out.println("Randmoly generated box number " + randomString);
        boxActions.createBox(randomString);
    }

    @Then("Box is Created in the system")
    public void box_is_Created_in_the_system() {
        System.out.println("Testing that we can access data from other step def classes, Username - "+ this.loginCredentials.getUsername());
        System.out.println("Box created is ---------> " + boxActions.verifyBoxCreated());
    }
}
