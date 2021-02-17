package com.qa.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IClassListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersImplementation implements ITestListener,IClassListener
{

	public static ExtentReports extentReport;
	public ExtentTest testName;
	public ExtentTest className;
	public ExtentTest testMethod;

	
	  @Override 
	  public void onBeforeClass(ITestClass testClass) { 
	  ExtentClass.getInstance().setExtent(ExtentFactory.getInstance().getExtent().createNode(testClass.getName()));
	  }
	  
	  @Override 
	  public void onAfterClass(ITestClass testClass) 
	  { 
		  ExtentClass.getInstance().removeExtentObject();
	  }
	 

	
	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ExtentTestMethod.getInstance().setExtent(ExtentClass.getInstance().getExtent().createNode(result.getMethod().getMethodName()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTestMethod.getInstance().getExtent().log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+" is Passed");
		ExtentTestMethod.getInstance().removeExtentObject();
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		ExtentTestMethod.getInstance().getExtent().log(Status.FAIL,"Test Case: "+result.getMethod().getMethodName()+" is Failed");
		ExtentTestMethod.getInstance().getExtent().log(Status.FAIL,result.getThrowable().toString());
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		Date date=new Date();
		String reportName=format.format(date).replaceAll("-","").replaceAll(":","").replaceAll(" ","");
		File src=((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"/Reports/ScreenShots/"+reportName+".jpeg");
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestMethod.getInstance().getExtent().addScreenCaptureFromPath(dest.getAbsolutePath(),"Test Case Failed Screenshot");
		ExtentTestMethod.getInstance().removeExtentObject();
	}

	@Override
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
		extentReport=ExtentReportNG.setupExtentReport();
		ExtentFactory.getInstance().setExtent(extentReport.createTest(context.getName()));
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		// TODO Auto-generated method stub
		extentReport.flush();

	}

	

}
