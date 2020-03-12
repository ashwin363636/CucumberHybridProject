package com.cucumber.testng.page_objects.web.zb_pages;

import org.openqa.selenium.By;

import java.awt.event.KeyEvent;

import static com.cucumber.testng.application_utils.ui.UIObjects.*;

public class PaySavedPayeePage extends ZBBasePage {

    private By PAYEE_DRPDWN = By.id("sp_payee");
    private By ACCOUNT_DRPDWN = By.id("sp_account");
    private By AMOUNT_INPUT = By.id("sp_amount");
    private By DATE_INPUT = By.id("sp_date");
    private By DESCRIPTION_INPUT = By.id("sp_description");
    private By PAY_BTN = By.id("pay_saved_payees");
    private static final By MESSAGE_TXT = By.xpath("//*[contains(@class, 'alert')]");

    public PaySavedPayeePage makeTransferFund(String payee, String account, String amount, String date, String description) {
        input(DATE_INPUT, date);
        keyPress(KeyEvent.VK_ESCAPE);
        selectDropdownValue(PAYEE_DRPDWN, payee);
        selectDropdownValue(ACCOUNT_DRPDWN, account);
        input(AMOUNT_INPUT, amount);
        input(DESCRIPTION_INPUT, description);
        click(PAY_BTN);
        return this;
    }

    public String getAlertMessage() {
        return getText(MESSAGE_TXT);
    }
}
