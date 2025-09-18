package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //  publish = true,
        features = "src/test/resources/features",
        glue = {
                "hooks",
                "step_definitions"
        },
        monochrome = true,
        plugin ={"pretty",
                "html:target/site/cucumber-report-default",
                "json:target/site/cucumber.json",
                "junit:target/cucumber.xml",
               "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        // snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@login"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}


