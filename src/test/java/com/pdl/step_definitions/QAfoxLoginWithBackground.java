package com.pdl.step_definitions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.pdl.pages.HomePage;
import com.pdl.pages.MyAccountPage;
import com.pdl.pages.SignInPage;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import io.cucumber.java.en.And;

public class QAfoxLoginWithBackground extends CommonMethods{
	public static Logger logger = LogManager.getLogger(QAfoxLoginWithBackground.class);
	
	//Common steps for all scenarios
	
	
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

	// Single step for successful login
	
	/*
	 * @Then("User types credentials") public void user_types_credentials() {
	 * SignInPage loginPage = new SignInPage(); loginPage.verifyLoginPage();
	 * logger.info("User types credentials"); loginPage.signIn(); }
	 */

	@And("Verify user redirected to my account page")
	public void verify_user_redirected_to_my_account_page() {
		waitFor(3);
		MyAccountPage accountPage = new MyAccountPage();
		accountPage.verifyLandingOnMyAccountPage();
		accountPage.verifyListOfOptions();
		accountPage.userLogOut();
	}
	
//	Reset Password Step Definitions 
	
	@Then("User clicks on forgot password")
	public void user_clicks_on_forgot_password() {
		WebElement forgotPassLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a"));
		click_BD(forgotPassLink);
		logger.info("User clicked on forgot password");
		
	}
	
	@And("User types email")
	public void user_types_email() {
		logger.info("User typing email for reset link");
		WebElement emailField = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
		emailField.clear();
		emailField.sendKeys(ConfigurationReader.getProperty("userId"));
	}

	@Then("User clicks continue")
	public void user_clicks_continue() {
		logger.info("User clicked on continue button");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
	}
	
	@And("Verify link sent confirmation")
	public void verify_link_sent_confirmation() {
		waitFor(5);
		String text = getElementText(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")));
		softAssert.softAssertTrue(text.toLowerCase().contains("has been sent your email address."), text, text);
	}
	
	// Common steps for successful & unsuccessful login
	
	@Then("User types credentials {string} and {string}")
	public void user_types_credentials_and(String email, String password) {
		System.out.println(email);
		System.out.println(password);
		SignInPage invalidLogin = new SignInPage();
		invalidLogin.signIn(email, password);;
	}
	
	@And("User sees error message")
	public void user_sees_error_message() {
		waitFor(3);
		String message = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText().toLowerCase();
		try {
			softAssert.softAssertTrue(message.contains("Warning:".toLowerCase()), message, message);
			
		} catch (Exception e) {
			// TODO: handle exception
			softAssert.handleAssertionFailure(message);
			e.printStackTrace();
		}
		
	}
}
