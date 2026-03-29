package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utilities.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_FIELD_LOCATOR = By.id("company");
	private static final By ADDRESS_LINE1_LOCATOR = By.id("address1");
	private static final By ADDRESS_LINE2_LOCATOR = By.id("address2");
	private static final By CITY_NAME_LOCATOR = By.id("city");
	private static final By POSTCODE_FIELD_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFORMATION_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By SAVE_BUTTON_LOCATOR = By.xpath("//button[@name='submitAddress']");
	private static final By ADDRESS_HEADING = By.tagName("h3");

	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");

	public AddressPage(WebDriver driver) {
		super(driver);

	}

	public static String saveAddress(AddressPOJO addressPOJO) {
		enterText(COMPANY_FIELD_LOCATOR, addressPOJO.getCompany());
		enterText(ADDRESS_LINE1_LOCATOR, addressPOJO.getAddressLine1());
		enterText(ADDRESS_LINE2_LOCATOR, addressPOJO.getAddressLine2());
		enterText(CITY_NAME_LOCATOR, addressPOJO.getCity());
		enterText(POSTCODE_FIELD_LOCATOR, addressPOJO.getPostCode());
		enterText(HOME_PHONE_LOCATOR, addressPOJO.getHomePhoneNumber());
		enterText(MOBILE_PHONE_LOCATOR, addressPOJO.getMobilePhoneNumber());
		enterText(ADDITIONAL_INFORMATION_LOCATOR, addressPOJO.getAdditionalInfo());

		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);

		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, addressPOJO.getAddressAlias());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR, "California");
		clickOn(SAVE_BUTTON_LOCATOR);
		String addressHeading = getVisibleText(ADDRESS_HEADING);

		return addressHeading;

	}

}
