package com.fundacionjala.pivotalapi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import java.util.Map;
import org.apache.log4j.Logger;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by RosarioGarcia on 6/28/2016.
 */
public final class RequestManager {

    private static final RequestSpecBuilder REQUEST_SPECIFICATION = Authentication.getInstance().getRequestSpecification();
    private static Logger LOG = Logger.getLogger(RequestManager.class.getName());
    private RequestManager(){
    }

    public static Response getRequest(String endpoint) {
        return given().spec(REQUEST_SPECIFICATION).when().get(endpoint);
    }

    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        JsonParser jsonParser = new JsonParser();
        final JsonObject jsonObject = jsonParser.parse(parameters.toString()).getAsJsonObject();
        LOG.info("RESPONSE POST REQUEST"+jsonObject);
        return REQUEST_SPECIFICATION.contentType(ContentType.JSON).body(jsonObject).when().post(endpoint);
    }

    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        JsonParser jsonParser = new JsonParser();
        final JsonObject jsonObject = jsonParser.parse(parameters.toString()).getAsJsonObject();
        LOG.info("RESPONSE PUT REQUEST"+jsonObject);
      //  given().spec(REQUEST_SPECIFICATION).contentType();
        return given().spec(REQUEST_SPECIFICATION).contentType(ContentType.JSON).body(parameters).when().put(endpoint);
    }

    public static Response deleteRequest(String endpoint) {

        LOG.info("RESPONSE DELETE REQUEST"+endpoint);
        return given().spec(REQUEST_SPECIFICATION).when().delete(endpoint);
    }
}

