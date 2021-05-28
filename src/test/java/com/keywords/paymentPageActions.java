package com.keywords;

import com.Base.BaseWebComponent;

public class paymentPageActions extends BaseWebComponent{
	
	public paymentPageActions() {
		super("paymentPage");	
	}
	
	public void clickOnGenericPaymentOption(String paymentOption) {
		click(element("btn_GenPaymentOption", paymentOption));
		logMessage("Clicked on payment option: "+paymentOption);
	}
	
	public void clickOnConfirmOrderButton() {
		click(element("btn_ConfirmOrderBtn"));
		logMessage("Clicked on Confirm order button");
	}
	
	public String fetchReferenceIDOfPlacedOrder() {
		logMessage("Reference ID: "+getText(element("text_OrderConfirmation")).split("reference ")[1].split("\\.")[0]);
		return getText(element("text_OrderConfirmation")).split("reference ")[1].split("\\.")[0];
	}
	
	public void clickOnBackToOrdersButton() {
		click(element("btn_BackToOrders"));
		logMessage("Clicked on Back to orders button");
	}
}
