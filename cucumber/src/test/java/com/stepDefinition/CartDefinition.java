package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartDefinition {

    private String selectedProduct;

    @When("User selects product {string}")
    public void user_selects_product(String product) {

        selectedProduct = product;

        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText(product))).click();
    }

    @When("User adds the product to cart")
    public void user_adds_the_product_to_cart() {
    	
    	WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Add to cart']"))).click();

        wait.until(ExpectedConditions.alertIsPresent());

        String text = BaseTest.driver.switchTo().alert().getText();

        if (!text.contains("Product added")) {
            throw new AssertionError("Product not added");
        }

        BaseTest.driver.switchTo().alert().accept();
    }

    @When("User navigates to cart page")
    public void user_navigates_to_cart_page() {

        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("cartur"))).click();
    }

    @Then("User should see the product in cart")
    public void user_should_see_the_product_in_cart() {

        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[text()='" + selectedProduct + "']")));
    }

    @When("User removes the product from cart")
    public void user_removes_the_product_from_cart() {

        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Delete"))).click();
    }

    @Then("Product should be removed from cart")
    public void product_should_be_removed_from_cart() {

        WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//td[text()='" + selectedProduct + "']")));
    }
}