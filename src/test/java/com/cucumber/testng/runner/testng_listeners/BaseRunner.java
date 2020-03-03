package com.cucumber.testng.runner.testng_listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.cucumber.testng.application_utils.api_utils.APIHelper.getResponseWriterList;
import static com.cucumber.testng.application_utils.api_utils.APIHelper.isThisARestAPITest;
import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileUtils.startServer;
import static com.cucumber.testng.application_utils.ui.mobile_utils.MobileUtils.stopAppium;
import static com.cucumber.testng.application_utils.ui.web_utils.WebDriverFactory.closeDriver;
import static com.cucumber.testng.page_objects.UIBasePage.getDriver;
import static com.cucumber.testng.utilities.extent_reports_utils.ExtentReportUtil.log;

public class BaseRunner extends AbstractTestNGCucumberTests {


    @BeforeSuite
    public void init() {
        startServer();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            closeDriver();
        } else if (isThisARestAPITest()) {
            log(getResponseWriterList().toString());
        }
    }

    @AfterSuite
    public void closeSetup() {
        stopAppium();
    }
}
