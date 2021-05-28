package com.keywords;

import com.Base.BaseWebComponent;

public class orderHistoryPageActions extends BaseWebComponent{
	
	public orderHistoryPageActions() {
		super("orderHistoryPage");	
	}
	
	public void clickOnDetailsBtnOfLatestOrder() {
		click(element("btn_Details"));
		logMessage("Clicked on details button of latest order created");
	}
	
	public String getGenericOrderDetailValue(String refereneID, String detailsTab) {
		return getText(element("txt_GenericOrderDetailValue", refereneID, detailsTab)).trim();
	}
	
	public boolean verifyProductNameIsDisplayedCorrectly(String productName) {
		return element("txt_ProductName", productName).isDisplayed();
	}
	
	public boolean verifyCommentIsDisplayedCorrectly(String comment) {
		return element("txt_Comment", comment).isDisplayed();
	}
	
	public String verifyDeliveryAddressIsDisplayedCorrectly() {
		logMessage(getText(element("txt_DeliveryAddress")));
		return getText(element("txt_DeliveryAddress")).trim();
	}
	
//	public boolean verifyUserIsOnOrderHistoryPage() {
//		return element("heading_OrderHistory").isDisplayed();
//	}
	
}
