package com.qa.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.CommonUtilities;

public class MyAccountPage {
	private WebDriver driver;
	public By link_UName = By.xpath("//a[@class='account']/span");
	public By link_SignOut = By.xpath("//a[@class='logout']");

	WebElement btn_SignOut;

	CommonUtilities utilites;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		utilites = new CommonUtilities();
	}

	public String getAccountPageTitle() {
		btn_SignOut = utilites.verifyElementIsPrsent(driver, link_SignOut);
		return driver.getTitle();
	}

	public String getSignedInUName() {
		return driver.findElement(link_UName).getText();
	}

	public void performSignOut() {
		driver.findElement(link_SignOut).click();
	}
}
