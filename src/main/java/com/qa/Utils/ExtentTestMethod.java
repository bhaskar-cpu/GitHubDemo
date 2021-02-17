package com.qa.Utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestMethod 
{
	private ExtentTestMethod() {

	}

	private static ExtentTestMethod instance;

	public static ExtentTestMethod getInstance() {
		if(instance==null)
		{
			instance= new ExtentTestMethod();
		}
		return instance;
	}
	
	public static ThreadLocal<ExtentTest> testMethod =new ThreadLocal<ExtentTest>();
	
	public void setExtent(ExtentTest extentTestObj)
	{
		testMethod.set(extentTestObj);
	}
	
	public ExtentTest getExtent()
	{
		return testMethod.get();
	}
	
	public void removeExtentObject()
	{
		testMethod.remove();
	}
	
}
