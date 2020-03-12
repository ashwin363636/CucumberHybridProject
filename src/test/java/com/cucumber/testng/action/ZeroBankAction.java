package com.cucumber.testng.action;

import com.cucumber.testng.page_objects.web.zb_pages.MenuBarPage;
import com.cucumber.testng.page_objects.web.zb_pages.ZBLandingPage;
import com.cucumber.testng.project_constants.constants.Settings;

import java.io.IOException;
import java.net.MalformedURLException;

import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileDriverFactory.createAppDriverInstance;
import static com.cucumber.testng.application_utils.ui.web_utils.WebApplicationLauncher.launchWebZeroMoney;
import static com.cucumber.testng.application_utils.ui.web_utils.WebDriverFactory.createDriverInstance;

public class ZeroBankAction {

    private MenuBarPage menuBarPage;
    private ZBLandingPage zBLandingPage;

    public ZeroBankAction(MenuBarPage menuBarPage, ZBLandingPage zBLandingPage) {
        this.menuBarPage = menuBarPage;
        this.zBLandingPage = zBLandingPage;
    }

    public void payBill(String payee, String account, String amount, String date, String description) {
        menuBarPage.goToPayBills()
                .goToPaySavedPayee()
                .makeTransferFund(payee, account, amount, date, description);
    }

    public String getMessageDisplayed() {
        return menuBarPage.getAlertMessage();
    }

    public void logoutZeroBankAccount() {
        menuBarPage.logout();
    }

    public void doSomeMoneyTransfer() {
        menuBarPage.goToTransferFunds()
                .makeTransferFund();
    }

    public void loginToZeroBank(String username, String password) {
        menuBarPage = zBLandingPage.search()
                .signIn()
                .signIn(username, password);
    }

    public void launchMobileWebApplication() throws MalformedURLException {
        createAppDriverInstance(Settings.BrowserType, true);
        zBLandingPage = launchWebZeroMoney();
    }

    public void launchWebApplication() throws IOException {
        createDriverInstance(Settings.BrowserType);
        zBLandingPage = launchWebZeroMoney();
    }
}
