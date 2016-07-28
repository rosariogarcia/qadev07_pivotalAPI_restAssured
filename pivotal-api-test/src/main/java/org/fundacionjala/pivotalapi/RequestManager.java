package org.fundacionjala.pivotalapi;

import java.util.Map;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import static com.jayway.restassured.RestAssured.given;

/**
 * This class is used to make request to pivotal API
 *
 * @author RosarioGarcia
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST_SPECIFICATION = Authentication.getInstance().getRequestSpecification();
    private static Logger LOGGER = Logger.getLogger(PropertiesInfo.class);

    /**
     * Private constuctor class to avoid
     * a new instance from anothes class
     */
    private RequestManager() {
    }

    /**
     * Method to make a Get request to pivotal API
     *
     * @param endpoint
     * @return requestSpecification
     */
    public static Response getRequest(String endpoint) {
        LOGGER.info("GET request to: " + endpoint);
        return given().spec(REQUEST_SPECIFICATION).when().get(endpoint);
    }

    /**
     * Method to make a Post request to pivotal API
     *
     * @param endpoint
     * @return requestSpecification
     */
    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        LOGGER.info("POST request to: " + endpoint + " with: " + parameters);
        return given().spec(REQUEST_SPECIFICATION).params(parameters).when().post(endpoint);
    }

    /**
     * Method to make a Put request to pivotal API
     *
     * @param endpoint
     * @return requestSpecification
     */
    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        LOGGER.info("PUT request to: " + endpoint + " with: " + parameters);
        return given().spec(REQUEST_SPECIFICATION).params(parameters).when().put(endpoint);
    }

    /**
     * Method to make a Delete request to pivotal API
     *
     * @param endpoint
     * @return requestSpecification
     */
    public static Response deleteRequest(String endpoint) {
        LOGGER.info("DELETE request to: " + endpoint);
        return given().spec(REQUEST_SPECIFICATION).when().delete(endpoint);
    }
}

