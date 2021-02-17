package com.qa.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ExtentReportNG {

	public static ExtentReports setupExtentReport() 
	{
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter("./Reports/Extent.html");
		sparkreporter.config().setDocumentTitle("Document Title");
		sparkreporter.config().setReportName("Cross Browser Testing Report");
		sparkreporter.config().setTheme(Theme.DARK);

		ExtentReports extentreport = new ExtentReports();
		extentreport.attachReporter(sparkreporter);
	
		extentreport.setSystemInfo("Executed on OS", System.getProperty("os.name"));
		extentreport.setSystemInfo("Executed by User", System.getProperty("user.dir"));

		return extentreport;

	}
}
