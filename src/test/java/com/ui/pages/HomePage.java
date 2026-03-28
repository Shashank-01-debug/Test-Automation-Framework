package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utilities.BrowserUtility;
import com.utilities.JSONUtility;

import static com.utilities.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	
	//follow page Object design pattern
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");
	
	public HomePage(Browser browser, boolean isHeadless) {
				super(browser,isHeadless);
		goToWebsite(JSONUtility.readJson(QA).getUrl());	
	}
	
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}



	public LoginPage goToLoginPage() {
		//page Functions
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	
	
	
	
	
	

}
