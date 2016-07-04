package com.fundacionjala.pivotalapi;

import com.jayway.restassured.builder.RequestSpecBuilder;

import static com.jayway.restassured.RestAssured.baseURI;

public final class Authentication {

    private static final String TYPE_HEADER = "X-TrackerToken";
    private static Authentication instance;

    private static RequestSpecBuilder REQUEST_SPECIFICATION;

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
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                .setProxy(PropertiesInfo.getInstance().getProxy())
                .addHeader(TYPE_HEADER, PropertiesInfo.getInstance().getToken());
    }

    public RequestSpecBuilder getRequestSpecification() {
        return REQUEST_SPECIFICATION;
    }
}
