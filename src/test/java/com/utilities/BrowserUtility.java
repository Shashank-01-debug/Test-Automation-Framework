package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	// here, driver is an instance variable
	// variables which are created inside the class with private access modifier are
	// instance variable.
	// instance variable is stored in heap memory
	
	
	public WebDriver getDriver() {
		
			return driver.get();
		}
	
	
	
	

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		// initialize the instance variable driver using constructor
	}
	
	public BrowserUtility(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		
		else if(browserName.equalsIgnoreCase("edge")){
			
			driver.set(new EdgeDriver());
			
		}
		else {
			System.err.println("Invalid browser Name !!!");
		}
	}
	
	
	public BrowserUtility(Browser browserName) {
		
		if(browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		
		else if(browserName==Browser.EDGE){
			
			driver.set(new EdgeDriver());
			
		}
		else if(browserName==Browser.FIREFOX) {
			
			driver.set(new FirefoxDriver());
		}
	}
	
public BrowserUtility(Browser browserName, boolean isHeadless) {
		
		if(browserName == Browser.CHROME) {
			if(isHeadless) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=old");//launch browser in headless mode
			options.addArguments("--window-size=1920,1080");
			
			driver.set(new ChromeDriver(options));
		}
			else {
				driver.set(new ChromeDriver());
			}
			
			}
				
		else if(browserName==Browser.EDGE){
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");//launch browser in headless mode
				options.addArguments("disable-gpu");
				options.addArguments("--window-size=1920,1080");
				
			
			driver.set(new EdgeDriver(options));
			}
			else {
				driver.set(new EdgeDriver());
			}
		}
		
		
		
		else if(browserName==Browser.FIREFOX) {
			
			
			
			driver.set(new FirefoxDriver());
		}
	}
	
	
		
	
	

	

	public void goToWebsite(String url) {

		driver.get().get(url);

	}

	public void maximizeWindow() {

		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		
		WebElement element = driver.get().findElement(locator);
		element.click();
		
	}
	
	public void enterText(By locator,String textToEnter) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		
		WebElement element = driver.get().findElement(locator);
		return element.getText();
		
	}
	
	public String takeScreenShot(String name) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
	File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
	String timeStamp = format.format(date);
	String path=System.getProperty("user.dir")+"//screenshots//"+name+" - "+timeStamp+".png";
	File screenshotFile = new File(path);
	try {
		FileUtils.copyFile(screenshotData, screenshotFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return path;
	
	}
	

}
