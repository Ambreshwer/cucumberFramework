package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	WebDriver driver;
	LandingPage landingPage;
	OffersPage offerPage;
	CheckoutPage checkoutPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}

	public OffersPage offersPage()
	{
		offerPage =new OffersPage(driver);
		return offerPage;
	}

	public LandingPage getLandingPage() {
		landingPage=new LandingPage(driver);
		return landingPage;
	}
	
	public  CheckoutPage getCheckoutPage() {
		checkoutPage=new CheckoutPage(driver);
		return checkoutPage;
	}
}
