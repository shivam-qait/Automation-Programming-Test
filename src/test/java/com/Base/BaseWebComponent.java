package com.Base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class BaseWebComponent extends TestInitiator{
	
	String filePath, selectorType;
	ArrayList<String> rows = new ArrayList<String>();
	int timeout;
	
	public BaseWebComponent(String pageName) {
		filePath = "src" + File.separator + "test" + File.separator + "resources" + File.separator + 
				"pageObjects" + File.separator + pageName + ".txt";
	}

	
	public static void waitTillTime(int wTime) {
		try {
			Thread.sleep(wTime);
		} catch (Exception ex) {
		}
	}
	
	public WebElement waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
    	return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void readfile() throws IOException {
		File file = new File(filePath);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String readline;
		while ((readline = br.readLine()) != null) {
			rows.add(readline);
		}
		br.close();
	}

	public String findLocatorPath(String locatorName) {
		for (int i = 0; i < rows.size(); i++) {
			if (rows.get(i).contains(locatorName)) {
				String[] ar = rows.get(i).split("\\s+", 3);
				selectorType = ar[1];
				String path = ar[2];
				return path;
			}
		}
		return null;
	}

	public WebElement element(String locatorName){
		try {
			readfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = findLocatorPath(locatorName);
		return driver.findElement(getLocators(selectorType, path));
	}
	
	public WebElement element(String locatorName, String replacement) {
		try {
			readfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String locator = findLocatorPath(locatorName);
		locator = locator.replaceAll("\\$\\{.+?\\}", replacement);
		return driver.findElement(getLocators(selectorType, locator));
	}
	
	public WebElement element(String locatorName, String replacement1, String replacement2) {
		try {
			readfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String locator = findLocatorPath(locatorName);
		locator = locator.replaceFirst("\\$\\{.+?\\}", replacement1);
		locator = locator.replaceFirst("\\$\\{.+?\\}", replacement2);
		return driver.findElement(getLocators(selectorType, locator));
	}
	
	By getLocators(String locatorType, String locatorValue) {
		switch (locatorType) {
		case "id":
			return By.id(locatorValue);
		case "xpath":
			return By.xpath(locatorValue);
		case "name":
			return By.name(locatorValue);
		case "classname":
			return By.className(locatorValue);
		case "css":
			return By.cssSelector(locatorValue);
		case "linktext":
			return By.linkText(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}

	public void logMessage(String message) {
		Reporter.log(message, true);
	}

	public void click(WebElement element) {
		waitForElementToBeVisible(element);
		element.click();
	}
	
	public String getText(WebElement element) {
		waitForElementToBeVisible(element);
		return element.getText();
	}
	
	public void enterText(WebElement element, String value) {
		waitForElementToBeVisible(element);
		element.clear();
		element.sendKeys(value);
		logMessage("Entered value:- "+value);
	}

}