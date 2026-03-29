package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static WebDriverWait wait;
	// here, driver is an instance variable
	// variables which are created inside the class with private access modifier are
	// instance variable.
	// instance variable is stored in heap memory

	public static WebDriver getDriver() {

		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		// initialize the instance variable driver using constructor
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

		else if (browserName.equalsIgnoreCase("edge")) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			System.err.println("Invalid browser Name !!!");
		}
	}

	public BrowserUtility(Browser browserName) {

		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}

		else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");// launch browser in headless mode
				options.addArguments("--window-size=1920,1080");

				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		}

		else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");// launch browser in headless mode
				options.addArguments("disable-gpu");
				options.addArguments("--window-size=1920,1080");

				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}

		else if (browserName == Browser.FIREFOX) {

			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}
	}

	public void goToWebsite(String url) {

		driver.get().get(url);

	}

	public void maximizeWindow() {

		driver.get().manage().window().maximize();
	}

	public static void quitSession() {

		driver.get().quit();
	}

	public static void clickOn(By locator) {

	//	WebElement element = driver.get().findElement(locator);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	element.click();
	}

	public static void clickOn(WebElement element) {
		element.click();
	}

	public static void enterText(By locator, String textToEnter) {
	//	WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);
	}

	public static void enterSpecialKey(By locator, Keys keyToEnter) {
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);
	}

	public static void selectFromDropDown(By dropDownLocator, String optionToSelect) {

		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);

	}

	public static void clearText(By textBoxLocator) {

		//WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		element.clear();
	}

	public static String getVisibleText(By locator) {

		WebElement element = driver.get().findElement(locator);
		return element.getText();

	}

	public String getAllVisibleText(By locator) {

		List<WebElement> elementList = driver.get().findElements(locator);

		for (WebElement element : elementList) {
			System.out.println(element.getText());
		}
		return "";

	}

	public static List<WebElement> getAllElements(By locator) {

		List<WebElement> elementList = driver.get().findElements(locator);

		return elementList;

	}

	public String getVisibleText(WebElement element) {

		return element.getText();

	}

	public String takeScreenShot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

}
