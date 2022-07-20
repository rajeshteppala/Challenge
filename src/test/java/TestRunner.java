import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = ("src/test/resources/Features"),
        glue = {"StepDefinitions"},
        plugin = {"pretty",
                "html:output/HTML/report.html",
                "junit:output/JUNIT/report.xml",
                "json:output/JSON/report.json"
        },
        tags = "@add"
)
public class TestRunner {
}