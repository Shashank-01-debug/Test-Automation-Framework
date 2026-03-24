package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utilities.BrowserUtility;

public class LoginTest2 {
//https://automationpractice.techwithjatin.com/;=
	public static void main(String[] args) {

		
		HomePage homePage = new HomePage(Browser.CHROME);
		homePage.maximizeWindow();
		LoginPage loginPage = homePage.goToLoginPage();
		loginPage.doLoginWith("bexiwak388@devlug.com", "password");
		
		

	}

}
