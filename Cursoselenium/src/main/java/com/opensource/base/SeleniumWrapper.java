package com.opensource.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Selenium Wrapper class- Base class
 * @author jessica
 *
 */

public class SeleniumWrapper {

	// objeto 

	private WebDriver driver;

	/**
	 * constructor SeleniumWrapper
	 * @author jessica
	 * @param driver
	 */

	public SeleniumWrapper (WebDriver driver) {

		this.driver=driver;


	}

	/**
	 * Chrome driver connection
	 * @author VI1XXVQ 
	 */

	public WebDriver chromeDriverConnection() {
		//System.setProperty(GlobalVariables.CHROME_DRIVER_NAME,GlobalVariables.CHROME_DRIVER_PATH );
		System.setProperty(GlobalVariables.CHROME_DRIVER_NAME,GlobalVariables.CHROME_DRIVER_PATH_LINUX );
		driver = new ChromeDriver();
		return  driver;

	}

	/**
	 * Reporter Log 
	 * @author VI1XXVQ
	 */

	public void reportLog(String log ) {
		Reporter.log(log);

	}


	/**
	 * @author VI1XXVQ
	 * implicitlyWait
	 */

	public void  implicitlyWait (int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	/**
	 * Launch Browser
	 * @author VI1XXVQ 
	 */
	public void LaunchBrowser(String url) {
		try {

			reportLog("Launching... "+ url +" application");
			driver.get(url);
			driver.manage().window().maximize();
			implicitlyWait(5);


		}catch (Exception e) {
			e.printStackTrace();

		}


	}
	/**
	 * find element
	 * @param locator
	 * @return
	 */
	public WebElement findElemnt (By locator) {
		return driver.findElement(locator);
	}

	/**
	 * type text
	 * @author VI1XXVQ
	 */
	public void type (String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	/**
	 * click object 
	 * @param locator
	 */

	public void click (By locator) {
		driver.findElement(locator).click();
	}

	/**
	 * Wait for Element Present 
	 * @author VI1XXVQ
	 */

	public void waitForElement (By locator ) {
		try {
			WebDriverWait wait =new WebDriverWait (driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch (TimeoutException e){
			e.printStackTrace();

		}

	}

	/**
	 * Get Text
	 * @author VI1XXVQ
	 * 
	 */

	public String getText (By locator) {
		try {

			return driver.findElement(locator).getText();


		}catch (NoSuchElementException e) {
			return null;
		}
	}




	/**
	 * Hard Assertion
	 * @author VI1XXVQ
	 * @param
	 */

	public void assertEquals (String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e){

			Assert.fail ("Not able assert actual value < "+actualValue+"> with  expected value <"+expectedValue);

		}
	}

	/**
	 * Close Browser
	 * @author VI1XXVQ
	 */
	public void closeBrowser() {
		try {

			reportLog ("Closing Browser");
			driver.close();

		}catch (NoSuchSessionException e) {
			Assert.fail("No able to close Browser");
		}
	}


	/*
	 * Get Value from Excel
	 * @author Ricardo Avalos
	 * @date 02/18/2019
	 */
	public String getCellData(String excelName, int row, int column) {
		try {
			// Reading Data
			FileInputStream fis = new FileInputStream(GlobalVariables.PATH_EXCEL_DATA+excelName+".xlsx");
			// Constructs an XSSFWorkbook object
			@SuppressWarnings("resource")
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	/**
	 * Get Data from JSON file (1 Node)
	 *
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonObjName, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFile, String jsonObjName, String jsonKey)  {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFile + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonObjName).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}


	/**
	 * Get Data from JSON file (Directly)
	 *
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}



}

