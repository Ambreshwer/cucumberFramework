package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@After
	public void afterScenario() throws IOException
	{
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver=testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			TakesScreenshot ts =(TakesScreenshot)driver;
			File sourcepath=ts.getScreenshotAs(OutputType.FILE);
			byte[] fileContent=FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
	
	/*
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports"+ testCaseName +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports"+ testCaseName +".png";
	}
	 */

}


