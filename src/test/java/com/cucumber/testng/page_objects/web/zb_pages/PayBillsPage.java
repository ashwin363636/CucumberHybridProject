package com.cucumber.testng.page_objects.web.zb_pages;

import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.UIObjects.click;

public class PayBillsPage extends ZBBasePage {

    private static final By PAY_SAVED_PAYEE_LINK = By.linkText("Pay Saved Payee");

    public PaySavedPayeePage goToPaySavedPayee() {
        click(PAY_SAVED_PAYEE_LINK);
        return new PaySavedPayeePage();
    }
}
