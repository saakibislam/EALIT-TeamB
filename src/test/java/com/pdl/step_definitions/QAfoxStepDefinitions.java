package com.pdl.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.pdl.pages.HomePage;
import com.pdl.pages.SignInPage;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.Driver;

public class QAfoxStepDefinitions extends CommonMethods {
	public static WebDriver driver = Driver.getDriver();

//	@FindBy(xpath = "//*[@id='top-links']/ul/li[2]/ul/li[2]/a ") public WebElement loginButton;
//	@FindBy(name = "email")public WebElement emailField;
//	@FindBy(name = "password")public WebElement passwordField;
	
	public static Logger logger = LogManager.getLogger(QAfoxStepDefinitions.class);

	@Given("User is in homepage")
	public void user_is_in_homepage() {
		HomePage homepage = new HomePage();
		homepage.verifyLandingOnHomepage();
	}

	@Then("user clicked on Login button")
	public void user_clicked_on_login_button() {
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
		jsclick(driver, loginButton);
		
//		WebElement accountbutton = driver.findElement(By.xpath("//a[@title='My Account']"));
//		accountbutton.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Login")))));
//		flash(loginButton, driver);
//		click_BD(loginButton);
		
		logger.info("Navbar Login Button Clicked");
	}

	@When("user redirected to login page")
	public void user_redirected_to_login_page() {
		logger.info("User Redirected to Login Page");
	}

	@Then("user types credentials")
	public void user_types_credentials() {

		SignInPage loginPage = new SignInPage();
		loginPage.verifyLoginPage();
		loginPage.signIn();
	}

	@Then("verify user redirected to my account page")
	public void verify_user_redirected_to_my_account_page() {
		waitFor(5);
		String currentPageTitle = driver.getTitle();
		String ExpectedAccountPageTitle = ConfigurationReader.getProperty("AccountPageTitle");
		softAssert.softAssertTrue(currentPageTitle.contains(ExpectedAccountPageTitle), "User Landed My Account Page Successfully", "My Account Page Verification Failed");
	}

}
