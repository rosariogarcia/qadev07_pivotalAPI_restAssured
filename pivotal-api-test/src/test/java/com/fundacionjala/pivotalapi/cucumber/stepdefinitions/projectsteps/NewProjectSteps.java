package com.fundacionjala.pivotalapi.cucumber.stepdefinitions.projectsteps;

import com.fundacionjala.pivotalapi.Request;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class NewProjectSteps {
    private Response response;
    @Given("^I have set a connection to pivotal tracker API")
    public void iHaveSetAConnectionToPivotalTrackerAPI() {
    }

    @When("^I send a POST request to (.*) with (.*) project$")
    public void iSendAPOSTRequestToProjectsWithNameProject(String endpoint, String name) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put( "name", name );
        parameters.put( "public", true );
        response = Request.postRequest(endpoint, parameters );
    }

    public Response getResponse() {
        return response;
    }
}
