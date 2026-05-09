package com.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.pages.LoginPageLocators;
import com.utilities.HelperClass;

public class LoginPageAction {
	LoginPageLocators loginPageLocators=null;
	String strUserName, strPassword;
	public LoginPageAction() {
		this.loginPageLocators=new LoginPageLocators();
		PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
	}
	
	public void setUserName(String strUserName) {
		loginPageLocators.userName.sendKeys(strUserName);
	}
	
	public void setPassword(String strPassword) {
		loginPageLocators.password.sendKeys(strPassword);
	}
	
	public void clickLogin() {
		loginPageLocators.login.click();
	}
	public void login() {
	
		File file = new File(System.getProperty("user.dir")
		        + "/src/test/resources/Report/loginData.properties");
	FileInputStream fileInput=null;
	
	try {
		fileInput = new FileInputStream(file);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	
	Properties prop= new Properties();
	
	try {
		prop.load(fileInput);
	}
	catch(IOException e1) {
		e1.printStackTrace();
	}
	
	strUserName = prop.getProperty("username");
	strPassword=prop.getProperty("password");
	
	this.setUserName(strUserName);
	
	this.setPassword(strPassword);
	
	this.clickLogin();
	}

}
