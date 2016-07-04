package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class RequestStepDef {
    private Response response;
    private Map<String, Response> mapResponse;

    @Given("^I send a POST request to (.*) with:$")
    public void iSendAPOSTRequestToProjects(String endpoint, Map<String, Object> values) {
        final String formattedEndpoint = formatEndpoint(endpoint);
        response = RequestManager.postRequest(formattedEndpoint, values);
    }

    private String formatEndpoint(String endpoint) {
        if (endpoint.contains("[")) {
            Pattern keyEndpoint = Pattern.compile("\\[(.*?)\\.");
            Matcher mKey = keyEndpoint.matcher(endpoint);
            Pattern valueEndpoint = Pattern.compile("\\.(.*?)\\]");
            Matcher mValue = valueEndpoint.matcher(endpoint);
            while (mKey.find() && mValue.find()) {
                String key = mKey.group(1);
                String value = mValue.group(1);
                endpoint = endpoint.replaceFirst("\\[(.*?)\\]", mapResponse.get(key).jsonPath().get(value).toString());
            }
        }
        return endpoint;
    }

    public Response getResponse() {
        return response;
    }

    @Given("^I send a PUT request to (.*) with:$")
    public void iSendAPUTRequestToProjectsIdWith(String endpoint, Map<String, Object> values) {
        final String formattedEndpoint = formatEndpoint(endpoint);
        response = RequestManager.putRequest(formattedEndpoint, values);
    }

    @Given("^I send a DELETE request to (.*)$")
    public void iSendADELETERequestToProjects(String endpoint) {
        final String formattedEndpoint = formatEndpoint(endpoint);
        response = RequestManager.deleteRequest(formattedEndpoint.toString());
    }

    @And("^Store as (.*)$")
    public void storeAs(String key) {
        mapResponse = new HashMap<String, Response>();
        mapResponse.put(key, response);
    }

    public Map<String, Response> getMapResponse() {
        return mapResponse;
    }
}
