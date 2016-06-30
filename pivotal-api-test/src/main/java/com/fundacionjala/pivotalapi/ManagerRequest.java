package com.fundacionjala.pivotalapi;

import com.jayway.restassured.response.Response;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 * Created by RosarioGarcia on 6/28/2016.
 */
public class ManagerRequest {

    public static Response getRequest(String endpoint){
        return Authentication.getInstance().getRequestSpecification().when().get(endpoint);
    }

    public static Response postRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        System.out.println(parametersJson);
        return Authentication.getInstance().getRequestSpecification().contentType("application/json").and().body(parametersJson).when().post(endpoint);
    }

    public static Response putRequest(String endpoint, Map<String,String> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return Authentication.getInstance().getRequestSpecification().contentType("application/json").and().body(parametersJson).when().put(endpoint);
    }

    public static Response deleteRequest(String endpoint, Map<String,String> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return Authentication.getInstance().getRequestSpecification().contentType("application/json").and().body(parametersJson).when().delete(endpoint);
    }
}

