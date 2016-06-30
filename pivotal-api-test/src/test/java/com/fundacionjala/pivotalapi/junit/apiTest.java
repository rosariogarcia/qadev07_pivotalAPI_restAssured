package com.fundacionjala.pivotalapi.junit;

import com.fundacionjala.pivotalapi.Request;
import com.jayway.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by RosarioGarcia on 6/30/2016.
 */
public class apiTest {


    @Test
    public void testGetRequest() {
        final int expected_status = 200;
        assertEquals(expected_status, Request.getRequest("/me").statusCode());
    }

    @Test
    public void testPostRequest(){
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put( "name", "newrwe Project" );
        parameters.put( "public", true );
        Response response = Request.postRequest("/projects", parameters );
        System.out.println(response.prettyPrint());
        System.out.println(response.jsonPath().get("name"));

    }
}
