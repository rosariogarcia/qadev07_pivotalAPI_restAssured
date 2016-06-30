package com.fundacionjala.pivotalapi;

import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;

public class Authentication {

    private static Authentication instance;

    private RequestSpecification requestSpecification;
    private Authentication() {
        initApi();
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    private void initApi() {
        baseURI = PropertiesInfo.getInstance().getBaseUrl();
        requestSpecification = given().relaxedHTTPSValidation()
                .proxy("http://172.20.240.5:8080")
                .header("X-TrackerToken", "cc208743093009d653e793ba384f6f16");
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
