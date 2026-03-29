package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utilities.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{
	
	
	private  MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	@BeforeMethod(description="valid  First time user logs into the application")
	public void setup() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("bexiwak388@devlug.com", "password");
		address = FakeAddressUtility.getFakeAddress();
	}
	
	
	@Test(description="verify if new address is added")
	public void addNewAddressTest() {
		
		String addressHeading = myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(addressHeading,address.getAddressAlias().toUpperCase());
			
	}
	
	
	//@AfterMethod
	public void flush() {
		myAccountPage.quit();
		}
	
	
}

