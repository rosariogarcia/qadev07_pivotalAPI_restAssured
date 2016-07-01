package com.fundacionjala.pivotalapi;

import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;

public final class Authentication {

    private static final String TYPE_HEADER = "X-TrackerToken";
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
                .proxy(PropertiesInfo.getInstance().getProxy())
                .header(TYPE_HEADER, PropertiesInfo.getInstance().getToken());
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
