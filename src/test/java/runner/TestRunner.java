package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", 
				 glue= {"stepdefination","hooks"}, 
				 publish=true,
				 plugin={ "pretty","html:target/cucumberReports/Reports.html" },
				 monochrome=true)

public class TestRunner {

	
}
