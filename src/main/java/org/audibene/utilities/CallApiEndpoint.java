package org.audibene.utilities;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CallApiEndpoint {

    ApiHelpers apiHelpers;

    public CallApiEndpoint() {
        this.apiHelpers = new ApiHelpers();
    }

    public List<String> getCategories(){

        RestAssured.baseURI="https://api.chucknorris.io/jokes";

        RequestSpecification  httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET,"/categories");

        assertEquals (response.statusCode(),200);

        List<String> jsonResponse = response.jsonPath().getList("$");

        return  jsonResponse;
    }

    @Step("Get Jokes For the category : {0}")
    public Response getJokesForSpecificCategory(String category){
        RequestSpecification getJokesHttpRequest = RestAssured.given();
        getJokesHttpRequest.queryParam("query",category);
        Response getJokesResponse = getJokesHttpRequest.request(Method.GET,"/search");
        return getJokesResponse;
    }

    public  void validateJokesForSpecificCategory(String jokesContent, String category){

        assertEquals(jokesContent, apiHelpers.readJsonFixtures());
    }
}
