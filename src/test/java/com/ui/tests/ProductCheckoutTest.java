package com.ui.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.MyAccountPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {
	
	private  static final String SEARCH_TERM= "Printed summer dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description="user logs into the application and searches for product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("bexiwak388@devlug.com", "password").searchForAProduct(SEARCH_TERM);
		
	}
	
	@Test(description="verify if the logged in user is able to buy a dress")
	public void checkoutTest() {
		
		searchResultPage.clickOnTheProductAt(0).changeSize(M).addProductToCart().proceedToCheckout().clickOnPage_1_Locator().clickOnAddressPageLocator()
		.clickOn_CheckBox().clickOnProceedToCheckOut();
		
		
	}

}
