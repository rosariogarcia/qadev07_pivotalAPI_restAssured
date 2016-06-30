package com.fundacionjala.pivotalapi.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */

@RunWith(Cucumber.class)

@CucumberOptions(  monochrome = true,
        features = "src/test/resources/features/",
        format = { "pretty","html: cucumber-html-reports",
                "json: cucumber-html-reports/cucumber.json" },
        dryRun = false,
        glue = "com.fundacionjala.pivotalapi.cucumber" )

public class Runner {
}

