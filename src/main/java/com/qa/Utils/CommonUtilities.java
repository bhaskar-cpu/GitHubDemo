package com.qa.Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities 
{
   WebDriverWait wait;
	
   public WebElement verifyElementIsPrsent(WebDriver driver,By locator)
   {
	   wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	   return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }
   
}
