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
        System.out.println(endpoint);

        if(endpoint.equals("/stories")){
            StringBuilder endpointProject = new StringBuilder();
            endpointProject.append("/projects");
            endpointProject.append("/");
            System.out.println("post story");
            System.out.println(response.jsonPath().get("id"));
            endpointProject.append(response.jsonPath().get("id"));
            endpointProject.append(endpoint);
            System.out.println(endpointProject);
            System.out.println(values);
            response = RequestManager.postRequest(endpointProject.toString(), values);
        }
        response = RequestManager.postRequest(endpoint, values);
        System.out.println("post");
        System.out.println(response.jsonPath().get("id"));
    }

    public Response getResponse() {
        return response;
    }


    @Given("^I send a PUT request to (.*) with:$")
    public void iSendAPUTRequestToProjectsIdWith(String endpoint, Map<String, Object> values) {
        StringBuilder endpointProject = new StringBuilder();
        if(endpoint.equals("/stories")){
            System.out.println("story response");
            System.out.println(response);
            endpointProject.append("/projects/");
            endpointProject.append(response.jsonPath().get("project_id"));
            endpointProject.append(endpoint);
            endpointProject.append("/");
            endpointProject.append("id");
            System.out.println("put story");
            System.out.println(endpointProject);
            response = RequestManager.putRequest(endpointProject.toString(), values);
        }
        System.out.println("project response");
        System.out.println(response);
        endpointProject = new StringBuilder();
        endpointProject.append(endpoint);
        endpointProject.append("/");
        endpointProject.append(response.jsonPath().get("id"));
        System.out.println("put project");
        System.out.println(endpointProject);
        response = RequestManager.putRequest(endpointProject.toString(), values);
    }

    @Given("^I send a DELETE request to (.*) with project ID$")
    public void iSendADELETERequestToProjectsWithProjectID(String endpoint) {
        StringBuilder endpointProject = new StringBuilder();
        endpointProject.append(endpoint);
        endpointProject.append("/");
        endpointProject.append(response.jsonPath().get("id"));
        System.out.println("delete");
        System.out.println(endpointProject);
        response = RequestManager.deleteRequest(endpointProject.toString());
    }
}
