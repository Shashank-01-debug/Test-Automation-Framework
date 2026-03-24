package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	 private static final By EMAIL_TEXTBOX_LOCATOR = By.id("email");
	 private static final By PASSWORD_TEXTBOX_LOCATOR= By.id("passwd");
	 private static final By SUBMIT_BTN_LOCATOR = By.xpath("//button[@type='submit' and @name='SubmitLogin']/span");
	

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String email, String password) {
		
		enterText(EMAIL_TEXTBOX_LOCATOR,email);
		enterText(PASSWORD_TEXTBOX_LOCATOR,password);
		clickOn(SUBMIT_BTN_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
		
		
	}

}
