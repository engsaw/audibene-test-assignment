package org.audibene.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.audibene.pom.DynamicControlsPagePOM;
import org.audibene.utilities.Configuration;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;

public class DynamicControlsAsyncUITests {

    public WebDriver driver;

    Configuration myConfiguration;

    UIHelpers myUIHelpers;

    DynamicControlsPagePOM dynamicControlsPagePOM;

    @Feature("Dynamic Controls Async Feature")
    @BeforeTest()
    public void setUp() throws MalformedURLException {
        myConfiguration = new Configuration(driver);
        driver = myConfiguration.setUp();
        myUIHelpers = new UIHelpers(driver);
        //Create an instance of exit intent Page object model
        dynamicControlsPagePOM = new DynamicControlsPagePOM(this.driver);
    }

    @Feature("Dynamic Controls Async Feature")
    @Description("Mouse out of the viewport pane and see a modal window appear")
    @Test(priority = 0, description = "Mouse should get Out Of the viewport pane and see a modal window appear")
    public void interactWithDynamicControls() throws AWTException {

        //Open Dynamic Controls page URL
        driver.get(DynamicControlsPagePOM.URL);

        //Check that enable/disable button works properly
        dynamicControlsPagePOM.checkEnableDisableButtonWorks();
    }

    @Feature("Dynamic Controls Async Feature")
    @AfterTest
    public void tearDown() {
        //Close window
        myUIHelpers.closeWindow();
    }
}
