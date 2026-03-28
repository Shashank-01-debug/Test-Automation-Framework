package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({ com.ui.listeners.TestListener.class })
public class SearchProductTest extends TestBase {

	@BeforeMethod
	public void setup() {
		homePage.goToLoginPage().doLoginWith("bexiwak388@devlug.com", "password");
	}

	@Test(description = "verify if the logged in user is able to search for product and correct products search result are displayed", groups = {
			"e2e", "smoke", "sanity" })
	public void verifyProductSearchTest() {

		MyAccountPage.searchForAProduct("Printed Summer dress").getALLDressesName();

	}

}
