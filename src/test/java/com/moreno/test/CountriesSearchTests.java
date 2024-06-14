package com.moreno.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CountriesSearchTests {

    @Test
    public void validateStatusCode(){
        Response response;
        response = RestAssured.when().get("https://swapi.dev/api/films");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void postExample(){
        Response response;
        Map<String, String> user = new HashMap<>();
        user.put("first_name", "Josh");
        user.put("last_name", "Some");
        user.put("email", "hola@org.com");
        user.put("country", "US");
        user.put("telephone", "12344");
        user.put("active", "true");
        user.put("job_title", "QA");
        response = given().contentType("application/json").body(user).when().
                post("http://5d6fd3a8482b530014d2e8da.mockapi.io/mock/api/v1/users");
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
