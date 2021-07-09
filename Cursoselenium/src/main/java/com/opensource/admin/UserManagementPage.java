package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.SeleniumWrapper;

public class UserManagementPage extends SeleniumWrapper {

	String newuser;
	// constructor 
	public UserManagementPage(WebDriver driver) {
		super(driver);
	}

	// objetos
	By linkUM =By.xpath("//a[@id='menu_admin_viewAdminModule']");
	By txtusername =By.xpath("//input[@id='searchSystemUser_userName']");
	By txtSearchUser= By.xpath("//input[@id='searchSystemUser_userName']");
	By btnSearch=By.xpath("//input[@id= 'searchBtn']");
	By tblUsername=By.xpath("//tbody/tr[1]/td [2]");
	By tblUsernameNoRecords=By.xpath("//tbody/tr[1]/td [1]");
	By btnAdd=By.xpath("//input [@id='btnAdd']");
	By hdrAddUser= By.xpath("//h1 [@id='UserHeading']");
	By txtEmployeeName=By.xpath("//input [@id='systemUser_employeeName_empName']");
	By txtUserName=By.xpath("//input [@id='systemUser_userName']");
	By txtPasswordNewUser =By.xpath("//input [@id='systemUser_password']");
	By txtConfirmPassword=By.xpath("//input [@id='systemUser_confirmPassword']");
	By btnSave=By.xpath("//input [@id='btnSave']");


	// metodos
	/**
	 * validate login success
	 * @author VI1XXVQ
	 */
	public void validateLoginSuccessfully () {
		reportLog("Validate that you have logged in successfully");
		waitForElement(linkUM);	
	}

	/**
	 * click admin
	 * @author VI1XXVQ
	 */
	public void  clickAdmin () {
		reportLog("Click Admin - Go to the admin page");
		click(linkUM);
		waitForElement(txtusername);
	}

	/**
	 * Click Add
	 * @author VI1XXVQ
	 */
	public void clickAdd () {
		reportLog ("Click Add");
		click(btnAdd);
		waitForElement(hdrAddUser);
	}

	/**
	 * addNewUserData
	 * @author VI1XXVQ
	 * 
	 */
	public void addNewUserData (String infoData[]) {
		type(infoData[0], txtEmployeeName);
		type(infoData[1], txtUserName);	
		type(infoData[2], txtPasswordNewUser);
		type(infoData[2], txtConfirmPassword);
		newuser=infoData[1];
	}

	/**
	 * clickSave
	 * @author VI1XXVQ
	 */
	public void clickSave(){
		reportLog (" Click Save");
		click(btnSave);
		implicitlyWait(2);
	}

	/**
	 * Search username 
	 * @author VI1XXVQ
	 */
	public void searchUser(String username,boolean clickSearch) {
		reportLog (" Search username in field \"Username\"");
		type(username,txtSearchUser);
		if(clickSearch) {
			click(btnSearch);
		}
	}

	/**
	 * validate user exist in table 
	 * @author VI1XXVQ
	 */
	public void validateUserTable (String expectedUser) {
		reportLog ("Verify username exist in table");
		String actualUser=getText(tblUsername);
		assertEquals(actualUser,expectedUser);
	}

	/**
	 * validater user no exist in table
	 * @author VI1XXVQ
	 */
	public void validateNotExist (String expectedValue) {
		reportLog ("Verify username is not exist in table");	
		String valueFound=getText(tblUsernameNoRecords);
		assertEquals(valueFound,expectedValue);
	}

	/**
	 * validate if data exist in 
	 * @author VI1XXVQ
	 */
	public void validateData (String expectedValue, int fila, int col) {
		By tblForValue=By.xpath("//tbody/tr["+fila+"]/td ["+col+"]");
		reportLog ("Verify username is not exist in table");	
		String valueFound=getText(tblForValue);
		assertEquals(valueFound,expectedValue);
	}

	/**
	 * validate if data exist in 
	 * @author VI1XXVQ
	 */
	public int getRandomSubfix() {
		return (int)(Math.random()*100);
	}
	
	public String createNewUser(String infoData[]) {
		reportLog ("Click Add");
		click(btnAdd);
		waitForElement(hdrAddUser);
		
		type(infoData[0], txtEmployeeName);
		type(infoData[1], txtUserName);	
		type(infoData[2], txtPasswordNewUser);
		type(infoData[2], txtConfirmPassword);
		
		reportLog (" Click Save");
		click(btnSave);
		implicitlyWait(2);
		
		return infoData[1];
	}

}




