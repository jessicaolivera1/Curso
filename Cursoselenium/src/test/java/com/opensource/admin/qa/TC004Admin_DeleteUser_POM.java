package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.admin.UserManagementPage;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;
import com.opensource.login.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC004Admin_DeleteUser_POM {
	WebDriver driver ;
	SeleniumWrapper seleniumWrapper;
	LoginPage login;
	UserManagementPage um;
	String username, password;	
	String noResult;
	String [] infoData  = new String [3];
	

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
		
		this.infoData[0]= seleniumWrapper.getJSONValue(GlobalVariables.TC003_NAME, "employeeName");
		this.infoData[1]= seleniumWrapper.getJSONValue(GlobalVariables.TC003_NAME, "newUser")+ um.getRandomSubfix();
		this.infoData[2]= seleniumWrapper.getJSONValue(GlobalVariables.TC003_NAME, "passwordNewUser");
		this.noResult=seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "noResult");

	}
	@Test
	public void TC004Admin_DeleteUser_POM_Script() {

		//Step 1
		login.setup(GlobalVariables.QA_URL);

		//Step  2
		login.loginOrange(username, password);

		//Step 3
		um.validateLoginSuccessfully();

		// Step 4
		um.clickAdmin();

		//Step 5 ,6,7  create user and search user
		um.searchUser(um.createNewUser(infoData), true);
		um.validateData(this.infoData[1], 1, 2);
		
		// Step 8
		
		um.selectUser(1, 1);
		
		// Step 9
		
		um.deleteUser();
		
		// Step 10
		
		um.validatePopwindow();
		
		//Step 11
		um.confirmdelete();
		
		// Step 12
		
		 um.searchUser(this.infoData[1], true);
		
		um.validateData(noResult, 1, 1);
		
		// Step 13
		
		 login.logoutOrange();
	}


	@AfterTest
	public void afterTest() {
		
		//Step 14
		
		login.closeBrowser();
	}

}
