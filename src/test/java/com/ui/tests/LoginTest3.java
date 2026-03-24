package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utilities.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTest3 extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "verifies with the valid credentials user able to login into the application", groups = {
			"sanity",
			"e2e" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shashank Bundela");

	}
	/*

	@Test(description = "verifies with the valid credentials user able to login into the application", groups = {
			"sanity",
			"e2e" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shashank Bundela");

	}

	
	@Test(description = "verifies with the valid credentials user able to login into the application", groups = {
			"sanity",
			"e2e" }, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shashank Bundela");

	}
	*/

}
