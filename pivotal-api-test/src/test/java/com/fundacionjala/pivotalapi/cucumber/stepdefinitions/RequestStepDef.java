package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class RequestStepDef {
    private Response response;

    @Given("^I send a POST request to (.*) with:$")
    public void iSendAPOSTRequestToProjects(String endpoint, Map<String, Object> values) {
       String formatedEndpoint = getFormatedEndpoint(endpoint);
        response = RequestManager.postRequest(formatedEndpoint, values);
    }

    private String getFormatedEndpoint(String endpoint) {
        if (endpoint.contains("[")){

            String[] newEndpoint = endpoint.trim().split(".");
            System.out.println("endpoint");
            System.out.println(newEndpoint);
        }
        else{
            return endpoint;
        }
        return endpoint;
    }


    public Response getResponse() {
        return response;
    }


    @Given("^I send a PUT request to (.*) with:$")
    public void iSendAPUTRequestToProjectsIdWith(String endpoint, Map<String, Object> values) {
        StringBuilder endpointProject = new StringBuilder();
        if(endpoint.equals("/stories")){
            endpointProject.append("/projects/");
            endpointProject.append(response.jsonPath().get("project_id"));
            endpointProject.append(endpoint);
            endpointProject.append("/");
            endpointProject.append("id");
            response = RequestManager.putRequest(endpointProject.toString(), values);
        }
        endpointProject = new StringBuilder();
        endpointProject.append(endpoint);
        endpointProject.append("/");
        endpointProject.append(response.jsonPath().get("id"));
        response = RequestManager.putRequest(endpointProject.toString(), values);
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
    public Object storeAs(String key) {
        Map<String, Response> map = new HashMap<String, Response>();
        return map.put(key,response);
    }
}
