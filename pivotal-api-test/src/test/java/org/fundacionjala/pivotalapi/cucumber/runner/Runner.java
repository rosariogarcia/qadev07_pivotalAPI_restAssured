package org.fundacionjala.pivotalapi.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author RosarioGarcia
 */

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true,
        features = "src/test/resources",
        format = {"pretty", "html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json"},
        dryRun = false,
        glue = "org.fundacionjala.pivotalapi.cucumber")

public class Runner {
}

