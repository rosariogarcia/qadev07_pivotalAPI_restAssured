package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class ResponseStepDef {

    private Response response;

    public ResponseStepDef(RequestStepDef requestStepDef) {
        this.response = requestStepDef.getResponse();
    }

    @Then("^I expect status code (\\d+)$")
    public void iExpectStatusCode(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @And("^I expect that (.*) be equals to (.*)")
    public void iExpectThatAttributeBeEqualsToValue(String attribute, String expectedValue) {
        assertEquals(expectedValue, response.jsonPath().get(attribute));
    }
}
