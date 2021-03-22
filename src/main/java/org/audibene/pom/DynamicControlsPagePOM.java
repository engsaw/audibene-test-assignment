package org.audibene.pom;

import io.qameta.allure.Step;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

import static org.testng.Assert.assertEquals;

public class DynamicControlsPagePOM {

    private WebDriver mydriver;
    UIHelpers UIHelpers;

    public static String pageTitle = "The Internet";
    public static String URL = "https://the-internet.herokuapp.com/dynamic_controls";
    public static String swapButtonProperty = "//*[@id=\"input-example\"]/button";
    public static String swapTextboxProperty = "//*[@id=\"input-example\"]/input";



    By swapButton = By.xpath(swapButtonProperty);
    By swapTextbox = By.xpath(swapTextboxProperty);



    @Step("")
    public void checkSwapTextboxIsDisabled() {

        assertEquals( (mydriver.findElement(swapTextbox)).isEnabled(),false);
        mydriver.findElement(swapButton).click();

    }



    public DynamicControlsPagePOM(WebDriver driver) {
        this.mydriver = driver;
        this.UIHelpers = new UIHelpers(mydriver);
    }

}
