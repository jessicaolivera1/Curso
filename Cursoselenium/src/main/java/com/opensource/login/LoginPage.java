package com.opensource.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.SeleniumWrapper;

public class LoginPage  extends SeleniumWrapper{
	//CONSTRUCTOR 
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	//OBJETOS 

	By txtUsername =By.xpath("//input[@id='txtUsername']");
	By txtPassword =By.xpath("//input[@id='txtPassword']");
	By btnLogin = By.xpath("//input[@id='btnLogin']");
	By btnWelcome= By.xpath("//a[@id=\"welcome\"]");
	By btnLogout= By.xpath("//a[contains(text(),'Logout')]");




	// METODOS DE SOLO ESTA PANTALLA
	/**
	 * Set up envirooment 
	 * @author VI1XXVQ
	 */

	public void setup(String url) {
		LaunchBrowser(url);

	}


	/**
	 * Login Orange App
	 * @author VI1XXVQ
	 */

	public void loginOrange  (String username, String password) {

		reportLog("Login OrangeHRM web page ....");
		type(username,txtUsername);
		type (password,txtPassword);
		click (btnLogin);
		implicitlyWait(5);
	}

	/**
	 * Logout orange
	 * @author VI1XXVQ
	 */

	public void logoutOrange () {

		reportLog("Logout OrangeHRM web page...");
		click(btnWelcome);
		click(btnLogout);
		implicitlyWait(5);



	}


}
