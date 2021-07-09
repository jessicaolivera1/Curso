package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.admin.UserManagementPage;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;
import com.opensource.login.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC004Admin_DeleteUser_POM extends TC003Admin_AddNewUser_POM {
	WebDriver driver ;
	SeleniumWrapper seleniumWrapper;
	LoginPage login;
	UserManagementPage um;
	String username, password;
	String newuser;
	

	@BeforeTest
	public void beforeTest() {

		seleniumWrapper= new SeleniumWrapper(driver);
		driver=seleniumWrapper.chromeDriverConnection();
		login=new LoginPage(driver);
		um=new UserManagementPage(driver);
		newuser= getNewUser();
		System.out.println("fffff"+ newuser);

		//SETUP DATA 
		//JSON
		this.username= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "username");
		this.password= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "password");



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

		um.searchUser(newuser, true);

	}


	@AfterTest
	public void afterTest() {
	}

}
