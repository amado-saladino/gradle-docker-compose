package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public abstract class WebDriverFactory {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        String browser = PropertyReader.getProperty("BROWSER");

        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver(chromeOptions());
                    break;
                case "chrome-headless":
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    options.addArguments("window-size=2000,1200");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(true);
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    System.out.println("Invalid browser option");
                    System.exit(1);
            }
        }
        return driver;
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.addArguments("--lang=de");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public static void stopDriver() {
        driver.quit();
        driver = null;
    }
}
