package hooks;

import commons.DriverManager;
import context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ScreenshotUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private TestContext context;
    private WebDriver driver;

    public Hooks(TestContext context) {
        this.context = context;
    }


    @Before
    public void beforeTest(Scenario scenario) throws IOException {
        context.getDriverManager().getDriver();
        System.out.println(">>> Browser started");
        context.getDriverManager().openURL("dev");
        context.getDriverManager().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
//    @AfterStep
//    public void afterStep(Scenario scenario) {
//        if (scenario.isFailed()) {
//            new ScreenshotUtils((TestContext) driver).takeScreenshot();
//        }
//    }


    @After
    public void afterTest(Scenario scenario) throws IOException {
//        if (scenario.isFailed()) {
//            ScreenshotUtils screenshot = new ScreenshotUtils((TestContext) driver);
//            screenshot.takeScreenshot();  // chụp và attach vào Allure
//        }

        context.getDriverManager().closeDriver();
        System.out.println(">>> Browser closed");
    }


}