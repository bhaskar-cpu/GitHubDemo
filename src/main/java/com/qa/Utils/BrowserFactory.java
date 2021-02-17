package com.qa.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory 
{
	WebDriver driver=null;
    public WebDriver createBrowserInstance(String browser)
    {
    	if(browser.equalsIgnoreCase("Chrome"))
    	{
    		ChromeOptions options=new ChromeOptions();
    		options.addArguments("--incognito");
    		WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver(options);
    		
    	}
    	else if(browser.equalsIgnoreCase("Firefox"))
    	{
    		FirefoxOptions options=new FirefoxOptions();
    		options.addArguments("-private");
    		WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver(options);
    	}
    	else
    	{
    		System.out.println("Provide the valid browser name.Such browser don't exist");
    	}
		return driver;
    }
}
