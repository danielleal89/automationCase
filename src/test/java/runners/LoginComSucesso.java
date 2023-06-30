package runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/LoginComSucesso.feature",
		plugin = {"pretty"},
		monochrome = true,
		dryRun = false,
		glue = {"steps"},
		tags = {"@LoginComSucesso"}
)
public class LoginComSucesso {
	
}
