package org.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import java.util.Map;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.fundacionjala.pivotalapi.LocalStore.addResponse;
import static org.fundacionjala.pivotalapi.LocalStore.formatEndpoint;
import static org.fundacionjala.pivotalapi.RequestManager.deleteRequest;
import static org.fundacionjala.pivotalapi.RequestManager.postRequest;
import static org.fundacionjala.pivotalapi.RequestManager.putRequest;

/**
 * @author RosarioGarcia
 */
public class RequestStepDef {

    private Response response;

    @Given("^I send a POST request to (.*) with:$")
    public void iSendAPOSTRequestToEndpoint(String endpoint, Map<String, Object> values) {
        response = postRequest(formatEndpoint(endpoint), values);
    }

    @Given("^I send a PUT request to (.*) with:$")
    public void iSendAPUTRequestToEndpointWith(String endpoint, Map<String, Object> values) {
        response = putRequest(formatEndpoint(endpoint), values);
    }

    @Given("^I send a DELETE request to (.*)$")
    public void iSendADELETERequestToEndpoint(String endpoint) {
        response = deleteRequest(formatEndpoint(endpoint));
    }

    @And("^Store as (.*)$")
    public void storeAs(String key) {
        addResponse(key, response);
    }

    public Response getResponse() {
        return response;
    }
}
