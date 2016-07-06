package com.fundacionjala.pivotalapi;

import com.jayway.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 * In this class build the Map of responses
 * from requests to Pivotal API.
 *
 * @author RosarioGarcia
 */
public class LocalStore {
    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class);
    public static final String REGEX_KEY = "\\[(.*?)\\.";
    public static final String REGEX_VALUE = "\\.(.*?)\\]";
    public static final String REGEX_REPLACE = "\\[(.*?)\\]";
    private static Map<String, Response> mapResponse;

    /**
     * private Constructor class for avoid a new instance
     */
    private LocalStore() {
    }

    /**
     * This method replace the variables specified
     * in the endpoint by values in response
     *
     * @param endpoint from step definitions
     * @return endpoint with values specified in the original endpoint
     */
    public static String formatEndpoint(String endpoint) {
        if (endpoint.contains("[")) {
            Pattern keyEndpoint = Pattern.compile(REGEX_KEY);
            Matcher mKey = keyEndpoint.matcher(endpoint);
            Pattern valueEndpoint = Pattern.compile(REGEX_VALUE);
            Matcher mValue = valueEndpoint.matcher(endpoint);
            while (mKey.find() && mValue.find()) {
                final int groupRegex = 1;
                String key = mKey.group(groupRegex);
                String value = mValue.group(groupRegex);
                endpoint = endpoint.replaceFirst(REGEX_REPLACE, mapResponse.get(key).jsonPath().get(value).toString());
            }
        }
        LOGGER.info("Endpoint to make request: " + endpoint);
        return endpoint;
    }

    /**
     * Getter method to obtains the mapResponse
     *
     * @return mapResponse
     */
    public static Map<String, Response> getMapResponse() {
        return mapResponse;
    }

    /**
     * Setter method to put a new response
     * on the mapResponse variable.
     * <p>
     * This method receives the Key name and
     * the response of request to save it in the map
     *
     * @param key
     * @param response
     */
    public static void addResponse(String key, Response response) {
        mapResponse = new HashMap<String, Response>();
        mapResponse.put(key, response);
        LOGGER.info("Response on map: " + mapResponse.toString());
    }
}
