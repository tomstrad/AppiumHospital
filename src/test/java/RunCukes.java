import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue= {"techtest"},
        plugin = { "pretty", "junit:target/cucumber-reports/uitest.xml" },
        monochrome = true)
public class RunCukes {
}