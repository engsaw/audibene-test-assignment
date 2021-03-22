package org.audibene.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.testng.Assert.assertEquals;

public class ExitIntentPagePOM {

    private WebDriver mydriver;
    UIHelpers UIHelpers;

    public static String pageTitle = "The Internet";
    public static String URL = "https://the-internet.herokuapp.com/exit_intent";
    public static String ouibounceModalProperty = "//*[@id=\"ouibounce-modal\"]/div[2]";
    public static String ouibounceModalDivTitleProperty = "//*[@id=\"ouibounce-modal\"]/div[2]/div[1]/h3";
    public static String ouibounceModalDivTitleText = "THIS IS A MODAL WINDOW";
    public static String closeBtnProperty = "//*[@id=\"ouibounce-modal\"]/div[2]/div[3]/p";
    public static String pageContentProperty = "//*[@id=\"content\"]/div[1]/h3";

    By ouibounceModal = By.xpath(ouibounceModalProperty);
    By ouibounceModalDivTitle = By.xpath(ouibounceModalDivTitleProperty);
    By closeBtn = By.xpath(closeBtnProperty);
    By pageContent = By.xpath(pageContentProperty);

    @Step("Move mouse out of view port at 0,0")
    public void moveMouseOutOFViewPort() throws AWTException {
        Robot robot = new Robot();
        await().atMost(3, TimeUnit.SECONDS).until(mydriver.findElement(pageContent)::isEnabled);
        robot.mouseMove(600,-1);
        robot.mouseMove(100,100);
        robot.mouseMove(600,-1);
    }

    @Step("Check For Modal Window existance and Check Title content")
    public void checkForModalWindow() {

        mydriver.findElement(ouibounceModal).click();
        UIHelpers.takeScreenshot(mydriver);
        assertEquals(mydriver.findElement(ouibounceModalDivTitle).getText(), ouibounceModalDivTitleText);

    }

    @Step("Close the Model window")
    public void closeModalWindow() {
        mydriver.findElement(closeBtn).click();

    }

    public ExitIntentPagePOM(WebDriver driver) {
        this.mydriver = driver;
        this.UIHelpers = new UIHelpers(mydriver);
    }


}
