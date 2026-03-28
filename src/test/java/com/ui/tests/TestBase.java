package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utilities.BrowserUtility;
import com.utilities.LambdaTestUtility;
import com.utilities.LoggerUtility;

public class TestBase {
	// parent of all the testclasses

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	boolean isLambdaTest ;
	
	
    @Parameters({"browser","isLambdaTest","isHeadLess"})
	@BeforeMethod(description = "load home page of website")
	public void setup(
			@Optional ("chrome")String browser,
			@Optional ("false")boolean isLambdaTest, 
			@Optional ("false")boolean isHeadless,ITestResult result) {
		this.isLambdaTest=isLambdaTest;
		WebDriver lambdaDriver;
		

		if (isLambdaTest) {

			lambdaDriver = LambdaTestUtility.initialiseLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		}

		else {
			// running test on local machine
			logger.info("Load the HomePage of website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);

		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}
	
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
			
		}
	}
	
	
}
