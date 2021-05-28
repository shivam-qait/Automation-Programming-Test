package com.keywords;

import com.Base.BaseWebComponent;

public class cartPageActions extends BaseWebComponent{
	
	public cartPageActions() {
		super("cartPage");	
	}
	
	public String fetchTotalProductvalueOfAddedProduct() {
		return getText(element("text_TotalPrice")).trim();
	}
	
	public void clickOnProceedToCheckoutBtn() {
		click(element("btn_ProceedToCheckout"));
		logMessage("Clicked on Proceed to Checkout button on the cart page");
	}
	
}
