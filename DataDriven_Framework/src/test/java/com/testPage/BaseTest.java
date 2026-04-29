package com.testPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.page.DashBoardPage;
import com.page.LoginPage;

public class BaseTest {
	public static WebDriver driver;
	LoginPage objLogin;
	DashBoardPage objDashBoard;
	
	@BeforeClass
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
}
