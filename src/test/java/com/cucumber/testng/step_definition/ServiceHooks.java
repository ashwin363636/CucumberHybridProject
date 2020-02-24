package com.cucumber.testng.step_definition;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

import static com.cucumber.testng.utilities.extent_reports_utils.ExtentReportUtil.setScenario;

public class ServiceHooks {

    @Before
    public void initializeTest(Scenario scenario) {
        setScenario(scenario);
    }
}
