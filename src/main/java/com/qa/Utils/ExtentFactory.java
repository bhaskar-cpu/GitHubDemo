package com.qa.Utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory 
{
	private ExtentFactory() {

	}

	private static ExtentFactory instance;

	public static ExtentFactory getInstance() {
		if(instance==null)
		{
			instance= new ExtentFactory();
		}
		return instance;
	}
	
	public static ThreadLocal<ExtentTest> testName =new ThreadLocal<ExtentTest>();
	
	public void setExtent(ExtentTest extentTestObj)
	{
		testName.set(extentTestObj);
	}
	
	public ExtentTest getExtent()
	{
		return testName.get();
	}
	
	public void removeExtentObject()
	{
		testName.remove();
	}
	
}
