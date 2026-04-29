package com.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoLoginPage extends BasePage {

    public DemoLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login2")
    WebElement loginBtn;

    @FindBy(id = "loginusername")
    WebElement username;

    @FindBy(id = "loginpassword")
    WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginSubmit;

    @FindBy(id = "nameofuser")
	public WebElement welcomeText;

    public void login(String user, String pass) {
    	loginBtn.click();

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(username));

    	username.sendKeys(user);
    	password.sendKeys(pass);
        loginSubmit.click();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }
}