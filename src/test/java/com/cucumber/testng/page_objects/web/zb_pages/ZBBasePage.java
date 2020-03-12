package com.cucumber.testng.page_objects.web.zb_pages;

import com.cucumber.testng.page_objects.UIBasePage;
import org.openqa.selenium.By;

import static com.cucumber.testng.application_utils.ui.UIObjects.getText;

public class ZBBasePage extends UIBasePage {
    private static final By MESSAGE_TXT = By.xpath("//*[contains(@class, 'alert')]");

    public String getAlertMessage(){
        return getText(MESSAGE_TXT);
    }
}
