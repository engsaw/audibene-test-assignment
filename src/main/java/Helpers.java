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
}
