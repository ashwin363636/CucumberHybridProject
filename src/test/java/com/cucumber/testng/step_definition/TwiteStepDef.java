package com.cucumber.testng.step_definition;

import com.cucumber.testng.action.TwitterActions;
import com.cucumber.testng.model.Twite;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static com.cucumber.testng.utilities.extent_reports_utils.ExtentReportUtil.log;
import static com.cucumber.testng.utilities.misc_utils.StringUtililties.randomString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

public class TwiteStepDef {

    private TwitterActions twitterActions;
    private String twiteStr = randomString(5) + " " + randomString(6);
    private Twite twite;

    public TwiteStepDef(TwitterActions twitterActions) {
        this.twitterActions = twitterActions;
    }

    @Given("I am authenticated into Twitter application")
    public void i_am_authenticated_into_Twitter_application() {
        twitterActions.launchTwitter();
    }

    @When("I make a random twite")
    public void i_make_a_random_twite() {
        twite = twitterActions.twite(twiteStr);
    }

    @Then("the twite is created on my wall")
    public void the_twite_is_created_on_my_wall() {
        assertThat(twite.getText(), containsString(twiteStr));
    }

    @Then("I can get <{int}> twite's made by me")
    public void i_can_get_twite_s_made_by_me(Integer count) {
        List<Twite> list = twitterActions.getAllTwitesFromMyScreen(twite.getUser().getName(), count);
        assertThat(list.size(), equalTo(count));
        List<String> twiteList = new ArrayList<>();
        for(Twite item: list){
            twiteList.add(item.getText());
        }
        assertThat(twiteList, hasItem(containsStringIgnoringCase(twiteStr)));
    }

    @Then("I can Like my last twite")
    public void i_can_Like_my_last_twite() {
        long id = twitterActions.getAllTwitesFromMyScreen(twite.getUser().getName(), 1).get(0).getId();
        twite = twitterActions.likeTheLastTwite(id);
        assertTrue(twite.getId() > 1);
    }

    @Then("I can Unlike my last twite")
    public void i_can_Unlike_my_last_twite() {
        twite = twitterActions.unlikeMyLastTwite(twitterActions.getAllTwitesFromMyScreen(twite.getUser().getName(), 1).get(0).getId());
        assertTrue(twite.getId() > 1);
    }

    @When("I make a twite using the below datatable with {string}")
    public void i_make_a_twite_using_the_below_datatable_with(String iterationForNoReason, DataTable dataTable) {
        log("This is Iteration number " + iterationForNoReason);
        String aLongTwite = "";
        //List<Map<String, String>> data = dataTable.asMaps(String.class, String.class); -- Have it this way or
        List<List<String>> data = dataTable.asLists(String.class);
        for (int i = 1; i < data.size(); i++) {//i starts from 1 because i=0 represents the header
            for (int y = 0; y < 3; y++) {//3 columns
                aLongTwite = aLongTwite + data.get(i).get(y);
            }
        }
        twite = twitterActions.twite(aLongTwite + twiteStr);
    }
}
