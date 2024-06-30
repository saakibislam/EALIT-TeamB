package com.pdl.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.pdl.utilities.BrowserUtil;
import com.pdl.utilities.CommonMethods;
import com.pdl.utilities.ConfigurationReader;
import com.pdl.utilities.Driver;
import com.pdl.utilities.SftAssert;

public class HomePage extends CommonMethods{

	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	public static Logger logger = LogManager.getLogger(HomePage.class);
	
	@FindBy(xpath = "//*[@id=\"logo\"]/h1/a") public WebElement homepageLogo;

	public void verifyLandingOnHomepage() {
		waitFor(6);
		
		String expectedUrl = ConfigurationReader.getProperty("expectedURL");
		String expectedTitle=ConfigurationReader.getProperty("HomePageTitle");
		String currentTitle = driver.getTitle();
		String currentURL = driver.getCurrentUrl();

		logger.info("Expected Title from properties file is = " + expectedUrl);
        
		try {
			
		waitForUrlContains(expectedUrl);
		
		} catch (Exception e) {
			logger.info("current URL is :" + driver.getCurrentUrl());
			logger.info("URL doesn't Containt: " + expectedUrl);
		}
				
		
		if (!currentURL.contains(expectedUrl)) {
			
			driver.navigate().refresh();
			
			logger.info("browser refreshed again");

			waitForUrlContains(expectedUrl);
			currentURL = driver.getCurrentUrl();
			currentTitle=driver.getTitle();
		}
		
//		waitForElement(homepageLogo);
		
		logger.info(" Current Page Title: " + currentTitle);
		
		softAssert.softAssertTrue(currentURL.contains(expectedUrl), "User Landed on Homepage Successfully", "User Failed to land on Homepage");
//		logger.info("Homepage Assertion Complete");
//		softAssert.(currentURL.contains(ExpectedURL),"User Landed in Homepage -");
//		softAssert.assertEquals(currentURL, ExpectedURL, "User is landed in homepage");
		
	    
	}

}
