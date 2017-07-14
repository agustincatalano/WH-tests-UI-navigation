package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by agustin on 09/06/2017.
 */
public class DriverFactory {
    private static WebDriver driver;

    private void setDriver() {
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }
}
