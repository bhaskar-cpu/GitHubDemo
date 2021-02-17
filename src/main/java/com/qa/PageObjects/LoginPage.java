package com.qa.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.Utils.CommonUtilities;

public class LoginPage {
	WebDriver driver;
	
	public By btn_SignIn = By.className("login");
	public By txt_emailaddress = By.id("email");
	public By txt_password = By.id("passwd");
	public By btn_Submit = By.id("SubmitLogin");

	CommonUtilities utilites;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		utilites = new CommonUtilities();
	}

	public String getPageTitle() {
		utilites.verifyElementIsPrsent(driver, btn_SignIn);
		return driver.getTitle();
	}

	public void setEmailAddress(String text) {
		driver.findElement(txt_emailaddress).sendKeys(text);
	}

	public void setPassword(String text) {
		driver.findElement(txt_password).sendKeys(text);
	}

	public MyAccountPage clickSubmit() {
		driver.findElement(btn_Submit).sendKeys(Keys.ENTER);
		return new MyAccountPage(driver);
	}

}
