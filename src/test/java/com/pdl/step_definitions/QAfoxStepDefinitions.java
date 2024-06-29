package com.pdl.step_definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pdl.utilities.Driver;

public class QAfoxStepDefinitions {
	public static WebDriver driver = Driver.getDriver();
	
//	@FindBy(xpath = "//*[@id='top-links']/ul/li[2]/ul/li[2]/a ") public WebElement LoginButton;
//	@FindBy(name = "email")public WebElement emailField;
//	@FindBy(name = "password")public WebElement passwordField;
	
	@Given("User is in homepage")
	public void user_is_in_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user is in homepage");
	}

	@Then("user clicked on Login button")
	public void user_clicked_on_login_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement accountbutton =  driver.findElement(By.xpath("//a[@title='My Account']"));
		accountbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until((ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Login")))));
		driver.findElement(By.linkText("Login")).click();
		System.out.println("user clicks login button");
		Thread.sleep(3000);
	}

	@When("user redirected to login page")
	public void user_redirected_to_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user redirected to login page");
	}

	@Then("user typed credentials")
	public void user_typed_credentials() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.clear();
		emailField.sendKeys("pbotterell0@hexun.com");
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.clear();
		passwordField.sendKeys("iW9?c,A%'Ow8p+!");
		System.out.println("user typed credentials");
		Thread.sleep(5000);
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		System.out.println("user clicked login button");
	}

	@Then("verify user redirected to my account page")
	public void verify_user_redirected_to_my_account_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("verify user is in account page");
	}

}
