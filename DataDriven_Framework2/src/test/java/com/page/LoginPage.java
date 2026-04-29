package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="username")
	public WebElement userName;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	public WebElement login;
	
	@FindBy(xpath="//h5[text()='Login']")
	public WebElement title;
	
	
	public String getLoginTitle() {
		return title.getText();
	}

	public void login(String strUsername, String strPassword) {
		userName.sendKeys(strUsername);
		password.sendKeys(strPassword);
		login.click();
	}
	
	

}
