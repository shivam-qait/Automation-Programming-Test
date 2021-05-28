package com.keywords;

import com.Base.BaseWebComponent;

public class checkoutShippingPageActions extends BaseWebComponent{
	
	public checkoutShippingPageActions() {
		super("checkoutShippingPage");	
	}
	
	public void clickOnTermsOfServiceCheckbox() {
		click(element("checbox_TermOfService"));
		logMessage("Checked the terms of service checkbox");
	}
	
	public void clickOnProceedToCheckoutBtn() {
		click(element("btn_ProceedToCheckout"));
		logMessage("Clicked on Proceed to Checkout button on the shipping page");
	}
	
}
