package com.cucumber.testng.page_objects.web.zb_pages;

import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.UIObjects.click;
import static com.cucumber.testng.application_utils.ui.UIObjects.input;

public class ZBLoginPage extends ZBBasePage {

    private By LOGIN_INPUT = By.id("user_login");
    private By PASSWORD_INPUT = By.id("user_password");
    private By SIGN_IN_BTN_BTN = By.name("submit");

    public MenuBarPage signIn(String userName, String password) {
        input(LOGIN_INPUT, userName);
        input(PASSWORD_INPUT, password);
        click(SIGN_IN_BTN_BTN);
        return new MenuBarPage();
    }
}
