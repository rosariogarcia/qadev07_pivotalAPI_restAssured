package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import java.util.Map;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class RequestStepDef {
    private Response response;

    @Given("^I send a POST request to (.*) with:$")
    public void iSendAPOSTRequestToProjects(String endpoint, Map<String, Object> values) {
        response = RequestManager.postRequest(endpoint, values);
    }

    public Response getResponse() {
        return response;
    }
}
