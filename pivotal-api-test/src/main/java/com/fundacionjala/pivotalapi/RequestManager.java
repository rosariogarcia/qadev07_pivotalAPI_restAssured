package com.fundacionjala.pivotalapi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Created by RosarioGarcia on 6/28/2016.
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST_SPECIFICATION = Authentication.getInstance().getRequestSpecification();
    private static Logger LOG = Logger.getLogger(RequestManager.class.getName());
    private RequestManager(){

    }
    public static Response getRequest(String endpoint) {
        return REQUEST_SPECIFICATION.when().get(endpoint);
    }

    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        JsonParser jsonParser = new JsonParser();
        final JsonObject jsonObject = jsonParser.parse(parameters.toString()).getAsJsonObject();
        LOG.warn("RESPONSE POST REQUEST"+jsonObject);
        return REQUEST_SPECIFICATION.body(jsonObject).when().post(endpoint);
    }

    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        JsonParser jsonParser = new JsonParser();
        return REQUEST_SPECIFICATION.body(parameters).when().put(endpoint);
    }

    public static Response deleteRequest(String endpoint) {
        return REQUEST_SPECIFICATION.body("").when().delete(endpoint);
    }
}

