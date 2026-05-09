package com.actions;

import org.openqa.selenium.support.PageFactory;

import com.pages.HomePageLocator;
import com.utilities.HelperClass;

public class HomePageActions {
	HomePageLocator homePageLocator=null;
	public HomePageActions(){
		this.homePageLocator=new HomePageLocator();
		PageFactory.initElements(HelperClass.getDriver(), homePageLocator);
	}
	
	public String getHomePageText() {
		return homePageLocator.homepageUserName.getText();
	}

}
