package com.cucumber.testng.action;

import com.cucumber.testng.application_utils.ui.web_utils.WebDriverFactory;
import com.cucumber.testng.model.LoginCredentials;
import com.cucumber.testng.page_objects.web.ifmdx.BoxPage;
import com.cucumber.testng.page_objects.web.ifmdx.LoginPage;
import com.cucumber.testng.page_objects.web.ifmdx.MenuPage;
import com.cucumber.testng.project_constants.constants.Settings;

import java.io.IOException;

import static com.cucumber.testng.application_utils.ui.web_utils.WebApplicationLauncher.launchWebAUT;
import static com.cucumber.testng.utilities.extent_reports_utils.ExtentReportUtil.log;

public class LoginActions {
    private LoginPage loginPage;
    private MenuPage menupage;
    private BoxActions boxActions;
    private BoxPage boxPage;

    public LoginActions(LoginPage loginPage, MenuPage menupage, BoxActions boxActions, BoxPage boxPage) {
        this.loginPage = loginPage;
        this.menupage = menupage;
        this.boxActions = boxActions;
        this.boxPage = boxPage;
    }

    public void launchApplication() throws IOException {
        WebDriverFactory.createDriverInstance(Settings.BrowserType);
        loginPage = launchWebAUT();
    }

    public void performLogin(LoginCredentials credentials) {
        menupage = loginPage.performLogin(credentials);
        menupage.verifyIfLoggedInSuccessfully();
    }

    public boolean isLogoutLinkVisible() {
        System.out.println("Checking for Logout link");
        return menupage.verifyIfLoggedInSuccessfully();
    }

    public void dummyMethod() {
        log("I am in Dummy method");
        System.out.println("Box name in Login Action class got from Box Action " + boxActions.getBoxNameFromBoxAction());
        System.out.println("Box name in Login Action class got from Box Page " + boxActions.getBoxPage().getBoxNameFromBoxPage());//not working
        System.out.println("Variables from Box Action class accessed here---> " + boxActions.getVariable());
    }
}
