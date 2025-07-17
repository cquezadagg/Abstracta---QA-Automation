package hooks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class Hooks {

    public static ExtentReports extent;
    public static ExtentTest feature;
    public static ExtentTest scenarioTest;
    WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        extent = ExtentReportManager.getInstance();
        clearScreenshotsFolder();
    }

@Before
public void beforeScenario(Scenario scenario) {
    System.out.println(">>> Iniciando escenario: " + scenario.getName());
    driver = DriverManager.getDriver();
    driver.get("http://opencart.abstracta.us/");
    scenarioTest = extent.createTest(scenario.getName());
}


 @AfterStep
public void afterStep(Scenario scenario) {
    String screenshotName = "step_" + System.currentTimeMillis();
    String screenshotPath = ScreenshotUtil.takeScreenshot(driver, screenshotName);

    String relativePath = "screenshots/" + screenshotName + ".png";

    if (scenario.isFailed()) {
        scenarioTest.fail("Paso fallido").addScreenCaptureFromPath(relativePath);
    } else {
        scenarioTest.pass("Paso correcto").addScreenCaptureFromPath(relativePath);
    }
}



    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @AfterAll
    public static void afterAll() {
        extent.flush();
    }

    private static void clearScreenshotsFolder() {
        Path screenshotsDir = Path.of("results/screenshots");
        try (Stream<Path> files = Files.walk(screenshotsDir)) {
            files
                .filter(Files::isRegularFile)
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        System.err.println("Error al eliminar screenshot: " + path);
                    }
                });
            System.out.println("✅ Carpeta de screenshots limpiada.");
        } catch (IOException e) {
            System.err.println("Error al limpiar la carpeta de screenshots: " + e.getMessage());
        }
    }    

}