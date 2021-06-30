package com.opensource.admin.qa;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TC004_Admin_DeleteUser {

	WebDriver driver ;
	@BeforeTest
	public void beforeTest() {
	}



	@Test

	public void TC004_Admin_DeleteUser_Script() {


		String username= "Admin";
		String Password= "admin123";
		String newuser="Mario1";
		String notFound="No Records Found";


		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/v91chromedriver.exe");
		driver = new ChromeDriver();

		// Step 1-Open Browser "OrangeHRM" web page

		Reporter.log("Open Browser \"OrangeHRM\" web page");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Step 2 Enter Username and Password

		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Step 3 Validate that you have logged in successfully

		Reporter.log("Step 3 Validate that you have logged in successfully");
		WebDriverWait wait =new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='menu_admin_viewAdminModule']")));


		// Step -4 Click Admin - Go to the admin page
		Reporter.log("Click Admin - Go to the admin page");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='searchSystemUser_userName']")));

		//Step 5 Search username in field "Username"
		Reporter.log("Search username in field \"Usernamee");  
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(newuser);


		// Step 6 Click Search
		Reporter.log ("Click Searche");
		driver.findElement(By.xpath("//input[@id= 'searchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 7 Verify username exist in table
		Reporter.log ("Verify username exist in table");
		String getusername=driver.findElement(By.xpath("//tbody/tr[1]/td [2]")).getText ();
		Assert.assertEquals(getusername, newuser);


		//Step 8 Select User
		Reporter.log ("Select User");  
		driver.findElement(By.xpath("//tbody/tr[1]/td [1]")).click();

		//Step 9 Click Delete
		Reporter.log ("Click Delete");  
		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();

		//Step 10 Validate pop-window is displayed: "Delete Records?"
		Reporter.log("Validate pop-window is displayed: \"Delete Records?\"");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='deleteConfModal']")));

		//Step 11 Click Ok to confirm delete user
		Reporter.log ("Click Ok to confirm delete user");  
		driver.findElement(By.xpath("//input [@id='dialogDeleteBtn']")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='deleteConfModal']")));

		//Step 12 Validate in table that user was delete successfully
		Reporter.log ("Validate in table that user was delete successfully");


		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(newuser);

		driver.findElement(By.xpath("//input[@id= 'searchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String getusernamedelete=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText ();
		Assert.assertEquals(getusernamedelete, notFound);
		// Step 13- log out 

		Reporter.log ("log out ");
		driver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


	}

	@AfterTest
	public void afterTest() {

		// Step 14 - Close Browser
		Reporter.log ("Close Browser "); 
		driver.close();
	}

}
