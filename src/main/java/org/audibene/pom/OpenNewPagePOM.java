package org.audibene.pom;
import io.qameta.allure.Step;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OpenNewPagePOM {

    public static final String NEW_WINDOW_TEXT = "New Window";
    private WebDriver mydriver;
    UIHelpers UIHelpers;
    public static String URL = "https://the-internet.herokuapp.com/windows";
    public static String clickHereButtonProperty = "//*[@id=\"content\"]/div/a";
    public static String newPageBodyProperty = "/html/body/div/h3";

    By clickHereButton = By.xpath(clickHereButtonProperty);
    By newPageBody = By.xpath(newPageBodyProperty);

    //Constructor, set the driver & instantiate utility classes
    public OpenNewPagePOM(WebDriver driver) {
        this.mydriver = driver;
        this.UIHelpers = new UIHelpers(mydriver);
    }

    @Step("Click on Click Here Button")
    public void clickClickHereButton() {
        mydriver.findElement(clickHereButton).click();
    }

    //Function to switch tab based on index of the tab
    @Step("Click on Click Here Button")
    public void switchToAnotherTab(int tabIndex) {
        List<String> browserTabs = new ArrayList<String>(mydriver.getWindowHandles());
        mydriver.switchTo().window(browserTabs.get(tabIndex));
    }

    @Step("Click on Click Here Button")
    public void validateNewPageContent() {
        assertEquals(  mydriver.findElement(newPageBody).getText(), NEW_WINDOW_TEXT);
    }

}
