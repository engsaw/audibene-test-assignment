package org.audibene.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Configuration {

    WebDriver mydriver;

    public Configuration(WebDriver driver) {
        this.mydriver = driver;
    }

    public WebDriver setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        mydriver = new ChromeDriver();
        mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mydriver.manage().window().maximize();
        return mydriver;
    }
}
