package com.page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Laptops")
    WebElement laptopsMenu;

    @FindBy(linkText = "MacBook Pro")
    WebElement macbook;

    @FindBy(linkText = "Add to cart")
    WebElement addToCart;

    public void selectMacbook() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        laptopsMenu.click();
        wait.until(ExpectedConditions.elementToBeClickable(macbook)).click();
    }

    public String addToCartAndGetAlert() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String msg = alert.getText();
        alert.accept();

        return msg;
    }
}