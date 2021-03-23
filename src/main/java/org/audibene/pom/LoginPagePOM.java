package org.audibene.pom;

import io.qameta.allure.Step;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPagePOM {

    private WebDriver mydriver;

    UIHelpers UIHelpers;

    public static String userNameTxtboxProperty = "//*[@id=\"username\"]";

    public static String passwordTxtboxProperty = "//*[@id=\"password\"]";

    public static String loginBtnProperty = "//*[@id=\"login\"]/button/i";

    public static String loggedInFlashProperty = "//*[@id=\"flash\"]";

    public static String successfulLoggedInFlashTxt = "You logged into a secure area!\n×";

    public static String unSuccessfulLoggedInFlashTxt = "Your username is invalid!";

    public static String correctUserName = "tomsmith";

    public static String wrongUserName = "nottomsmith";

    public static String correctPassword = "SuperSecretPassword!";

    public static String wrongPassword = "notSuperSecretPassword!";

    public static String loginPageURL = "https://the-internet.herokuapp.com/login";

    By userNameTxtbox = By.xpath(userNameTxtboxProperty);

    By passwordTxtbox = By.xpath(passwordTxtboxProperty);

    By loginBtn = By.xpath(loginBtnProperty);

    By loggedInFlash = By.xpath(loggedInFlashProperty);

    @Step("Login Step with username : {0} , password : {1} ")
    public void login(String username, String password) {
        mydriver.findElement(userNameTxtbox).sendKeys(username);
        mydriver.findElement(passwordTxtbox).sendKeys(password);
        mydriver.findElement(loginBtn).click();

    }

    @Step("validate Successful Login")
    public void validateSuccessfulLogin() {
        assertEquals(mydriver.findElement(loggedInFlash).getText(), successfulLoggedInFlashTxt);
        UIHelpers.takeScreenshot(mydriver);

    }

    @Step("validate UnSuccessful Login")
    public void validateUnSuccessfulLogin() {
        assertTrue(mydriver.findElement(loggedInFlash).getText().contains(unSuccessfulLoggedInFlashTxt));
        UIHelpers.takeScreenshot(mydriver);
    }

    public LoginPagePOM(WebDriver driver) {
        this.mydriver = driver;
        this.UIHelpers = new UIHelpers(mydriver);
    }

}
