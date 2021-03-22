package org.audibene.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Configuration {

    public static final int IMPLICIT_WAIT_TIME = 10;

    WebDriver mydriver;
    String RUNNING_OPTION = "LOCAL.MAC";

    public Configuration(WebDriver driver) {
        this.mydriver = driver;
    }

    public WebDriver setUp() throws MalformedURLException {


        if (RUNNING_OPTION == "LOCAL.WIN") {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources" +
                    "/chromedriver.exe");
            mydriver = new ChromeDriver();
            mydriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            mydriver.manage().window().maximize();
            return mydriver;
        }
        if (RUNNING_OPTION == "LOCAL.MAC") {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
            mydriver = new ChromeDriver();
            mydriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            mydriver.manage().window().maximize();
            return mydriver;
        }

       if (RUNNING_OPTION == "DOCKER.CHROME"){
            mydriver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            mydriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
            mydriver.manage().window().maximize();
            return mydriver;
        }
        else{
            return mydriver;
        }

    }
}
