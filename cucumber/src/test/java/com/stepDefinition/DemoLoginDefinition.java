package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DemoLoginDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Demoblaze home page")
    public void user_is_on_demoblaze_home_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User clicks on login link")
    public void user_clicks_on_login_link() {
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("login2")));
        loginBtn.click();
    }

    @When("User enters username as {string}")
    public void user_enters_username_as(String username) {
        WebElement userField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        userField.clear();
        userField.sendKeys(username);
    }

    @When("User enters password as {string}")
    public void user_enters_password_as(String password) {
        WebElement passField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        passField.clear();
        passField.sendKeys(password);
    }

    @When("User clicks on login submit")
    public void user_clicks_on_login_submit() {
        WebElement loginSubmit = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[text()='Log in']")));
        loginSubmit.click();
    }

    // ---------- VALID LOGIN ----------
    @Then("User should see welcome username")
    public void user_should_see_welcome_username() {
        WebElement welcome = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        
        if (!welcome.isDisplayed()) {
            throw new RuntimeException("Login failed - username not visible");
        }

        driver.quit();
    }

    // ---------- INVALID USER ----------
    @Then("User should see alert user does not exist")
    public void user_should_see_alert_user_does_not_exist() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();

        if (!alertText.contains("User does not exist")) {
            throw new RuntimeException("Wrong alert message: " + alertText);
        }

        alert.accept();
        driver.quit();
    }

    // INVALID PASSWORD
    @Then("User should see alert wrong password")
    public void user_should_see_alert_wrong_password() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();

        if (!alertText.contains("Wrong password")) {
            throw new RuntimeException("Wrong alert message: " + alertText);
        }

        alert.accept();
        driver.quit();
    }

    // ---------- EMPTY LOGIN ----------
    @Then("User should see alert Please fill out Username and Password")
    public void user_should_see_alert_empty_fields() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();

        if (!alertText.contains("Please fill out Username and Password")) {
            throw new RuntimeException("Wrong alert message: " + alertText);
        }

        alert.accept();
        driver.quit();
    }
}