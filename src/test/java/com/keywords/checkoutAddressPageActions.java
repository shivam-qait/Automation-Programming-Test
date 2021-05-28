package com.keywords;

import com.Base.BaseWebComponent;

public class checkoutAddressPageActions extends BaseWebComponent{
	
	public checkoutAddressPageActions() {
		super("checkoutAddressPage");	
	}
	
	public void fillInputValueInCommentBox(String comment) {
		enterText(element("input_CommentBox"), comment);
	}
	
	public void clickOnProceedToCheckoutBtn() {
		click(element("btn_ProceedToCheckout"));
		logMessage("Clicked on Proceed to Checkout button on the address page");
	}
	
}
