package com.keywords;

import com.Base.BaseWebComponent;

public class productListPageActions extends BaseWebComponent{
	
	public productListPageActions() {
		super("productListPage");	
	}
	
	public String fetchProductNameOfAvailableProduct() {
		return getText(element("text_ProductName")).trim();
	}
	
	public String fetchProductvalueOfAvailableProduct() {
		return getText(element("text_ProductValue")).trim();
	}
	
	public void hoverOnTheProductAvailable() {
		click(element("hover_AvailableProduct"));
		logMessage("Hovered on the available product");
	}
	
	public void clickOnAddToCartButton() {
		click(element("btn_AddToCart"));
		logMessage("Clicked on Add to cart button");
	}
	
	
	
}
