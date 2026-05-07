package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on TutorialsNinja Login page")
    public void user_is_on_tutorials_ninja_login_page() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {

        email = (email == null) ? "" : email;
        password = (password == null) ? "" : password;

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(email);

        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {

        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Then("User should see login warning message {string}")
    public void user_should_see_login_warning_message(String expectedMessage) {

        String actualMessage = wait.until(

                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'alert-danger')]"))

        ).getText();

        if (!actualMessage.contains(expectedMessage)) {

            throw new AssertionError(
                    "Expected: " + expectedMessage + " but got: " + actualMessage);
        }

        driver.quit();
    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {

        String title = driver.getTitle();

        if (!title.contains("My Account")) {

            throw new AssertionError("Login failed");
        }

        driver.quit();
    }
}