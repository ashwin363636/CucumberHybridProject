package com.cucumber.testng.page_objects.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.PrintStream;
import java.io.StringWriter;

import static com.cucumber.testng.application_utils.api_utils.APIHelper.givenConfig;
import static com.cucumber.testng.project_constants.constants.Settings.*;
import static com.cucumber.testng.project_constants.constants.Settings.TokenSecrete;
import static io.restassured.RestAssured.given;
import org.apache.commons.io.output.WriterOutputStream;

public class TwitterPage {

    public RequestSpecification login() {
        return givenConfig();
    }

    public Response twiteThisStatus(String twite) {
        return givenConfig()
                .queryParam("status", twite)
                .when()
                .post("/statuses/update.json")
                .then()
                .extract().response();
    }

    public Response getAllTwites(String screenName, int count) {
        return givenConfig()
                .queryParam("screen_name", screenName)
                .queryParam("count", count)
                .when()
                .get("/statuses/home_timeline.json")
                .then()
                .extract().response();
    }

    public Response likeTwite(long twiteID) {
        return givenConfig()
                .queryParam("id", twiteID)
                .when()
                .post("/favorites/create.json")
                .then()
                .extract().response();
    }

    public Response unlike(long twiteID) {
        return givenConfig()
                .queryParam("id", twiteID)
                .when()
                .post("/favorites/destroy.json")
                .then()
                .extract().response();
    }
}
