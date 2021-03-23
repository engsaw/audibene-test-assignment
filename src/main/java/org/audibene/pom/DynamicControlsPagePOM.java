package org.audibene.pom;

import io.qameta.allure.Step;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlsPagePOM {

    public static final String INPUT_TEXT = "Sherif";

    public static String pageTitle = "The Internet";

    public static String URL = "https://the-internet.herokuapp.com/dynamic_controls";

    public static String swapButtonProperty = "//*[@id=\"input-example\"]/button";

    public static String swapTextboxProperty = "//*[@id=\"input-example\"]/input";

    public static String enableDisableLabelProperty = "//*[@id=\"message\"]";

    private final WebDriver mydriver;

    UIHelpers UIHelpers;

    By swapButton = By.xpath(swapButtonProperty);

    By swapTextbox = By.xpath(swapTextboxProperty);

    By enableDisableLabel = By.xpath(enableDisableLabelProperty);

    public DynamicControlsPagePOM(WebDriver driver) {
        this.mydriver = driver;
        this.UIHelpers = new UIHelpers(mydriver);
    }

    @Step("")
    public void checkEnableDisableButtonWorks() {

        WebElement inputTextField = mydriver.findElement(swapTextbox);

        //First Check input field is disable
        assertFalse(inputTextField.isEnabled());

        //Click enable button
        mydriver.findElement(swapButton).click();

        //Wait until input field is enabled
        await().atMost(60, TimeUnit.SECONDS).until((inputTextField::isEnabled), is(true));

        //Check input field is enabled
        assertTrue(inputTextField.isEnabled());

        //Send text to the input box
        inputTextField.sendKeys(INPUT_TEXT);

        //Click on disable button again
        mydriver.findElement(swapButton).click();

        //wait until input field is disabled again
        await().atMost(60, TimeUnit.SECONDS).until(inputTextField::isEnabled, is(false));

        //Check the input field is diabled again
        assertFalse(inputTextField.isEnabled());

        //Check the value of input field
        assertEquals(inputTextField.getAttribute("value"), INPUT_TEXT);
    }

}
