package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
		WebDriver driver;
		public OffersPage(WebDriver driver)
		{
			this.driver=driver;
		}

		By Search=By.xpath("//input[@type='search']");
		By productName=By.cssSelector("tr td:nth-child(1)");
		
		public void search(String name)
		{
			driver.findElement(Search).sendKeys(name);
		}
		
		public String getProductName()
		{
			return driver.findElement(productName).getText();
		}	
	

}
