package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.admin.UserManagementPage;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;
import com.opensource.login.LoginPage;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC003Admin_AddNewUser_POM {
	
	WebDriver driver ;
	SeleniumWrapper seleniumWrapper;
	LoginPage login;
	UserManagementPage um;
	String username, password;
	String [] infoData  = new String [3];
	String newuser;

	@BeforeTest
	public void beforeTest() {

		seleniumWrapper= new SeleniumWrapper(driver);
		driver=seleniumWrapper.chromeDriverConnection();
		login=new LoginPage(driver);
		um=new UserManagementPage(driver);


		int random=(int)(Math.random()*100);


		//SETUP DATA 
		//JSON
		this.username= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "username");
		this.password= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "password");
		this.infoData[0]= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "employeeName");
		this.infoData[1]= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "newUser")+ random;
		this.infoData[2]= seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "passwordNewUser");
		
		newuser=this.infoData[1];
	}
	
	public String getNewUser() {
		return newuser;
	}


	@Test
	public void TC003Admin_AddNewUser_POM_Script() {
		
		//Step 1
		  
		  login.setup(GlobalVariables.QA_URL);
		  
		  //Step  2
		  
		  login.loginOrange(username, password);
		  
		 //Step 3
		  
		  um.validateLoginSuccessfully();
		  
		 // Step 4
		  
		  um.clickAdmin();
		  
		 // Step 5
		  
		  um.clickAdd();
		  
		  // Step 6,7,8
		  
		  um.addNewUserData(infoData);
		  
		  //Step 9
		  
		  um.clickSave();
		  
		  //Step 10.11
		  
		  um.searchUser(this.infoData[1], true);
		  
		  //Step 12
		  
		  um.validateData(this.infoData[1], 1, 2);
		  
		  
		  
		  
	}
	 @AfterTest
	  public void afterTest() {
		  
		  //Step 13
		  
	  login.closeBrowser();
		  



}
}
