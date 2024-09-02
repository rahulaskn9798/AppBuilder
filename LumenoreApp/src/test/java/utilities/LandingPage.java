package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LandingPage {

	WebDriver driver;
	 
	//Constructor that will be automatically called as soon as the object of the class is created
	public LandingPage(WebDriver driver) {
          this.driver = driver;
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	
	@FindBy (xpath="//span[contains(text(),'Try it now!')]/parent::button")WebElement TryItNowBtn;
	@FindBy (xpath="//p[contains(text(),'Explore different ways to build your App.')]")WebElement LumenoreAppBuilderHeading;
	
	
	
	//simple method to validate Landing Page UI 
	public void Test() throws InterruptedException {
		System.out.println("this is simple method to validate Landing Page UI");
		Assert.assertTrue(LumenoreAppBuilderHeading.isDisplayed(), "LumenoreAppBuilderHeading title is not visible");
		TryItNowBtn.click();
		Thread.sleep(2000);
	}
}
