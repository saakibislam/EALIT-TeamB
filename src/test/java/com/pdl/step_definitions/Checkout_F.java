package com.pdl.step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codoid.products.fillo.Select;
import com.pdl.pages.HomePage;
import com.pdl.pages.SignInPage;
import com.pdl.utilities.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout_F extends CommonMethods {
	
	WebElement searchField;

@Given("the product is added to the cart")
public void the_product_is_added_to_the_cart() {
    // Login for checkout
	waitFor(4);
	HomePage homepage = new HomePage();
	homepage.verifyLandingOnHomepage();
	WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a"));
	jsclick(driver, loginButton);
	logger.info("User Redirected to Login Page");
	waitFor(3);
	SignInPage loginOb = new SignInPage();
	loginOb.signIn("userId", "password");
	
	// Searching & Adding product to cart
	waitFor(2);
	searchField = driver.findElement(By.xpath("//*[@id=\"search\"]/input")); 
	drawborder(searchField);
	searchField.clear();
	searchField.sendKeys("phone");
	WebElement searchIcon =driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
	drawborder(searchIcon);
	 searchIcon.click();
	 
	 // Add to Cart
	 waitFor(3);
	 WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span"));
	 scrollToElement(addToCartButton);
	 drawborder(addToCartButton);
	 addToCartButton.click();
	 
	 waitFor(4);
		WebElement messageField= driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]"));
		String text=getElementText(messageField);
		softAssert.softAssertTrue(text.toLowerCase().contains("success"), text, "Product was not added to cart.");
}

@Given("user clicks on cart button")
public void user_clicks_on_cart_button() {
    // Write code here that turns the phrase above into concrete actions
  
   driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
   
    
}

@Then("user clicks on checkout link")
public void user_clicks_on_checkout_link() {
    // Write code here that turns the phrase above into concrete actions
	waitFor(5);
    driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]")).click();
}

@Then("user click on Estimate Shipping & Taxes dropdown button")
public void user_click_on_estimate_shipping_taxes_dropdown_button() {
    // Write code here that turns the phrase above into concrete actions
    waitFor(5);
    driver.findElement(By.xpath("//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")).click();
    
}

@Then("user fills up shipphing form")
public void user_fills_up_shipphing_form() {
    // Write code here that turns the phrase above into concrete actions
	WebElement countryfield=driver.findElement(By.xpath("//*[@id=\"input-country\"]"));
	selectFromDropDownbyVisibleText(countryfield, "United States");
	
	WebElement regionstate=driver.findElement(By.xpath("//*[@id=\"input-zone\"]"));
	selectFromDropDownbyVisibleText(regionstate, "Kansas");
	
	driver.findElement(By.xpath("//*[@id=\"input-postcode\"]")).sendKeys("66061");
}

@Then("user click on get quote button")
public void user_click_on_get_quote_button() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.xpath("//*[@id=\"button-quote\"]")).click();
}

@Then("user select Flat Shipping Rate and click on Apply Shipping")
public void user_select_flat_shipping_rate_and_click_on_apply_shipping() {
    // Write code here that turns the phrase above into concrete actions
	waitFor(5);
	driver.findElement(By.xpath("//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")).click();
	waitFor(2);
	driver.findElement(By.xpath("//*[@id=\"button-shipping\"]")).click();
    }
@Then("user click on checkout button")
public void user_click_on_checkout_button() {
    // Write code here that turns the phrase above into concrete actions

}

}
