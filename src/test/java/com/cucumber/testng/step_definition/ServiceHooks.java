package com.cucumber.testng.step_definition;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.*;

import static com.cucumber.testng.utilities.extent_reports_utils.ExtentReportUtil.setScenario;

public class ServiceHooks {

    @Before
    public void initializeTest(Scenario scenario) {
        setScenario(scenario);
    }
}
