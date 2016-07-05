package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import java.util.Map;

import com.fundacionjala.pivotalapi.LocalStore;
import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class RequestStepDef {
    private Response response;

    @Given("^I send a POST request to (.*) with:$")
    public void iSendAPOSTRequestToProjects(String endpoint, Map<String, Object> values) {
        response = RequestManager.postRequest(LocalStore.formatEndpoint(endpoint), values);
    }

    @Given("^I send a PUT request to (.*) with:$")
    public void iSendAPUTRequestToProjectsIdWith(String endpoint, Map<String, Object> values) {
        response = RequestManager.putRequest(LocalStore.formatEndpoint(endpoint), values);
    }

    @Given("^I send a DELETE request to (.*)$")
    public void iSendADELETERequestToProjects(String endpoint) {
        response = RequestManager.deleteRequest(LocalStore.formatEndpoint(endpoint));
    }

    @And("^Store as (.*)$")
    public void storeAs(String key) {
        LocalStore.addResponse(key, response);
    }

    public Response getResponse() {
        return response;
    }
}
