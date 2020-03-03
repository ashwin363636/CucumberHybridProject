package com.cucumber.testng.page_objects.web;

import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.UIObjects.input;

public class ZBLandingPage {
    private static final By SEARCH_INPUT = By.xpath("//*[@id='searchTerm']");

    public void search() {
        input(SEARCH_INPUT, "Hello");
    }
}
