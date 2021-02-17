package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qa.Utils.ExtentTestMethod;

public class LoginFeatureTest 
{
  @Test
  public void verifyUserIsOnTheHomePage()
  {
	  ExtentTest test=ExtentTestMethod.getInstance().getExtent();
	  test.info("Verify user is on the homepage");
	  test.info("Extracting title of the page");
	  test.info("Validating is it the expected title");
	  Assert.assertEquals(false, true);
  }
  
  @Test
  public void verifyUserAbleToLoginIn()
  {
	  ExtentTest test=ExtentTestMethod.getInstance().getExtent();
	  test.info("Entering User Name");
	  test.info("Entering Password");
	  test.info("Clicked on the Submit button");
	  test.info("Validating User got access of the application");
	  Assert.assertEquals(false, false);
  
  }
  
	/*
	 * @Test public void testCase3() {
	 * 
	 * }
	 */
}
