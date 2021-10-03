package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import web.drivers.WebDriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

public class ScreenShotHooks {
    private Logger logger = LogManager.getLogger(ScreenShotHooks.class);

    @BeforeStep
    public void takeScreenShotBeforeStep(Scenario scenario) {
        try {
            Screenshot screenshot = new AShot().takeScreenshot(
                    WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\" + name));
            logger.info("Скриншот сохранен в файле [temp\\" + name + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario) {
        try {
            Screenshot screenshot = new AShot().takeScreenshot(
                    WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\" + name));
            logger.info("Скриншот сохранен в файле [temp\\" + name + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
