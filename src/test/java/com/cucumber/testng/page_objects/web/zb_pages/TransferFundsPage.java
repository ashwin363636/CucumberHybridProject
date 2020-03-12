package com.cucumber.testng.page_objects.web.zb_pages;

import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.UIObjects.*;
import static com.cucumber.testng.utilities.misc_utils.StringUtililties.randomString;

public class TransferFundsPage extends ZBBasePage{

    private By AMOUNT_INPUT = By.id("tf_amount");
    private By DESCRIPTION_INPUT = By.id("tf_description");
    private By CONTINUE_BTN = By.id("btn_submit");
    private By SUBMIT_BTN = By.xpath("//div[@class='pull-right']//*[text()='Submit']");

    public TransferFundsPage makeTransferFund() {
        input(AMOUNT_INPUT, "100");
        input(DESCRIPTION_INPUT, randomString(5));
        click(CONTINUE_BTN, SUBMIT_BTN);
        return this;
    }
}
