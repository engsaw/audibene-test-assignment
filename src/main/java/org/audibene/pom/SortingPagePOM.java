package org.audibene.pom;

import io.qameta.allure.Step;
import org.audibene.utilities.UIHelpers;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SortingPagePOM {

    UIHelpers uiHelpers;

    String[] lastNamesArrayFromFirstTable;

    String[] firstNamesArrayFromSecondTable;

    public static int TABLE_SIZE = 4; //number of rows in both tables are 4

    public static int LAST_NAME_COLUMN_NUMBER = 1; //Last name is in first column

    public static int FIRST_NAME_COLUMN_NUMBER = 2; //First name is in second column

    public static String URL = "https://the-internet.herokuapp.com/tables";

    //Constructor, set the driver & instantiate utility classes
    public SortingPagePOM(WebDriver driver) {
        this.uiHelpers = new UIHelpers(driver);
    }

    @Step("Iterate Over Last name field in all rows in first table and check they are sorted")
    public void validateLastNameFirstTableAreSorted() {

        //instantiate an array to store last names from first table
        lastNamesArrayFromFirstTable = new String[TABLE_SIZE];

        //Iterate Over Last name field in all rows in first table
        uiHelpers.iterateOverFirstTableCollectLastName(TABLE_SIZE, LAST_NAME_COLUMN_NUMBER,
                lastNamesArrayFromFirstTable);

        //Check that the last names from first table array is sorted
        assertTrue(uiHelpers.isNameArraySortedAZ(lastNamesArrayFromFirstTable));

    }

    @Step("Iterate Over first name field in all rows in second table and check they are sorted")
    public void validatefirstNameSecondTableAreSorted() {

        //instantiate an array to store first names from second table
        firstNamesArrayFromSecondTable = new String[TABLE_SIZE];

        //Iterate Over Last name field in all rows in first table
        uiHelpers.iterateOverSecondTableCollectFirstName(TABLE_SIZE, FIRST_NAME_COLUMN_NUMBER,
                firstNamesArrayFromSecondTable);

        //Check that the last names from first table array is sorted
        assertTrue(uiHelpers.isNameArraySortedAZ(firstNamesArrayFromSecondTable));
    }
}
