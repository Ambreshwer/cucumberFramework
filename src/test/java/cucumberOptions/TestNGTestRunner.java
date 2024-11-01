package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepDefinations",
monochrome=true,tags="@offersPage or @PlaceOrder",
plugin={"html:target/cucumber.html","json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
//ca ec ae

			//TT							//ATCT
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
