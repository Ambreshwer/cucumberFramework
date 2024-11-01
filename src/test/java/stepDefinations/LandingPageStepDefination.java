package stepDefinations;

import java.io.IOException;
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
import utils.TestBase;
import utils.TestContextSetup;

public class LandingPageStepDefination {
	//WebDriver driver;
	//public String landingPageProductName;
	TestContextSetup testContextSetup;
	TestBase testBase;
	LandingPage landingPage;
	
	
	public LandingPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on Green kart Landing Page")
	public void user_is_on_green_kart_landing_page() throws IOException {
		
		Assert.assertTrue(landingPage.getTiltleLandingPage().contains("GreenKart"));
		
	}
	
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	    
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName+" is the extracted from homepage");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void Added_items_of_the_selected_product_to_cart(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}	
}
	
	

	
	
