package com.stepDef;
import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.Base.YamlReader;
import com.keywords.*;

import io.cucumber.java.en.*;

public class OrderHistoryTest extends YamlReader {
	
	String productName, productValue, totalPrice, referenceID;
	HomePageActions homePage = new HomePageActions();
	productListPageActions productListPage = new productListPageActions();
	cartPageActions cartPage = new cartPageActions();
	checkoutSummaryPageActions checkoutSummaryPage = new checkoutSummaryPageActions();
	checkoutAddressPageActions addressSummaryPage = new checkoutAddressPageActions();
	checkoutShippingPageActions shippingSummaryPage = new checkoutShippingPageActions();
	paymentPageActions paymentPage = new paymentPageActions();
	orderHistoryPageActions orderHistoryPage = new orderHistoryPageActions();
	MyAccountPageActions myAccountPage = new MyAccountPageActions();
	
	@Given("User is logged in the application")
	public void Verify_User_is_logged_in_the_application() {
		assertEquals(homePage.verifyUserIsLoggedIn(), true);
	}
	
	@Given("User is on the My Account Page")
	public void user_is_on_the_my_account_page() {
		assertEquals(myAccountPage.verifyUserIsOnMyAccountPage(), getYamlValue("myAccountPage.title"));
	}

	@When("User clicks on T-SHIRTS button from the menu items")
	public void Verify_User_clicks_on_TSHIRTS_button_from_the_menu_items() {
	    homePage.clickOnGenericHeaderMenuItem(getYamlValue("headerMenuItem.tshirts"));
	}

	@When("Hover and click on Add to cart button of the product available")
	public void hover_and_click_on_add_to_cart_button_of_the_product_available() {
		productName = productListPage.fetchProductNameOfAvailableProduct();
		productValue = productListPage.fetchProductvalueOfAvailableProduct();
		productListPage.hoverOnTheProductAvailable();
		productListPage.clickOnAddToCartButton();
	}

	@When("Click on Proceed to Checkout button on the cart page")
	public void click_on_proceed_to_checkout_button_on_the_cart_page() {
		totalPrice = cartPage.fetchTotalProductvalueOfAddedProduct();
		cartPage.clickOnProceedToCheckoutBtn();
	}

	@When("Click on Proceed to Checkout button on the summary page")
	public void click_on_proceed_to_checkout_button_on_the_summary_page() {
	    checkoutSummaryPage.clickOnProceedToCheckoutBtn();
	}

	@When("User fill the comment section on the Address page")
	public void user_fill_the_comment_section_on_the_address_page() {
		addressSummaryPage.fillInputValueInCommentBox("Test Comment");
	}

	@When("Click on Proceed to Checkout button on Address page")
	public void click_on_proceed_to_checkout_button_on_address_page() {
		addressSummaryPage.clickOnProceedToCheckoutBtn();
	}

	@When("Click on Terms of Service checkbox on Shipping Page")
	public void click_on_terms_of_service_checkbox_on_shipping_page() {
		shippingSummaryPage.clickOnTermsOfServiceCheckbox();
	}

	@When("Click on Proceed to Checkout button on Shipping Page")
	public void click_on_proceed_to_checkout_button_on_shipping_page() {
		shippingSummaryPage.clickOnProceedToCheckoutBtn();
	}

	@When("User clicks on Pay by check button on Payment page")
	public void user_clicks_on_pay_by_check_button_on_payment_page() {
		paymentPage.clickOnGenericPaymentOption(getYamlValue("paymentOptions.payByCheck"));
	}

	@When("User clicks on Comfirm order button")
	public void user_clicks_on_comfirm_order_button() {
		paymentPage.clickOnConfirmOrderButton();
	}

	@When("User clicks on Back to Order button")
	public void user_clicks_on_back_to_order_button() {
	    referenceID = paymentPage.fetchReferenceIDOfPlacedOrder();
	    paymentPage.clickOnBackToOrdersButton();
	}

	@When("Click on Details button for the place order in Order History page")
	public void click_on_details_button_for_the_place_order_in_order_history_page() {
		orderHistoryPage.clickOnDetailsBtnOfLatestOrder();
	}
	
	@Then("Verify Order reference id, total price, payment option for the placed order")
	public void verify_order_reference_id_total_price_payment_option_for_the_placed_order() {
		assertEquals(orderHistoryPage.getGenericOrderDetailValue(referenceID, getYamlValue("orderDetails.totalPrice")), totalPrice);
		assertEquals(orderHistoryPage.getGenericOrderDetailValue(referenceID, getYamlValue("orderDetails.payment")), getYamlValue("orderDetails.paymentOption.paymentByCheck"));
	}

	@Then("Verify the product name is correctly displayed of the place order")
	public void verify_the_product_name_is_correctly_displayed_of_the_place_order() {
		assertEquals(orderHistoryPage.verifyProductNameIsDisplayedCorrectly(productName), true);
	}


	@Then("Verify the delivery address is correctly displayed in the details of placed order")
	public void verify_the_delivery_address_is_correctly_displayed_in_the_details_of_placed_order() {
		assertEquals(orderHistoryPage.verifyDeliveryAddressIsDisplayedCorrectly(), getYamlValue("deliveryAddress"));
	}

	@Then("Verify the comment added by the user is displayed in Messages section on the History page")
	public void verify_the_comment_added_by_the_user_is_displayed_in_messages_section_on_the_history_page() {
		assertEquals(orderHistoryPage.verifyCommentIsDisplayedCorrectly("Test Comment"), true);
	}
}
