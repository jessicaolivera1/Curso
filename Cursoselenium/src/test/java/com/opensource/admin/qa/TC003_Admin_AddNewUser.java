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

public class TC003_Admin_AddNewUser {
  @Test
  
  @BeforeTest
  public void beforeTest() {
  }
  
  
 
  @Test
	  
	  public void TC003_Admin_AddNewUser_Script() {
	  
	  		String employee="Aaliyah Haq";
	  		String username= "Admin";
	  		String Password= "admin123";
	  		
	  		String mainPwd="Admin123";
	  		int random=(int)(Math.random()*100);
	  		String newUser= "Mario"+random;
		  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/v91chromedriver.exe");
		  WebDriver driver = new ChromeDriver();

		  // Step 1-Open Browser "OrangeHRM" web page
		  
		  Reporter.log("Open Browser \"OrangeHRM\" web page");
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		  //Step 2 Enter Username and Password
		  
		  Reporter.log("Enter Username and Password");
		  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		  driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
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
	  
	  // Step 5 Click Add
		  Reporter.log(" Click Add");  
		  driver.findElement(By.xpath("//input [@id='btnAdd']")).click();
		  
	// Steo 6 Enter valid Employee Name
		  
		  Reporter.log(" Enter valid Employee Name");  
		  driver.findElement(By.xpath("//input [@id='systemUser_employeeName_empName']")).sendKeys(employee);
		  
// Steo  7 Enter valid username
		  
		  Reporter.log(" Enter valid username");  
		  driver.findElement(By.xpath("//input [@id='systemUser_userName']")).sendKeys(newUser);
		   
		//Step  8 Enter new password and confirm
		  
		  Reporter.log(" Enter new password and confirm");  
		  driver.findElement(By.xpath("//input [@id='systemUser_password']")).sendKeys(mainPwd);  
		  driver.findElement(By.xpath("//input [@id='systemUser_confirmPassword']")).sendKeys(mainPwd);  
		
//Step  9 Click Save
		  
		  Reporter.log(" Click Save");  
		  driver.findElement(By.xpath("//input [@id='btnSave']")).click();
		   
		  // Step 10 Search username in field "Username"
		  Reporter.log("Search username in field \"Username");
		  driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys(newUser);
		  
		  
		  // Step 11 Click Search
		  Reporter.log ("Click Searche");
		  driver.findElement(By.xpath("//input[@id= 'searchBtn']")).click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  
		  
		  // Step 12 Verify username exist in table
		  Reporter.log ("Verify username exist in table");
		  String getusername=driver.findElement(By.xpath("//tbody/tr[1]/td [2]")).getText ();
		  Assert.assertEquals(getusername, newUser);
		  
		  // Step 13 - log out 
		  
		  Reporter.log ("log out ");
		  driver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
		  driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  // Step 14 - Close Browser
		  Reporter.log ("Close Browser "); 
		  driver.close();
		    
		  
		  
  }

  @AfterTest
  public void afterTest() {
  }

}
