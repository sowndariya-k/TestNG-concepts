package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
	
	WebDriver driver;
	By dashboardPageTitle=By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getHomePageText() {
		return driver.findElement(dashboardPageTitle).getText();
	}
}