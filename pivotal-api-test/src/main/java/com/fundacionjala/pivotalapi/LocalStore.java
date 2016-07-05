package com.fundacionjala.pivotalapi;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jayway.restassured.response.Response;

/**
 * Created by RosarioGarcia on 7/4/2016.
 */
public class LocalStore {
    private static Map<String, Response> mapResponse;

    private LocalStore() {
    }

    public static String formatEndpoint(String endpoint) {
        if (endpoint.contains("[")) {
            Pattern keyEndpoint = Pattern.compile("\\[(.*?)\\.");
            Matcher mKey = keyEndpoint.matcher(endpoint);
            Pattern valueEndpoint = Pattern.compile("\\.(.*?)\\]");
            Matcher mValue = valueEndpoint.matcher(endpoint);
            while (mKey.find() && mValue.find()) {
                String key = mKey.group(1);
                String value = mValue.group(1);
                endpoint = endpoint.replaceFirst("\\[(.*?)\\]", mapResponse.get(key).jsonPath().get(value).toString());
            }
        }
        return endpoint;
    }

    public static Map<String, Response> getMapResponse() {
        return mapResponse;
    }

    public static void setMapResponse(String key, Response response) {
        mapResponse = new HashMap<String, Response>();
        mapResponse.put(key, response);
    }
}
