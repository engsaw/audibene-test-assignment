package org.audibene.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.audibene.utilities.UIHelpers;
import java.awt.*;

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

    By ouibounceModal = By.xpath(ouibounceModalProperty);
    By ouibounceModalDivTitle = By.xpath(ouibounceModalDivTitleProperty);
    By closeBtn = By.xpath(closeBtnProperty);

    @Step("Move mouse out of view port at 0,0")
    public void moveMouseOutOFViewPort() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(0, 0);
    }

    @Step("Check For Modal Window existance and Check Title content")
    public void checkForModalWindow() {
        mydriver.findElement(ouibounceModal).click();
        assertEquals(mydriver.findElement(ouibounceModalDivTitle).getText(), ouibounceModalDivTitleText);
      UIHelpers.takeScreenshot(mydriver);

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
