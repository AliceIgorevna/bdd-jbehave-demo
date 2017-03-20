package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

/**
 * Created by User on 3/13/2017.
 */
public class DriverCreator {
    protected DriverCreator() {
    }

    private static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";

    public WebDriver createChromeDriver() {
        System.setProperty(CHROME_DRIVER_KEY, CHROME_DRIVER_PATH);
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        caps.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors", "--disable-popup-blocking", "--disable-translate"));
        caps.setCapability("chrome.switches", Arrays.asList("--user-agent=Mozilla/5.0 (Linux; U; Android 4.0.2; en-us; Galaxy Nexus Build/ICL53F) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"));
        options.addArguments(Arrays.asList("allow-running-insecure-content", "ignore-certificate-errors", "--disable-popup-blocking"));
        options.addArguments("--test-type");
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        return new ChromeDriver(caps);
    }
}
