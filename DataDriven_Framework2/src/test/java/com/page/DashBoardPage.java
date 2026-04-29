package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage{
	
	WebDriver driver;
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	public WebElement dashboardPageTitle;
	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
	
	public String getHomePageText() {
		return dashboardPageTitle.getText();
	}
	

}
