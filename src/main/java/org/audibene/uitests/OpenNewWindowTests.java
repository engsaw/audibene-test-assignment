package org.audibene.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.audibene.pom.OpenNewWindowPOM;
import org.audibene.utilities.Configuration;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class OpenNewWindowTests {

    WebDriver driver;
    Configuration myConfiguration;
    UIHelpers myUIHelpers;
    OpenNewWindowPOM openNewWindowPOM;

    @BeforeTest
    public void setUp() {
        myConfiguration = new Configuration(driver);
        driver = myConfiguration.setUp();
        myUIHelpers = new UIHelpers(driver);
        openNewWindowPOM = new OpenNewWindowPOM(this.driver);

    }

    @Feature("Open New Window window ;)")
    @Description("test that the click opens a new browser-tab or new window")
    @Test(priority = 0, description = "test that the click opens a new browser-tab or new window")
    public void openNewWindowPage() {
        //Create an instance of Open New Page object model
        driver.get(openNewWindowPOM.URL);


        //Click on Click here button to open a new page
        openNewWindowPOM.clickClickHereButton();


        //Switch to new Tab
        openNewWindowPOM.switchToAnotherTab(1);

        //Validate new window is correct
        openNewWindowPOM.validateNewPageContent();

    }

    @AfterTest
    public void tearDown() {
        //Close window
        myUIHelpers.closeWindow();
    }

}
