package com.cucumber.testng.page_objects.web.ifmdx;

import com.cucumber.testng.model.LoginCredentials;
import com.cucumber.testng.page_objects.UIBasePage;
import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.UIObjects.click;
import static com.cucumber.testng.application_utils.ui.UIObjects.input;

public class LoginPage extends UIBasePage {

    private By USERNAME_INPUT = By.xpath("//*[@id='j_username']");
    private By PASSWORD_INPUT = By.xpath("//*[@id='j_password']");
    private By LOGIN_FAILED_ERROR_TEXT = By.xpath("//div[@style='display: block;' and text()='Logon Failed']");
    public By LOGIN_BTN = By.xpath("//button[@id='loginButton']");

    public MenuPage performLogin(LoginCredentials credentials) {
        System.out.println("Clicking login button");
        getDriver().switchTo().defaultContent();
        input(USERNAME_INPUT, credentials.getUsername());
        input(PASSWORD_INPUT, credentials.getPassword());
        click(LOGIN_BTN);
        return new MenuPage();
    }
}
