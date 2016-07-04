package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;


import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;

/**
 * Created by RosarioGarcia on 7/4/2016.
 */
public class Hook {
    Response response;

    public Hook(RequestStepDef requestStepDef) {
        this.response = requestStepDef.getResponse();
    }

    @After("@deleteProject")
    public void tearDownProject() {
        response = RequestManager.deleteRequest("/projects/" + response.jsonPath().get("id"));
    }

    @After("@deleteProjectStory")
    public void tearDownStory() {
        response = RequestManager.deleteRequest("/projects/" + response.jsonPath().get("project_id"));
    }
}
