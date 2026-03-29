package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.constants.Browser;
import com.utilities.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private final static By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private final static By LIST_OF_PRODUCT_ITEMS = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver webDriver) {
		super(webDriver);

	}

	public String getSearchResultTitle() {

		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);

	}
	
	public void getALLDressesName() {
		
		getAllVisibleText(LIST_OF_PRODUCT_ITEMS);
		
	}
	
	public  static ProductDetailPage clickOnTheProductAt(int index) {
		
		WebElement firstProduct = getAllElements(LIST_OF_PRODUCT_ITEMS).get(index);
		clickOn(firstProduct);
		
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
		
		
	}

	
}
