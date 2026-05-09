package com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public final static int TIMEOUT = 10;

    public static void setupDriver() {

        if (driver.get() == null) {

            WebDriver webDriver = new ChromeDriver();

            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            webDriver.manage().window().maximize();

            driver.set(webDriver);

            wait.set(new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void openPage(String url) {
        getDriver().get(url);
    }

    public static void tearDown() {

        if (driver.get() != null) {
            getDriver().quit();

            driver.remove();
            wait.remove();
        }
    }
}