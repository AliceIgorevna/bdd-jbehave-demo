package driver;

import org.openqa.selenium.WebDriver;

/**
 * Created by User on 3/13/2017.
 */
public class DriverFactory {
    private WebDriver driver;
    private DriverCreator creator;

    public DriverFactory() {
        creator = new DriverCreator();
    }

    public WebDriver createWebDriver(String kind) {
        if(kind.equalsIgnoreCase(BrowserKind.CHROME.toString())){
            driver = creator.createChromeDriver();
        }
        return driver;
    }
}
