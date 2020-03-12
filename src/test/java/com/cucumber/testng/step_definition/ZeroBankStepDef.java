package com.cucumber.testng.step_definition;

import com.cucumber.testng.action.ZeroBankAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.List;

import static com.cucumber.testng.utilities.misc_utils.AssertClass.assertEquals;

public class ZeroBankStepDef {

    private ZeroBankAction zeroBankAction;

    public ZeroBankStepDef(ZeroBankAction zeroBankAction) {
        this.zeroBankAction = zeroBankAction;
    }

    @Then("I can pay my bill")
    public void i_can_pay_my_bill(DataTable dataTable) {
        List<String> list = dataTable.asList(String.class);
        zeroBankAction.payBill(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
    }

    @Then("I see a success message {string}")
    public void i_see_a_success_message(String message) {
        assertEquals(zeroBankAction.getMessageDisplayed(), message );
    }

    @Then("I can Logout Link")
    public void i_can_Logout_Link() {
        zeroBankAction.logoutZeroBankAccount();
    }

    @Then("I can do a Money transfer")
    public void i_can_do_a_Money_transfer() {
        zeroBankAction.doSomeMoneyTransfer();
    }

    @Given("Open Application in Web view and Enter url")
    public void open_Application_in_Web_view_and_Enter_url() throws IOException {
        zeroBankAction.launchWebApplication();
    }
}
