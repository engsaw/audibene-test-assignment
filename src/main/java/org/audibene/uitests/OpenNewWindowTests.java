package org.audibene.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.audibene.pom.OpenNewPagePOM;
import org.audibene.utilities.Configuration;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class OpenNewWindowTests {

    WebDriver driver;

    Configuration myConfiguration;

    UIHelpers myUIHelpers;

    OpenNewPagePOM openNewWindowPOM;

    @Feature("Open popup Window window ;)")
    @BeforeTest
    public void setUp() throws MalformedURLException {
        myConfiguration = new Configuration(driver);
        driver = myConfiguration.setUp();
        myUIHelpers = new UIHelpers(driver);
        openNewWindowPOM = new OpenNewPagePOM(this.driver);

    }

    @Feature("Open popup Window window ;)")
    @Description("Test that the click opens a new browser-tab or new window")
    @Test(priority = 0, description = "Should click opens a new browser-tab or new window")
    public void openNewWindowPage() {
        //Create an instance of Open New Page object model
        driver.get(OpenNewPagePOM.URL);

        //Click on Click here button to open a new page
        openNewWindowPOM.clickClickHereButton();

        //Switch to new Tab
        openNewWindowPOM.switchToAnotherTab(1);

        //Validate new window is correct
        openNewWindowPOM.validateNewPageContent();

        //Close the new tab
        myUIHelpers.closeWindow();

    }

    @Feature("Open popup Window window ;)")
    @AfterTest
    public void tearDown() {
        //Close window
        openNewWindowPOM.switchToAnotherTab(0);

        myUIHelpers.closeWindow();
    }

}
