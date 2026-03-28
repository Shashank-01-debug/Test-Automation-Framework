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
public class InvalidCredsLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS ="superman@gmail.com";
	private static final String INVALID_PASSWORD ="querty@123";

	@Test(description = "verifies if proper error message is shown for user when they enter invalid credentials", groups = {
			"sanity",
			"e2e" })
	public void loginTest() {
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMesg(),"Authentication failed.");

	}
	
	
	

}
