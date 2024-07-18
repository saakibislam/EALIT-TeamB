package com.pdl.step_definitions;


import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.pdl.utilities.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TeamB_Search_AddToCart_StepDef extends CommonMethods {
	
WebElement searchField;
	
	

	@Given("User is logged in")
	public void user_is_logged_in() {
		waitFor(30);     
	}

	@And("User Clicks on Search bar")
	public void user_clicks_on_search_bar() {
		searchField = driver.findElement(By.xpath("//*[@id=\"search\"]/input")); 
		searchField.clear();

	}
	@When("User types product on search bar")
	public void user_types_product_on_search_bar() {
		searchField.sendKeys("phone");
		waitFor(3);
	}

   public void searchingProduct(String productName) {
	   searchField=driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
	   searchField.clear();
	   searchField.sendKeys(productName);
	   
	   
   }
	@When("the user searches for {string}")
	public void the_user_searches_for(String productName) {
		searchingProduct(productName);
		
	}

	@And("User click search button")
	public void user_click_search_button() {
		WebElement searchIcon =driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
		 searchIcon.click();
		 
	}

	@And("User click on add to cart")
	public void the_user_adds_product_to_the_cart() {
		 waitFor(5);
		 WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span"));
		 addToCartButton.click();

	}

	@And("the Total number of results are {int}")
	public void the_total_number_of_results_are(Integer int1) {
	   System.out.println(int1);
	}

	@Then("Successfully message verification")
	public void Successfull_message_verification() {
		waitFor(10);
		WebElement messageField= driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]"));
		String text=getElementText(messageField);
		softAssert.softAssertTrue(text.toLowerCase().contains("success"), text, "Product was not added to cart.");
	  
	}


	@Then("the user should see a success message {string}")
	public void the_user_should_see_a_success_message(String string, io.cucumber.datatable.DataTable dataTable) {
		waitFor(10);
		WebElement messageField= driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]"));
		String text=getElementText(messageField);
		softAssert.softAssertTrue(text.toLowerCase().contains("success"), text, "Product was not added to cart.");
	  
	}




}


	


