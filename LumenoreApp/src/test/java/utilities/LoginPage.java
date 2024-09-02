package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Setup;





public class LoginPage{ 

	
	WebDriver driver;
	 
	//Constructor that will be automatically called as soon as the object of the class is created
	public LoginPage(WebDriver driver) {
          this.driver = driver;
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
//	String str = loc.getProperty("usernameId");
//	@FindBy (id=str)WebElement userna;
	
	@FindBy (id="login-form_email")WebElement username;
	@FindBy(id="login-form_password")WebElement password;
	@FindBy(xpath="//span[contains(text(),'Login')]/parent::button")WebElement loginBtn;
	@FindBy(xpath="//span[contains(text(),'Lumenore App Creator')]")WebElement LumenoreLandingPageHeading;
	@FindBy (xpath="//span[contains(text(),'Try it now!')]/parent::button")WebElement TryItNowBtn;
	
	
	//this method is used to sign in for user
	 public void signIn(String strUserName,String strPasword) throws InterruptedException{
			System.out.println("signIn page open");	
			wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
			username.sendKeys(strUserName);
			password.sendKeys(strPasword);
			loginBtn.click();
			wait.until(ExpectedConditions.visibilityOf(LumenoreLandingPageHeading));
			wait.until(ExpectedConditions.elementToBeClickable(TryItNowBtn));
			System.out.println("Login Successafull, signIn page close");	
		 }
}
