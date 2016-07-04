package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class RequestStepDef {
    private Response response;
private Map<String, Response> mapResponse;
    @Given("^I send a POST request to (.*) with:$")
    public void iSendAPOSTRequestToProjects(String endpoint, Map<String, Object> values) {
        System.out.println("post request");
        System.out.println(endpoint);
        String formatedEndpoint = getFormatedEndpoint(endpoint);
        response = RequestManager.postRequest(formatedEndpoint, values);
    }

    private String getFormatedEndpoint(String endpoint) {
        StringBuilder newEndpoint = new StringBuilder();
        String key = "";
        String value = "";
        String toUse = endpoint;
        if (toUse.contains("[")) {
            Pattern keyEndpoint = Pattern.compile("\\[(.*?)\\.");
            Matcher mKey = keyEndpoint.matcher(toUse);
            Pattern valueEndpoint = Pattern.compile("\\.(.*?)\\]");
            Matcher mValue = valueEndpoint.matcher(toUse);
            while (mKey.find() && mValue.find()) {
                key = mKey.group(1);
                value = mValue.group(1);
                newEndpoint.append(toUse.replaceFirst("\\[(.*?)\\]", mapResponse.get(key).jsonPath().get(value).toString()));
                toUse = newEndpoint.toString();
                // System.out.println(newResponse);
            }
            System.out.println("new endpoint");
            System.out.println(newEndpoint);
            return newEndpoint.toString();
        }
        return endpoint;
    }

    public Response getResponse() {
        return response;
    }


    @Given("^I send a PUT request to (.*) with:$")
    public void iSendAPUTRequestToProjectsIdWith(String endpoint, Map<String, Object> values) {
        System.out.println("put request");
        System.out.println(endpoint);
        String formatedEndpoint = getFormatedEndpoint(endpoint);
        response = RequestManager.putRequest(formatedEndpoint, values);
    }

    @Given("^I send a DELETE request to (.*) with project ID$")
    public void iSendADELETERequestToProjectsWithProjectID(String endpoint) {
        StringBuilder endpointProject = new StringBuilder();
        endpointProject.append(endpoint);
        endpointProject.append("/");
        endpointProject.append(response.jsonPath().get("id"));
        response = RequestManager.deleteRequest(endpointProject.toString());
    }

    @And("^Store as (.*)$")
    public void storeAs(String key) {
        mapResponse = new HashMap<String, Response>();
        mapResponse.put(key, response);
        System.out.println("print response");
        System.out.println(mapResponse.get(key).prettyPrint());
    }

    public Map<String, Response> getMapResponse() {
        return mapResponse;
    }
}
