package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.qa.PageObjects.LoginPage;
import com.qa.PageObjects.MyAccountPage;
import com.qa.Utils.ExtentTestMethod;

public class LoginTest extends BaseTest
{
	LoginPage loginpage;
	MyAccountPage account;
	
	@Test(priority=0)
	public void verifyLoginPageTitleTest()
	{
		loginpage=new LoginPage(driver);
		ExtentTest test=ExtentTestMethod.getInstance().getExtent(); 
		test.info("Getting Page Title");
		String loginPageTitle=loginpage.getPageTitle();
		test.info("Page title is "+loginPageTitle);
		Assert.assertTrue(loginPageTitle.equals("Login - My Store"), "Page Title doesn't match. Expected 'Login - My Store' Actual : "+loginPageTitle);
	}
	
	@Test(priority=1)
    public void validateLoginIntoTheApplication()
    {
		ExtentTest test=ExtentTestMethod.getInstance().getExtent(); 
    	test.info("Enter Email Id");
    	loginpage.setEmailAddress("seleniumpractice@gmail.com");
    	test.info("Enter Password");
    	loginpage.setPassword("Selenium@12345");
    	test.info("Click on Submit Button");
    	account=loginpage.clickSubmit();
    	test.info("Getting Account Page Title");
    	String accountPageTitle=account.getAccountPageTitle();
    	test.info("Account Page Title is "+accountPageTitle);
		Assert.assertTrue(accountPageTitle.equals("My account - My Store"), "Page Title doesn't match. Expected 'My account - My Stor' Actual : "+accountPageTitle);
    }
}
