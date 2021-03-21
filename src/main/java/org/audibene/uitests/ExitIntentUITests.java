package org.audibene.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.audibene.utilities.*;
import org.audibene.pom.ExitIntentPagePOM;

import java.awt.*;
import java.net.MalformedURLException;

public class ExitIntentUITests {
    public WebDriver driver;
    Configuration myConfiguration;
    UIHelpers myUIHelpers;
    ExitIntentPagePOM exitIntentPage;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        myConfiguration = new Configuration(driver);
        driver = myConfiguration.setUp();
        myUIHelpers = new UIHelpers(driver);
        //Create an instance of exit intent Page object model
        exitIntentPage = new ExitIntentPagePOM(this.driver);
    }

    @Feature("Exit Intent Page")
    @Description("Mouse out of the viewport pane and see a modal window appear")
    @Test(priority = 0, description = "Mouse out of the viewport pane and see a modal window appear")
    public void exitIntent() throws AWTException {


        //Open exitIntentPage page URL
        driver.get(ExitIntentPagePOM.exitIntentPageURL);

        //Move mouse
        exitIntentPage.moveMouseOutOFViewPort();

        //Check for Intent window
        exitIntentPage.checkForModalWindow();

        //Close intent window
        exitIntentPage.closeModalWindow();

    }

    @AfterTest
    public void tearDown() {
        //Close window
        myUIHelpers.closeWindow();
    }
}
