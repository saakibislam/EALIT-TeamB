package com.pdl.step_definitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pdl.pages.HomePage;
import com.pdl.pages.SignInPage;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;

import io.cucumber.java.en.And;

public class QAfoxLoginWithBackground extends CommonMethods{
	public static Logger logger = LogManager.getLogger(QAfoxLoginWithBackground.class);
	
	@Given("User is in homepage")
	public void user_is_in_homepage() {
		HomePage homepage = new HomePage();
		homepage.verifyLandingOnHomepage();
	}

	@And("User navigates to loginpage")
	public void user_navigates_to_loginpage() {
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		jsclick(driver, loginButton);
		logger.info("User Redirected to Login Page");
	}

	@Then("User types credentials")
	public void user_types_credentials() {
		SignInPage loginPage = new SignInPage();
		loginPage.verifyLoginPage();
		logger.info("User types credentials");
		loginPage.signIn();
	}

	@And("Verify user redirected to my account page")
	public void verify_user_redirected_to_my_account_page() {
		waitFor(5);
		String currentPageTitle = driver.getTitle();
		String ExpectedAccountPageTitle = ConfigurationReader.getProperty("AccountPageTitle");
		softAssert.softAssertTrue(currentPageTitle.contains(ExpectedAccountPageTitle), "User Landed My Account Page Successfully", "My Account Page Verification Failed");
	}
	
//	Reset Password Step Definitions 
	
	@Then("User clicks on forgot password")
	public void User_clicks_on_forgot_password() {
		WebElement forgotPassLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a"));
		click_BD(forgotPassLink);
		logger.info("User clicked on forgot password");
		
	}
	
	@And("User types email")
	public void User_types_email() {
		logger.info("User typing email for reset link");
		WebElement emailField = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		emailField.clear();
		emailField.sendKeys(ConfigurationReader.getProperty("userId"));
	}

	@Then("User clicks continue")
	public void User_clicks_continue() {
		logger.info("User clicked on continue button");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
	}
	
	@And("Verify link sent confirmation")
	public void Verify_link_sent_confirmation() {
		waitFor(5);
		String text = getElementText(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")));
		softAssert.softAssertTrue(text.toLowerCase().contains("has been sent your email address."), text, text);
	}
}
