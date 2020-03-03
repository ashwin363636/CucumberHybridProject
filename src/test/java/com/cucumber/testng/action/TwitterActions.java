package com.cucumber.testng.action;

import com.cucumber.testng.model.Twite;
import com.cucumber.testng.page_objects.api.TwitterPage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;

import java.util.Collection;
import java.util.List;

import static com.cucumber.testng.application_utils.api_utils.APIUtils.UNRELIABLE_INTEGER_FACTORY;

public class TwitterActions {

    private TwitterPage twitterPage;
    private Response response;
    private Gson gson;

    public TwitterActions(TwitterPage twitterPage) {
        this.twitterPage = twitterPage;
        this.gson = new GsonBuilder()
                .registerTypeAdapterFactory(UNRELIABLE_INTEGER_FACTORY)
                .create();
    }

    public void launchTwitter() {
        twitterPage.login();
    }

    public Twite twite(String twite) {
        return getTwiteFromResponses(twitterPage.twiteThisStatus(twite));
    }

    public List<Twite> getAllTwitesFromMyScreen(String screenName, int count) {
        return getListOfTwitesFromResponses(twitterPage.getAllTwites(screenName, count));
    }

    public Twite likeTheLastTwite(long twiteID) {
        return getTwiteFromResponses(twitterPage.likeTwite(twiteID));
    }

    public Twite unlikeMyLastTwite(long twiteID) {
        return getTwiteFromResponses(twitterPage.unlike(twiteID));
    }

    private List<Twite> getListOfTwitesFromResponses(Response response) {
        return gson.fromJson(response.asString(), new TypeToken<Collection<Twite>>() {
        }.getType());
    }

    private Twite getTwiteFromResponses(Response response) {
        return gson.fromJson(response.asString(), Twite.class);
    }
}
