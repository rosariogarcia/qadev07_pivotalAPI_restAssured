package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;


import com.fundacionjala.pivotalapi.PropertiesInfo;
import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import org.apache.log4j.Logger;

/**
 * Created by RosarioGarcia on 7/4/2016.
 */
public class Hook {


    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class);
    public static final String BASE_PROJECTS = "/projects/";

    private Response response;

    public Hook(RequestStepDef requestStepDef) {
        this.response = requestStepDef.getResponse();
        LOGGER.info("RESPONSE in Hook: " + response.prettyPrint());
    }

    @After("@deleteProject")
    public void tearDownProject() {
        response = RequestManager.deleteRequest(BASE_PROJECTS + response.jsonPath().get("id"));
    }

    @After("@deleteProjectStory")
    public void tearDownStory() {
        response = RequestManager.deleteRequest(BASE_PROJECTS + response.jsonPath().get("project_id"));
    }
}
