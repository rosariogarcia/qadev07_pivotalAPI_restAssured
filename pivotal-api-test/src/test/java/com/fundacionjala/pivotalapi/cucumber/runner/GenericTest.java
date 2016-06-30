package com.fundacionjala.pivotalapi.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */

@RunWith(Cucumber.class)

@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html-report"},
        features = {"src/test/resources/features"}
)

public class GenericTest {
}

