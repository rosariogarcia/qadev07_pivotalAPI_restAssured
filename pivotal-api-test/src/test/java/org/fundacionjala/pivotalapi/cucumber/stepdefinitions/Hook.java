package org.fundacionjala.pivotalapi.cucumber.stepdefinitions;


import cucumber.api.java.After;

import static org.fundacionjala.pivotalapi.Constants.RESPONSE_VALUES;
import static org.fundacionjala.pivotalapi.RequestManager.deleteRequest;

/**
 * Created by RosarioGarcia on 7/4/2016.
 */
public class Hook {

    private static final String PROJECT = "Project1";
    private static final String ID = "id";
    private static final String BASE_PROJECTS = "/projects/";
    private RequestStepDef requestStepDef;

    public Hook(RequestStepDef requestStepDef) {
        this.requestStepDef = requestStepDef;
    }

    @After("@project")
    public void tearDownProject() {
        deleteRequest(BASE_PROJECTS + requestStepDef.getResponse().path(ID));
    }

    @After("@story")
    public void tearDownProjectStory() {
        String id = RESPONSE_VALUES.get(PROJECT).jsonPath().get(ID).toString();
        deleteRequest(BASE_PROJECTS + id);
    }
}
