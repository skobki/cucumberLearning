package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.WebDriverFactory;

public class DriverHooks {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(DriverHooks.class);

    @Before
    public void startDriverBeforeScenario() {
        String browser = System
                .getProperty("browser", "chrome")
                .toLowerCase();
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser));
        logger.info("Драйвер запущен");
    }

    @After
    public void stopDriverAfterScenario() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен");
        }
    }
}
