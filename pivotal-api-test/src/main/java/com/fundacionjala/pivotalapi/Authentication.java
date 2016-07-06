package com.fundacionjala.pivotalapi;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.baseURI;

/**
 * This Singleton class is for connect with the Pivotal Tracker API
 * with valid credentials, in this case use the Token of user.
 *
 * @author RosarioGarcia
 */
public final class Authentication {

    private static final String TYPE_HEADER = "X-TrackerToken";
    private static Authentication instance;
    private RequestSpecification requestSpecification;

    /**
     * Constructor of class
     */
    private Authentication() {
        initApi();
    }

    /**
     * Getter to obtains the instance of class.
     * If Instance is null returns a new instance
     *
     * @return instance
     */
    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    /**
     * Method to connect with the API pivotal
     * using the Token of user, proxy, which is loaded
     * from properties file.
     * <p>
     * If you don´t need specified the proxy, you must omit this code line.
     * <p>
     * Also is loaded the BaseUri of API from properties file
     */
    private void initApi() {
        baseURI = PropertiesInfo.getInstance().getBaseUrl();
        requestSpecification = new RequestSpecBuilder()
                .setRelaxedHTTPSValidation()
                //.setProxy(PropertiesInfo.getInstance().getProxy())
                .addHeader(TYPE_HEADER, PropertiesInfo.getInstance().getToken())
                .build();
    }

    /**
     * Getter to return the requestSpecification variable
     * that contains the request to connect to pivotal API
     *
     * @return requestSpecification
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }


}
