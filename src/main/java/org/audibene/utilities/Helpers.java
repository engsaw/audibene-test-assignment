package org.audibene.utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {
    WebDriver mydriver;

    public Helpers(WebDriver mydriver) {
        this.mydriver = mydriver;
    }

    public void closeWindow(){
        //Close the browser window
        mydriver.close();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte [] takeScreenshot(WebDriver driver){

        return ((TakesScreenshot) mydriver).getScreenshotAs(OutputType.BYTES);

    }

}
