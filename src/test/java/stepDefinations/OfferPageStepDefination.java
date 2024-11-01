package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

//Single responsibility principle
//Loosly coupled

public class OfferPageStepDefination {
	
	String offerPageProductName;
	TestContextSetup testContextSetup;
	
	
	public OfferPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.offersPage();
		offersPage.search(shortName);
		Thread.sleep(2000);
		offerPageProductName=offersPage.getProductName();
	}
	
	public void switchToOffersPage() 
	{
		//if already switched to offer page skip the below part
		//if(testContextSetup.driver.getCurrentUrl().equalignorecase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() 
	{
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}
}	
