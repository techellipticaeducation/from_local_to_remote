package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features/login.feature",
		glue = "stepdef",
		dryRun = false,
		tags = "@regression and (@positive or @smoke)"
		)
public class TestRunner {

// Action- Execute test case
	// Create Step def


}
