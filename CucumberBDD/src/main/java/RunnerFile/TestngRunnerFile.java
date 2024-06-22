package RunnerFile;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "./src/test/java/features",glue = "stepDefinitions",dryRun = false,monochrome = true
                  /*tags = "@smokeTest or @regTest"*/,plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"})
public class TestngRunnerFile extends AbstractTestNGCucumberTests{

	//For parallel Execuition
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();	
	}
}