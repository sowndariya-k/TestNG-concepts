package com.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Utilies.DPExcel;
import com.Utilies.ScreenshotUtil;
import com.page.DemoLoginPage;
import com.page.ProductPage;


public class DemoBlazeTest extends BaseTest {

    @Test(dataProvider = "excelData", dataProviderClass = DPExcel.class)
    public void testFlow(String username, String password, String type) {

        DemoLoginPage loginPage = new DemoLoginPage(driver);
        ProductPage productPage = new ProductPage(driver);

        loginPage.login(username, password);

        if (type.equalsIgnoreCase("valid")) {

        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	String welcome = wait.until(
        	    ExpectedConditions.visibilityOf(loginPage.welcomeText)
        	).getText();
        	
        	if (welcome.contains("Welcome")) {
        	    ScreenshotUtil.takeScreenshot(loginPage.welcomeText, "forced_fail_welcome");
        	    Assert.fail("Forcing failure for testing screenshot");
        	}

            productPage.selectMacbook();
            String alertMsg = productPage.addToCartAndGetAlert();
            Assert.assertTrue(alertMsg.contains("Product added"));

        } else {

        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String msg = alert.getText();
            alert.accept();

            if (type.equalsIgnoreCase("invalidUser")) {
                Assert.assertEquals(msg, "User does not exist.");
            }

            if (type.equalsIgnoreCase("invalidPassword")) {
                Assert.assertEquals(msg, "Wrong password.");
            }
        }
    }
}