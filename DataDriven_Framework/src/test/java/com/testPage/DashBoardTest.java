package com.testPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.page.DashBoardPage;
import com.page.LoginPage;

public class DashBoardTest extends BaseTest{
	
	@Test(priority = 0)
	public void DashboardTest() {
	    objLogin = new LoginPage(driver);
	    objDashBoard = new DashBoardPage(driver);

	    objLogin.login("Admin", "admin123"); 

	    Assert.assertTrue(objDashBoard.getHomePageText().contains("Dashboard"));
	}

}
