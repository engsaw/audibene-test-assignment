import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPagePOM {

    private  WebDriver mydriver;

    static  String userNameTxtboxProperty = "//*[@id=\"username\"]";
    static String passwordTxtboxProperty = "//*[@id=\"password\"]";
    static String loginBtnProperty = "//*[@id=\"login\"]/button/i";
    static String loggedInFlashProperty = "//*[@id=\"flash\"]";
    static String successfulLoggedInFlashTxt = "You logged into a secure area!\n×";
    static String unSuccessfulLoggedInFlashTxt = "Your username is invalid!";

    static String correctUserName = "tomsmith";
    static String wrongUserName = "nottomsmith";
    static String correctPassword = "SuperSecretPassword!";
    static String wrongPassword = "notSuperSecretPassword!";
    static String loginPageURL = "https://the-internet.herokuapp.com/login";

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
    public void validateSuccessfulLogin(){
        assertEquals(mydriver.findElement(loggedInFlash).getText(), successfulLoggedInFlashTxt);
    }

    @Step("validate UnSuccessful Login")
    public void validateUnSuccessfulLogin(){
        assertTrue(mydriver.findElement(loggedInFlash).getText().contains(unSuccessfulLoggedInFlashTxt));
    }

     LoginPagePOM(WebDriver driver) {
        this.mydriver = driver;
    }


}
