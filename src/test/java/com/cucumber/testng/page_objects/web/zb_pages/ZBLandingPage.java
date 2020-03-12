package com.cucumber.testng.page_objects.web.zb_pages;

import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.UIObjects.click;
import static com.cucumber.testng.application_utils.ui.UIObjects.input;

public class ZBLandingPage extends ZBBasePage{
    private static final By SEARCH_INPUT = By.xpath("//*[@id='searchTerm']");
    private static final By SEARCH_BTN= By.id("signin_button");

    public ZBLandingPage search() {
        input(SEARCH_INPUT, "Hello");
        return this;
    }

    public ZBLoginPage signIn() {
        click(SEARCH_BTN);
        return new ZBLoginPage();
    }

}
