package com.qa.Utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory 
{
   private DriverFactory()
   {
	   
   }
   
   public static DriverFactory instance=null;
   
   public static DriverFactory getInstance()
   {
	  if(instance==null)
		  instance=new DriverFactory();
	  return instance;
   }
   
   public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
   
   public void setDriver(WebDriver driverParam)
   {
	   driver.set(driverParam);
   }
   
   public WebDriver getDriver()
   {
	   return driver.get();
   }
   
   public void closeBrowser()
   {
	   driver.get().quit();
	   driver.remove();
   }
}
