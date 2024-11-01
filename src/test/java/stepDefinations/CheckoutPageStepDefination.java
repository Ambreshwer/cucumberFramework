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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestBase;
import utils.TestContextSetup;

public class CheckoutPageStepDefination {

	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;

		public CheckoutPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
	}
	
	@Then("^user proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_Checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException
	{
		checkoutPage.checkOutItems();
		Thread.sleep(2000);
	}

}
	
	

	
	
