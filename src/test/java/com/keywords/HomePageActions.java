package com.keywords;

import com.Base.BaseWebComponent;

public class HomePageActions extends BaseWebComponent{
	
	public HomePageActions() {
		super("homePage");	
	}

	public boolean verifyUserIsLoggedIn() {
		return element("btn_Logout").isDisplayed();		
	}
	
	
	public void clickOnGenericHeaderMenuItem(String menuItem) {
		click(element("btn_MenuItem",menuItem));
		logMessage("Clicked on "+ menuItem + "button");
	}
	
	public void clickOnUserInfoButton() {
		click(element("btn_UserInfo"));
		logMessage("Clicked on User info button");
	}

	public String getUpdatedUsernameFromUserInfo() {
		return getText(element("btn_UserInfo")).trim();
	}
	
}
