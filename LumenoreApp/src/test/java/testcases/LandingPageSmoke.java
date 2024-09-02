package testcases;

import org.testng.annotations.Test;

import base.Setup;

public class LandingPageSmoke extends Setup {

	@Test(priority=0, enabled=true)
	public void landingPageSmoke() throws InterruptedException
	{
		System.out.println("Open Landing Page");
		landingPage.Test();
	}
	
}
