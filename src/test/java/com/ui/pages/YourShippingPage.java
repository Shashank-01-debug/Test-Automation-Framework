package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public class YourShippingPage extends BrowserUtility {
	
	private static final By CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECK_OUT_SHIPPING_PAGE_BUTTON_LOCATOR = By.xpath("//button[@name='processCarrier']");
	
	
	
	

	public YourShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public  YourShippingPage clickOn_CheckBox() {
		clickOn(CHECKBOX_LOCATOR);
		return new YourShippingPage(getDriver());
	}
	
	public PaymentPage clickOnProceedToCheckOut() {
		clickOn(PROCEED_TO_CHECK_OUT_SHIPPING_PAGE_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}

}
