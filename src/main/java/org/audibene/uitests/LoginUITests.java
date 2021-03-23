package org.audibene.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.audibene.pom.LoginPagePOM;
import org.audibene.utilities.Configuration;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginUITests {

    WebDriver driver;

    Configuration myConfiguration;

    UIHelpers myUIHelpers;

    LoginPagePOM loginPage;

    @Feature("Login")
    @BeforeTest
    public void setUp() throws MalformedURLException {
        myConfiguration = new Configuration(driver);
        driver = myConfiguration.setUp();
        myUIHelpers = new UIHelpers(driver);
    }

    @Feature("Login")
    @Description("Provide correct password and check the results")
    @Test(priority = 0, description = "Should login with correct user/password successfully")
    public void loginSuccessfully() {

        //Create an instance of Login Page object model
        loginPage = new LoginPagePOM(this.driver);

        //Open Login page URL
        driver.get(LoginPagePOM.loginPageURL);

        //Login using correct user/pass
        loginPage.login(LoginPagePOM.correctUserName, LoginPagePOM.correctPassword);

        //Validate we logged in successfully
        loginPage.validateSuccessfulLogin();
    }

    @Feature("Login")
    @Description("Provide wrong password and check the results")
    @Test(priority = 1, description = "Should fail to login with wrong user/password")
    public void loginUnSuccessfully() {

        //Create an instance of Login Page object model
        LoginPagePOM loginPage = new LoginPagePOM(this.driver);

        //Open Login page URL
        driver.get(LoginPagePOM.loginPageURL);

        //Login using correct user/pass
        loginPage.login(LoginPagePOM.wrongUserName, LoginPagePOM.wrongPassword);

        //Validate we logged in successfully
        loginPage.validateUnSuccessfulLogin();
    }

    @Feature("Login")
    @AfterTest
    public void tearDown() {
        //Close window
        myUIHelpers.closeWindow();
    }
}
