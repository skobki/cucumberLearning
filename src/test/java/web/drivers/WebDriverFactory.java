package web.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    private static WebDriver webDriver;

    public static WebDriver getDriver(BrowserName name) {
        switch (name) {
            case CHROME:
                logger.info("Драйвер для браузера Chrome");
                webDriver = ChromeBrowserDriver.getDriver();
                return webDriver;
            case FIREFOX:
                logger.info("Драйвер для браузера Firefox");
                webDriver = FirefoxBrowserDriver.getDriver();
                return webDriver;
            case EDGE:
                logger.info("Драйвер для браузера Edge");
                webDriver = EdgeBrowserDriver.getDriver();
                return webDriver;
            default:
                throw new RuntimeException("Некорректное имя браузера");
        }
    }
    public static WebDriver getCurrentDriver() {
        return webDriver;
    }
}
