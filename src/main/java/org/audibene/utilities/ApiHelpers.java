package org.audibene.utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiHelpers {

    public ApiHelpers() {
    }

    //function that reads the json fixtures for jokes categories and return the contents
    public String readJsonFixtures(String jokesCategoryName){
        Path jsonFixturePath = Paths.get(System.getProperty("user.dir")+"/src/main/java/fixtures/"+jokesCategoryName+".json");
        String content;
        try
        {
             content = Files.readString(jsonFixturePath);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            content="Error";
        }
        return content;
    }

}
