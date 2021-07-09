package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.admin.UserManagementPage;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;
import com.opensource.login.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC002_AdminSearchEmployee_NotExist_POM {

	WebDriver driver ;
	SeleniumWrapper seleniumWrapper;
	LoginPage login;
	UserManagementPage um;
	String username, password,usernamenoexist,noResult ;

	@BeforeTest
	public void beforeTest() {
		
		  
	seleniumWrapper= new SeleniumWrapper(driver);
	driver=seleniumWrapper.chromeDriverConnection();
	login=new LoginPage(driver);
	um=new UserManagementPage(driver);

		//SETUP DATA 
		//JSON
		this.username= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "username");
		this.password= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "password");
		this.usernamenoexist=seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "usernamenoexist");
		this.noResult=seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "noResult");
		//EXCEL

	//this.username= seleniumWrapper.getCellData(this.getClass().getSimpleName(),1,0);
	//this.password= seleniumWrapper.getCellData(this.getClass().getSimpleName(),1,1);
	}

	@Test
	public void fTC002_AdminSearchEmployee_NotExist_POM_Script() {
		
		 //Step 1
		  
		  login.setup(GlobalVariables.QA_URL);
		  
		  //Step  2
		  
		  login.loginOrange(username, password);
		  
		 //Step 3
		  
		  um.validateLoginSuccessfully();
		  
		 // Step 4
		  
		  um.clickAdmin();
		  
		  //Step 5 & 6
		  
		  um.searchUser(usernamenoexist, true);
		  
		  //Step 7 
		  //um.validateNotExist(noResult);
		 um.validateData(noResult,1,1);
		  
		  //Step 8 
		  
		  login.logoutOrange();
	}


	@AfterTest
	public void afterTest() {
		
		  //Step 9
		  
		  login.closeBrowser();
	}

}
