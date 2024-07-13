package com.pdl.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.util.Assert;
import com.pdl.utilities.BrowserUtil;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.Driver;
import com.pdl.utilities.SftAssert;

	

	public class SignInPage extends CommonMethods {
		
		public static Logger logger = LogManager.getLogger(SignInPage.class);
		
		public SignInPage() {
			PageFactory.initElements(Driver.getDriver(), this);
		}
		
		@FindBy(id="input-email") public WebElement emailField;	
		@FindBy(id="input-password") public WebElement passwordField;
		@FindBy(xpath = "//input[@value='Login']") public WebElement signInTab;
		

		
		
		public void signIn(String emailProperty, String passwordProperty) {
			drawborder(emailField);
			logger.info("User Typing Email");
			emailField.clear();
			emailField.sendKeys(ConfigurationReader.getProperty(emailProperty));
			drawborder(passwordField);
			logger.info("User Typing Password");
			passwordField.clear();
			passwordField.sendKeys(ConfigurationReader.getProperty(passwordProperty));
			logger.info("Credentials Typing Complete");  		
			click_BD(signInTab);
			logger.info("User Clicked for Login");
		}
		
		public void verifyLoginPage() {
			String expectedTitle = ConfigurationReader.getProperty("LoginPageTitle");
			String currentTitle = driver.getTitle();
			
//			Assertion hardAssert = new Assertion();
//			hardAssert.assertEquals(currentTitle, expectedTitle, "Login Page Verified.");
			logger.info("Verifying Login Page");
			softAssert.softAssertTrue(currentTitle.contains(expectedTitle), "Login Page Verified", "Login Page Doesn't Match");
		}
}
