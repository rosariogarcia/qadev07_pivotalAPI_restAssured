package org.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class ResponseStepDef {

    private RequestStepDef requestStepDef;

    public ResponseStepDef(RequestStepDef requestStepDef) {
        this.requestStepDef = requestStepDef;
    }

    @Then("^I expect status code (\\d+)$")
    public void iExpectStatusCode(int statusCode) {
        assertEquals(statusCode, requestStepDef.getResponse().statusCode());
    }

    @And("^I expect that (.*) be equals to (.*)")
    public void iExpectThatAttributeBeEqualsToValue(String attribute, String expectedValue) {
        assertEquals(expectedValue, requestStepDef.getResponse().path(attribute));
    }
}
