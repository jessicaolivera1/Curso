package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
	By txtUserNameAdd=By.xpath("//input [@id='systemUser_userName']");
	By dprStatus= By.xpath("//select [@id=\"systemUser_status\"]");
	By txtPasswordNewUser =By.xpath("//input [@id='systemUser_password']");
	By txtConfirmPassword=By.xpath("//input [@id='systemUser_confirmPassword']");
	By btnSave=By.xpath("//input [@id='btnSave']");
	By btnDelete=By.xpath("//input[@id='btnDelete']");
	By btnConfirmDelete=By.xpath("//input [@id='dialogDeleteBtn']");
	


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
		type(infoData[1], txtUserNameAdd);	
		type(infoData[2], txtPasswordNewUser);
		type(infoData[2], txtConfirmPassword);
		newuser=infoData[1];
		implicitlyWait(2);
	}
	
	
	/**
	 * @author VI1XXVQ
	 * addNewUserDataDisabled
	 * @param infoData
	 */
	
	public void addNewUserDataDisabled (String infoData[]) {
		reportLog (" addNewUserDataDisabled ");
		type(infoData[0], txtEmployeeName);
		type(infoData[1], txtUserNameAdd);	
		changeStatus(dprStatus,infoData[2]);
		type(infoData[3], txtPasswordNewUser);
		type(infoData[3], txtConfirmPassword);
		newuser=infoData[1];
	}

	/**
	 * changeStatus
	 * @author VI1XXVQ
	 */
	public void changeStatus(By locator,String status) {
		changeDrop(locator,status);
		
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
		implicitlyWait(2);
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
	
	/**
	 * 
	 * createNewUser
	 * @author VI1XXVQ
	 * @param infoData
	 * @return
	 */
	
	public String createNewUser(String infoData[]) {
		reportLog ("Click Add");
		click(btnAdd);
		waitForElement(hdrAddUser);
		
		type(infoData[0], txtEmployeeName);
		type(infoData[1], txtUserNameAdd);	
		type(infoData[2], txtPasswordNewUser);
		type(infoData[2], txtConfirmPassword);
		
		reportLog (" Click Save");
		implicitlyWait(3);
		click(btnSave);
		implicitlyWait(2);
		
		return infoData[1];
	}
	
	public void selectUser (int fila, int col) {
		By tblForValue=By.xpath("//tbody/tr["+fila+"]/td ["+col+"]");
		reportLog ("selecUser");
		click(tblForValue);
		
	}
	
	public void deleteUser(){
		reportLog (" Delete User");
		click(btnDelete);
		implicitlyWait(2);
		
	}
	
	
	public void confirmdelte () {
		click(btnConfirmDelete);
		implicitlyWait(2);
	}
	


}




