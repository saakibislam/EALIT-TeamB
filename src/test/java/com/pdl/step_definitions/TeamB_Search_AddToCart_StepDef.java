package com.pdl.step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pdl.utilities.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TeamB_Search_AddToCart_StepDef extends CommonMethods {
	
	WebElement searchField;
	
	public void typingProduct(String productName) {
		searchField.clear();
		searchField.sendKeys(productName);
	}
	
	@Given("User is logged in")
	public void user_is_logged_in() {
	waitFor(30);   
	}

	@Given("User Clicks on Search bar")
	public void user_clicks_on_search_bar() {
		searchField = driver.findElement(By.xpath("//*[@id=\"search\"]/input")); 
		searchField.clear();
	}

	@When("User types product on search bar")
	public void user_types_product_on_search_bar() {
		searchField.sendKeys("phone");
		waitFor(3);
	}

	@When("User click search button")
	public void user_click_search_button() {
	 WebElement searchIcon =driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
	 searchIcon.click();
	}

	@Then("User clicks on add to cart")
	public void user_clicks_on_add_to_cart() {
	 waitFor(5);
	 WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span"));
	 addToCartButton.click();
	 
	}

	@Then("Successfull message verification")
	public void Successfull_message_verification() {
		waitFor(10);
		WebElement messageField= driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]"));
		String text=getElementText(messageField);
		softAssert.softAssertTrue(text.toLowerCase().contains("success"), text, "Product was not added to cart.");
	  
	}
	

}
