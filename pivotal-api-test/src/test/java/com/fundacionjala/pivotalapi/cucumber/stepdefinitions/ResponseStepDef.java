package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class ResponseStepDef {
    Response response;
    public ResponseStepDef(RequestStepDef requestStepDef){
        this.response = requestStepDef.getResponse();
    }

    @Then("^I expect status code (\\d+)$")
    public void iExpectStatusCode(int statusCode) {
        System.out.println(response);
        assertEquals(statusCode, response.statusCode());
    }

}
