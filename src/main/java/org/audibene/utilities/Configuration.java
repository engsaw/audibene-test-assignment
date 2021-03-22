package org.audibene.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Configuration {

    WebDriver mydriver;
    String runninngOption = "LOCAL.MAC";

    public Configuration(WebDriver driver) {
        this.mydriver = driver;
    }

    public WebDriver setUp() throws MalformedURLException {


        if (runninngOption == "LOCAL.WIN") {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
            mydriver = new ChromeDriver();
            mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            mydriver.manage().window().maximize();
            return mydriver;
        }
        if (runninngOption == "LOCAL.MAC") {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
            mydriver = new ChromeDriver();
            mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            mydriver.manage().window().maximize();
            return mydriver;
        }

        else if (runninngOption == "dockerChrome"){
            mydriver = new RemoteWebDriver(new URL("http:localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            mydriver.manage().window().maximize();
            return mydriver;

        }
        else{
            return mydriver;
        }

    }
}
