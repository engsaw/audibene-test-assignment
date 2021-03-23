package org.audibene.apitests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.audibene.utilities.ApiHelpers;
import org.audibene.utilities.CallApiEndpoint;
import org.audibene.utilities.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class GetCategoriesTests {

    public WebDriver driver;

    Configuration myConfiguration;

    ApiHelpers apiHelpers;

    CallApiEndpoint callApiEndpoint;

    List<String> listOfCategories;

    @BeforeTest
    public void setUp() {
        myConfiguration = new Configuration(driver);
        apiHelpers = new ApiHelpers();
        callApiEndpoint = new CallApiEndpoint();
    }

    @Feature("Jokes Api")
    @Description("Invoke categories endpoint with get request Successfully")
    @Test(priority = 0, description = "Invoke Jokes Category main catalog")
    public void getCategories() {
        //Save the list of categories in an Arraylist by calling https://api.chucknorris.io/jokes/categories
        //["animal","career","celebrity","dev","explicit","fashion","food","history","money","movie","music",
        // "political","religion","science","sport","travel"]
        listOfCategories = callApiEndpoint.getCategories();
    }

    //Iterate over each category name (e. animal, sport, etc..)  and use it as a parameter to get content of jokes 
    // for this category
    //Then validate them against each json file in the fixtures
    @Feature("Jokes Api")
    @Description("Invoke each one of the categories detail page")
    @Test(priority = 1, description = "Invoke Jokes Category Page")
    public void getAndValidateContentForEachCategory() {
        for (int i = 0; i < listOfCategories.size(); i++) {

            String jokesCategoryName = listOfCategories.get(i);
            String jokesCategoryContentAsString =
                    callApiEndpoint.getJokesForSpecificCategory(jokesCategoryName).asString();
            callApiEndpoint.validateJokesForSpecificCategory(jokesCategoryContentAsString, jokesCategoryName);
        }

    }

}
