package org.audibene.utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UIHelpers {

    WebDriver mydriver;

    public UIHelpers(WebDriver mydriver) {
        this.mydriver = mydriver;
    }

    //This function closes the browser window
    public void closeWindow() {
        //Close the browser window
        mydriver.close();
    }

    //This function takes screenshot and return it and add it to allure report
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) mydriver).getScreenshotAs(OutputType.BYTES);
    }

    //This function checks if an array is sorted or not A-Z
    public boolean isNameArraySortedAZ(String[] namesArray) {
        for (int i = 0; i < namesArray.length - 1; ++i) {
            if (namesArray[i].compareTo(namesArray[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    //This function iterates over first table reading all last names and store them in an string array
    public String[] iterateOverFirstTableCollectLastName(int tableSize, int column,
                                                         String[] lastNamesArrayFromFirstTable) {
        for (int i = 1; i < tableSize + 1; i++) {
            lastNamesArrayFromFirstTable[i - 1] = mydriver.findElement(By.xpath(String.format("//*[@id=\"table1" +
                    "\"]/tbody/tr[%2d]/td[%2d]", i, column))).getText();
        }
        return lastNamesArrayFromFirstTable;
    }

    //This function iterates over second table reading all first names and store them in an string array
    public String[] iterateOverSecondTableCollectFirstName(int tableSize, int column,
                                                           String[] firstNamesArrayFromSecondTable) {
        for (int i = 1; i < tableSize + 1; i++) {
            firstNamesArrayFromSecondTable[i - 1] = mydriver.findElement(By.xpath(String.format("//*[@id=\"table2" +
                    "\"]/tbody/tr[%2d]/td[%2d]", i, column))).getText();
        }
        return firstNamesArrayFromSecondTable;
    }

}
