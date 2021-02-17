package com.qa.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.qa.Utils.BrowserFactory;
import com.qa.Utils.DriverFactory;


public class BaseTest 
{
    BrowserFactory factory=new BrowserFactory();
    WebDriver driver;
     
	@BeforeClass
	@Parameters({"Browser"})
	public void lauchApplication(String browser)
	{
		driver=factory.createBrowserInstance(browser);
		DriverFactory.getInstance().setDriver(driver);
		driver=DriverFactory.getInstance().getDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	} 
	
	@AfterClass
	public void closeDriverInstance()
	{
	    DriverFactory.getInstance().closeBrowser();
	}
	
}
