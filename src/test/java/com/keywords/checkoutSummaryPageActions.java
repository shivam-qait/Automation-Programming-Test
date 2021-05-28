package com.keywords;

import com.Base.BaseWebComponent;

public class checkoutSummaryPageActions extends BaseWebComponent{
	
	public checkoutSummaryPageActions() {
		super("checkoutSummaryPage");	
	}
	
	public void clickOnProceedToCheckoutBtn() {
		click(element("btn_ProceedToCheckout"));
		logMessage("Clicked on Proceed to Checkout button on the summary page");
	}
	
}
