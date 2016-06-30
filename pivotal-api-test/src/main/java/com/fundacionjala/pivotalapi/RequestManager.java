package com.fundacionjala.pivotalapi;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 * Created by RosarioGarcia on 6/28/2016.
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST_SPECIFICATION = Authentication.getInstance().getRequestSpecification();
    private RequestManager(){

    }
    public static Response getRequest(String endpoint) {
        return REQUEST_SPECIFICATION.when().get(endpoint);
    }

    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);
        //hacer con loger
        System.out.println(parameters);
        return REQUEST_SPECIFICATION.body(parametersJson).when().post(endpoint);
    }

    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return REQUEST_SPECIFICATION.body(parametersJson).when().put(endpoint);
    }

    public static Response deleteRequest(String endpoint, Map<String, Object> parameters) {
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return REQUEST_SPECIFICATION.body(parametersJson).when().delete(endpoint);
    }
}

