package org.audibene.apitests;

import org.audibene.utilities.ApiHelpers;
import org.audibene.utilities.Configuration;
import org.audibene.utilities.UIHelpers;
import org.audibene.utilities.CallApiEndpoint;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;



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

    @Test
    public void getCategories() {

       listOfCategories = callApiEndpoint.getCategories();

        for(int i = 0; i< listOfCategories.size(); i++){

            System.out.println(callApiEndpoint.getJokesForSpecificCategory(listOfCategories.get(i)));
           // callApiEndpoint.validateJokesForSpecificCategory();
        }
    }
    @Test
    public void getContentForEachCategory() {


        for(int i = 0; i< listOfCategories.size(); i++){

            callApiEndpoint.getCategories();
        }
    }


}
