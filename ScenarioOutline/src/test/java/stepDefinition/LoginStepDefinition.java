package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

public class LoginStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Demoblaze home page")
    public void user_is_on_demoblaze_home_page() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));
    }

    @When("User clicks on login link")
    public void user_clicks_on_login_link() {

        driver.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    }

    @When("User enters username as {string} and passsword as {string}")
    public void user_enters_username_as_and_passsword_as(String username, String password) {

        driver.findElement(By.id("loginusername")).clear();
        driver.findElement(By.id("loginusername")).sendKeys(username);

        driver.findElement(By.id("loginpassword")).clear();
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }

    @When("User clicks on login submit")
    public void user_clicks_on_login_submit() {

        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("User should be able to see an {string}")
    public void user_should_be_able_to_see_an(String expectedMessage) {

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String actualMessage = alert.getText().trim();
        String expected = expectedMessage.trim();

        if (!actualMessage.equalsIgnoreCase(expected)) {
            throw new AssertionError("Expected: " + expected + " but got: " + actualMessage);
        }

        alert.accept();
        driver.quit();
    }
    
    @When("User enters valid credentials")
    public void user_enters_valid_credentials(DataTable dataTable) {

        // Convert DataTable to List
        List<List<String>> data = dataTable.asLists();

        String username = data.get(0).get(0);
        String password = data.get(0).get(1);
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }
    
    @Then("User should be able to login successful and new page open")
    public void user_should_be_able_to_login_successful_and_new_page_open() {

        // Ensure no alert appears
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            throw new AssertionError("Unexpected alert appeared for valid login");
        } catch (Exception e) {
            // expected path
        }

        String userText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        ).getText();

        if (!userText.contains("Welcome")) {
            throw new AssertionError("Login failed");
        }

        driver.quit();
    }
    
    @Then("User enters multiple invalid credentials and validates error messages")
    public void user_enters_multiple_invalid_credentials_and_validates_error_messages(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {

            String username = row.get("username");
            String password = row.get("password");
            String expectedMessage = row.get("errorMessage");
            
            username = (username == null) ? "" : username;
            password = (password == null) ? "" : password;

            driver.findElement(By.id("loginusername")).sendKeys(username);
            driver.findElement(By.id("loginpassword")).sendKeys(password);

            driver.findElement(By.xpath("//button[text()='Log in']")).click();

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();

            String actualMessage = alert.getText().trim();

            if (!actualMessage.equalsIgnoreCase(expectedMessage.trim())) {
                throw new AssertionError("Expected: " + expectedMessage + " but got: " + actualMessage);
            }

            alert.accept();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        }

        driver.quit();
    }
}