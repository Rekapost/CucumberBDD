package testRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;  //***************  junit
import io.cucumber.testng.CucumberOptions;   //***************  testng

//@RunWith(Cucumber.class)    //***************  junit
//@CucumberOptions(           //***************  junit
     @CucumberOptions(            //***************  testng
		plugin= {"pretty","html:target/reka.html"},
		features="src/test/resources/features",
		glue =  {"stepDefinitions", "hooks"},
		dryRun=false,
		//dryRun=true, //to check every steps in feature file have corresponding step definition method or not
		//plugin= {"pretty","html:test-output"},
		monochrome=true,   // console output colour
		//tags="@tag1 or @tag2"    // to run two scenarios 
		//tags= "@RegressionTest or @SmokeTest"
		
		//tags="@tag1"
		tags= "@sanity"
		//tags= "@regression"
		//tags= "@regression and not @sanity"  //include and exclude
		//tags= "@sanity or @regression"   //******************
		
		//tags= "~@tag1"   //to skip test case ~
		//tags= "@regression and not @sanity"  //{"@sanity,@regression"} OR
		//tags= {"@sanity","~@regression"}  //include and exclude , execute and skip   //{"@sanity","@regression"} AND   
		)
//public class TestRunner {
//
//}

public class TestRunner extends  AbstractTestNGCucumberTests{   //Runs each cucumber scenario found in the features as separated test.
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
	return  super.scenarios();    //Runs each cucumber scenario found in the features as separated test.
}
}