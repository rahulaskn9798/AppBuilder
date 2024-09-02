package base;

import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.LandingPage;
import utilities.LoginPage;



public class Setup {

	public static WebDriver driver ;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr, fr1;
	public String url;
	public String userName;
	public String passWord;
	public LoginPage loginPage ;
	public LandingPage landingPage;
	public static String env;
    
    @BeforeTest
    @Parameters({"environment"})
	public void setUp(@Optional("environment") String environment ) throws IOException, InterruptedException{
	    System.out.println("Setup Open");
	    
		ChromeOptions options = new ChromeOptions();
	 	options.addArguments("--headless=new");
	 	
	 	SafariOptions options_S = new SafariOptions();
	 	
	 	
	    if(driver==null) {
		fr = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
	   fr1 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/locators.properties");
		prop.load(fr);
	    loc.load(fr1);
	                      }
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);	
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("safari")){
			 WebDriverManager.safaridriver().setup();
			 driver = new SafariDriver(options_S);
		}
		
	
		
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		landingPage = PageFactory.initElements(driver, LandingPage.class);
		
		 env=environment;
		// from here we are giving environment to run the test cases
		setEnvironment(env);
		System.out.println("The function is to validate SignIn");
		driver.get(url);
        loginPage.signIn(userName, passWord);
        System.out.println("validateSignIn function completed");
     	System.out.println("Setup closed");

		
		
	}
@AfterTest	
     public void tearDown() {
	      driver.close();
	      System.out.println("Tear down Successfull");
               
} 
		
public void setEnvironment(String env) {
	if (env.equalsIgnoreCase("beta")) {
		url = prop.getProperty("urlBeta");
		userName = prop.getProperty("userBeta");
		passWord = prop.getProperty("passwordBeta");	
	}
	else if(env.equalsIgnoreCase("alpha")) {
		url = prop.getProperty("urlAlpha");
		userName = prop.getProperty("userAlpha");
		passWord = prop.getProperty("passwordAlpha");	
		
	}
	else if(env.equalsIgnoreCase("qa")) {
		url = prop.getProperty("urlQa");
		userName = prop.getProperty("userQa");
		passWord = prop.getProperty("passwordQa");	
		
	}
	else if(env.equalsIgnoreCase("trng")) {
		url = prop.getProperty("urlTrng");
		userName = prop.getProperty("userTrng");
		passWord = prop.getProperty("passwordTrng");	
	}
}

}
