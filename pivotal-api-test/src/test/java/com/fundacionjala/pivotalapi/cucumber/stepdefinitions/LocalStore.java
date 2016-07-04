package com.fundacionjala.pivotalapi.cucumber.stepdefinitions;

import com.jayway.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RosarioGarcia on 7/4/2016.
 */
public class LocalStore {
    private Map<String, Response> mapResponse;
    public String formatEndpoint(String endpoint) {
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

    public Map<String, Response> getMapResponse() {
        return mapResponse;
    }

    public void setMapResponse(String key, Response response) {
        mapResponse = new HashMap<String, Response>();
        mapResponse.put(key, response);
    }
}
