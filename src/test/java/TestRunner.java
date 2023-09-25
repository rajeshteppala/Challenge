import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import core.BaseClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = ("src/test/resources/Features"),
        glue = {"stepdefinitions"},
        plugin = {"pretty",
                "html:output/HTML/report.html",
                "junit:output/JUNIT/report.xml",
                "json:output/JSON/report.json"
        },
        tags = "@createAndScheduleTask"
)
public class TestRunner {

        @Before
        public void setUp() {
                BaseClass baseTest = new BaseClass();
                baseTest.initialBrowserSetUp();
        }

        @After
        public void tearDown() {
                BaseClass baseTest = new BaseClass();
                baseTest.tearDown();
        }

}
