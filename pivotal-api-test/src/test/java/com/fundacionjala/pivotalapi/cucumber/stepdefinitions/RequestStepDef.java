package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import java.util.Map;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class RequestStepDef {
    LocalStore localStore = new LocalStore();
    private Response response;

    @Given("^I send a POST request to (.*) with:$")
    public void iSendAPOSTRequestToProjects(String endpoint, Map<String, Object> values) {
        final String formattedEndpoint = localStore.formatEndpoint(endpoint);
        response = RequestManager.postRequest(formattedEndpoint, values);
    }

    @Given("^I send a PUT request to (.*) with:$")
    public void iSendAPUTRequestToProjectsIdWith(String endpoint, Map<String, Object> values) {
        final String formattedEndpoint = localStore.formatEndpoint(endpoint);
        response = RequestManager.putRequest(formattedEndpoint, values);
    }

    @Given("^I send a DELETE request to (.*)$")
    public void iSendADELETERequestToProjects(String endpoint) {
        final String formattedEndpoint = localStore.formatEndpoint(endpoint);
        response = RequestManager.deleteRequest(formattedEndpoint.toString());
    }

    @And("^Store as (.*)$")
    public void storeAs(String key) {
        localStore.setMapResponse(key, response);
    }

    public Response getResponse() {
        return response;
    }
}
