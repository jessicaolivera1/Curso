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

		//Step 5
		um.searchUser(um.createNewUser(infoData), true);
		
		
		// Step 7
		
		um.selectUser(1, 1);
		
		um.deleteUser();
		
		
		um.confirmdelte();
		
		um.validateData(this.infoData[1], 1, 2);
	}


	@AfterTest
	public void afterTest() {
		
		login.closeBrowser();
	}

}
