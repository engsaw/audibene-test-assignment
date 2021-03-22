package org.audibene.pom;

import io.qameta.allure.Step;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class SortingWindowPOM {

    private WebDriver mydriver;

    UIHelpers uiHelpers;

    String[] lastNamesArrayFromFirstTable;
    String[] firstNamesArrayFromSecondTable;
    public static int TABLE_SIZE=4;
    public static int LAST_NAME_COLUMN_NUMBER = 1;
    public static int FIRST_NAME_COLUMN_NUMBER = 2;
    public static String URL = "https://the-internet.herokuapp.com/tables";

    public SortingWindowPOM(WebDriver driver) {
        this.mydriver = driver;
        this.uiHelpers = new UIHelpers(mydriver);
    }

    @Step("Iterate Over Last name field in all rows in first table and check they are sorted")
    public void validateLastNameFirstTableAreSorted() {

        lastNamesArrayFromFirstTable = new String[TABLE_SIZE];

        //Iterate Over Last name field in all rows in first table
        uiHelpers.iterateOverFirstTableCollectLastName(TABLE_SIZE,LAST_NAME_COLUMN_NUMBER,lastNamesArrayFromFirstTable);

        //Check that the last names from first table array is sorted
        assertEquals(uiHelpers.isNameArraySortedAZ(lastNamesArrayFromFirstTable),true);

    }

    @Step("Iterate Over first name field in all rows in second table and check they are sorted")
    public void validatefirstNameSecondTableAreSorted() {
        firstNamesArrayFromSecondTable = new String[TABLE_SIZE];

        //Iterate Over Last name field in all rows in first table
        uiHelpers.iterateOverSecondTableCollectFirstName(TABLE_SIZE,FIRST_NAME_COLUMN_NUMBER,firstNamesArrayFromSecondTable);

        //Check that the last names from first table array is sorted
        assertEquals(uiHelpers.isNameArraySortedAZ(firstNamesArrayFromSecondTable),true);
    }
}
