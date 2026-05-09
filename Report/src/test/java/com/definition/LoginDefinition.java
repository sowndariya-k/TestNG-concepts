package com.definition;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.actions.HomePageActions;
import com.actions.LoginPageAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDefinition {

	LoginPageAction objLogin = new LoginPageAction();
	HomePageActions objHomePage = new  HomePageActions();
	@Given("user is on HRMLogin Page {string}")
	public void user_is_on_hrm_login_page(String url) {
		HelperClass.openPage(url);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
	    LoginPageAction objLogin = new LoginPageAction();
	    objLogin.login();
	}
	
	@Then("user should able to login successfully and should see dashboard")
	public void user_should_able_to_login_successfully_and_should_see_dashboard() {
	    HomePageActions objHomePage = new HomePageActions();
	    Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
	}
	
	@When("user enters invalid username and password")
	public void user_enters_invalid_username_and_password() {

	    objLogin.setUserName("WrongUser");
	    objLogin.setPassword("WrongPass");
	    objLogin.clickLogin();
	}

	@Then("user should see error message")
	public void user_should_see_error_message() {

	    String actualText = HelperClass.getDriver()
	            .findElement(By.xpath("//p[contains(@class,'alert-content-text')]"))
	            .getText();

	    Assert.assertTrue(actualText.contains("Invalid credentials"));
	}

}