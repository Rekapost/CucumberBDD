package testRunner;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	
		plugin= {"pretty","html:target/reka.html"},
		features="src/test/resources/features",
		glue={"stepDefinitions","hooks"},
		dryRun=false,
		//plugin= {"pretty","html:test-output"},
		monochrome=true,   // console output colour
		//tags="@login or @regression")
		tags="@regression")

public class TestRunnerDDT extends  AbstractTestNGCucumberTests{

	//@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
	return  super.scenarios();
	}
	}
