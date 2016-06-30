package com.fundacionjala.pivotalapi.cucumber.stepdefinitions.projectsteps;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class AssertsProjectSteps {
    Response response;
    public AssertsProjectSteps( NewProjectSteps newProjectSteps){
        this.response = newProjectSteps.getResponse();
    }

    @Then("^I expect status code (\\d+)$")
    public void iExpectStatusCode(int statusCode) throws Throwable {
        System.out.println(response.prettyPrint());
        System.out.println(response.jsonPath().get("name"));
        assertEquals(statusCode, response.statusCode());
    }
}
