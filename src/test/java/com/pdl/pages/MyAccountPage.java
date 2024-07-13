package com.pdl.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.Driver;

public class MyAccountPage extends CommonMethods {
	
	public Logger logger = LogManager.getLogger(MyAccountPage.class);
	
	@FindBy(id="content") WebElement contentDiv;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a") WebElement logoutButton;
	
	public MyAccountPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	List<String> expectedOptions = new ArrayList<String>(Arrays.asList(
			"Edit your account information",
			"Change your password",
			"Modify your address book entries",
			"Modify your wish list",
			"View your order history",
			"Downloads",
			"Your Reward Points",
			"View your return requests",
			"Your Transactions",
			"Recurring payments",
			"Register for an affiliate account",
			"Subscribe / unsubscribe to newsletter"
			));
	
	public void verifyLandingOnMyAccountPage() {
		String currentPageTitle = driver.getTitle();
		String ExpectedAccountPageTitle = ConfigurationReader.getProperty("AccountPageTitle");
		softAssert.softAssertTrue(currentPageTitle.contains(ExpectedAccountPageTitle), "User Landed My Account Page Successfully", "My Account Page Verification Failed");
	}
	
	public void verifyListOfOptions() {
//		WebElement contentDiv = driver.findElement(By.id("content"));
//		List<WebElement> links = contentDiv.findElements(By.tagName("a"));
		logger.info("Checking for list of options...");
		List<WebElement> links = contentDiv.findElements(By.tagName("a"));
		List<String>actualOptions = getElementsTextByPassingElementList(links);
		try {
			softAssert.softAssertTrue(listCompare(expectedOptions, actualOptions),actualOptions.size()+" options were verified on My Account page" ,"Couldn't verify links in my account page" );
		}catch(Exception e) {
			e.printStackTrace();
			softAssert.handleAssertionFailure("My Account page options assertion failed");
		}
	}
	
	public void userLogOut() {
		jsclick(driver, logoutButton);
	}
}
