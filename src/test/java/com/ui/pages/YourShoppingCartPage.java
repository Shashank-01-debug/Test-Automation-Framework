package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public class YourShoppingCartPage extends BrowserUtility {

	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By
			.xpath("//a[@title='Proceed to checkout']/span[text()='Proceed to checkout']");
	private static final By PROCEED_TO_CHECKOUT_PAGE_3_BUTTON_LOCATOR = By.xpath("//button[@name='processAddress']");

	public YourShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public YourShoppingCartPage clickOnPage_1_Locator() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new YourShoppingCartPage(getDriver());
	}

	public YourShippingPage clickOnAddressPageLocator() {
		clickOn(PROCEED_TO_CHECKOUT_PAGE_3_BUTTON_LOCATOR);
		return new YourShippingPage(getDriver());
	}

}
