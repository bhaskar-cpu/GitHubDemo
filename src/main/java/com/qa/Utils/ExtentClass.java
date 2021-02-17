package com.qa.Utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentClass 
{
	private ExtentClass() {

	}

	private static ExtentClass instance;

	public static ExtentClass getInstance() {
		if(instance==null)
		{
			instance= new ExtentClass();
		}
		return instance;
	}
	
	public static ThreadLocal<ExtentTest> className =new ThreadLocal<ExtentTest>();
	
	public void setExtent(ExtentTest extentTestObj)
	{
		className.set(extentTestObj);
	}
	
	public ExtentTest getExtent()
	{
		return className.get();
	}
	
	public void removeExtentObject()
	{
		className.remove();
	}
	
}
