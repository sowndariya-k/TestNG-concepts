package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class CartStepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on TutorialsNinja Home page")
    public void user_is_on_tutorials_ninja_home_page() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/");
    }

    @When("User adds multiple products to cart")
    public void user_adds_multiple_products_to_cart(DataTable dataTable) {

        List<Map<String, String>> products =
                dataTable.asMaps(String.class, String.class);

        for (Map<String, String> product : products) {

            String productName = product.get("productName");

            driver.findElement(By.name("search")).clear();

            driver.findElement(By.name("search"))
                    .sendKeys(productName);

            driver.findElement(
                    By.xpath("//button[contains(@class,'btn-default')]"))
                    .click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.linkText(productName)));

            driver.findElement(By.linkText(productName)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("button-cart")));

            driver.findElement(By.id("button-cart")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'alert-success')]")));

            driver.get("https://tutorialsninja.com/demo/");
        }
    }

    @Then("Products should be added successfully to cart")
    public void products_should_be_added_successfully_to_cart() {

        driver.findElement(
                By.xpath("//span[text()='Shopping Cart']"))
                .click();

        String actualTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='content']/h1"))
        ).getText();

        if (!actualTitle.contains("Shopping Cart")) {

            throw new AssertionError(
                    "Products not added successfully");
        }

        driver.quit();
    }
}