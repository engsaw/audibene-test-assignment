package org.audibene.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.audibene.pom.SortingPagePOM;
import org.audibene.utilities.Configuration;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class SortingUITests {

    WebDriver driver;

    Configuration myConfiguration;

    UIHelpers myUIHelpers;

    SortingPagePOM sortingPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        myConfiguration = new Configuration(driver);
        driver = myConfiguration.setUp();
        myUIHelpers = new UIHelpers(driver);
        //Create an instance of sorting  Page object model
        sortingPage = new SortingPagePOM(this.driver);
    }

    @Feature("Sorting")
    @Description("Open sorting page")
    @Test(priority = 0, description = "Open Sorting Page")
    public void openSortingPage() {
        //Open sorting page URL
        driver.get(SortingPagePOM.URL);
    }

    @Feature("Sorting")
    @Description("loop through last name in first table and add them to an array of strings then validate sorting")
    @Test(priority = 0, description = "Should validate last Name in first table is sorted A-Z")
    public void validateLastNameFirstTableAreSorted() {
        //Validate Last names in sorting page are sorted
        sortingPage.validateLastNameFirstTableAreSorted();
    }

    @Feature("Sorting")
    @Description("loop through first name in second table and add them to an array of strings then validate sorting")
    @Test(priority = 0, description = "Should validate first Name in second table is sorted A-Z")
    public void validateFirstNameSecondTableAreSorted() {
        //Validate Last names in sorting page are sorted
        sortingPage.validatefirstNameSecondTableAreSorted();
    }

    @AfterTest
    public void tearDown() {
        //Close window
        myUIHelpers.closeWindow();
    }
}
