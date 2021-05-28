package com.keywords;

import com.Base.BaseWebComponent;

public class MyAccountPageActions extends BaseWebComponent{
	
	public MyAccountPageActions() {
		super("myAccountPage");	
	}

	public String verifyUserIsOnMyAccountPage() {
		return driver.getTitle();
	}
	
	public void clickOnMyPersonalInformationButton() {
		click(element("btn_PersonalInformation"));
		logMessage("Clicked on My Personal Information button");
	}
	
	public void fillDetailOfGenericField(String fieldName, String value) {
		enterText(element("input_GenericField", fieldName), value);
	}
	
	public void clickOnSaveButton() {
		click(element("btn_Save"));
		logMessage("Clicked on Save Button");
	}
	
	public String getAlertSuccessMessage() {
		return getText(element("text_AlertSuccess")).trim();
	}
	
	
	
}
