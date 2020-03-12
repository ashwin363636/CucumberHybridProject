package com.cucumber.testng.page_objects.web.zb_pages;

import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.UIObjects.click;

public class MenuBarPage extends ZBBasePage{

    private By TRANSFER_FUNDS_LINK = By.linkText("Transfer Funds");
    private By PAY_BILL_LINK = By.linkText("Pay Bills");

    public TransferFundsPage goToTransferFunds() {
        click(TRANSFER_FUNDS_LINK);
        return new TransferFundsPage();
    }

    public PayBillsPage goToPayBills() {
        click(PAY_BILL_LINK);
        return new PayBillsPage();
    }

    public ZBLandingPage logout(){
        //logout here
        return new ZBLandingPage();
    }
}
