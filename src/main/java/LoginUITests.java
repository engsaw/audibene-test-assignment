import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginUITests {
    WebDriver driver;
    Configuration myConfiguration;
    Helpers myHelpers;

@BeforeTest
public void setUp(){
    myConfiguration = new Configuration(driver);
    driver = myConfiguration.setUp();
    myHelpers = new Helpers(driver);
}

    @Feature("Login")
    @Description("Provide correct password and check the results")
    @Test(priority = 0)
    public void loginSuccessfully() {

        //Create an instance of Login Page object model
        LoginPagePOM loginPage = new LoginPagePOM(this.driver);

        //Open Login page URL
        driver.get(loginPage.loginPageURL);

        //Login using correct user/pass
        loginPage.login(loginPage.correctUserName,loginPage.correctPassword);

        //Validate we logged in successfully
        loginPage.validateSuccessfulLogin();


    }

    @Feature("Login")
    @Description("Provide wrong password and check the results")
    @Test (priority = 1)
    public void loginUnSuccessfully() {

        //Create an instance of Login Page object model
        LoginPagePOM loginPage = new LoginPagePOM(this.driver);

        //Open Login page URL
        driver.get(loginPage.loginPageURL);

        //Login using correct user/pass
        loginPage.login(loginPage.wrongUserName,loginPage.wrongPassword);

        //Validate we logged in successfully
        loginPage.validateUnSuccessfulLogin();
    }

    @AfterTest
    public void tearDown() {
        //Close window
        myHelpers.closeWindow();
    }
}
