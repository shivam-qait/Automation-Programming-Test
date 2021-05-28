@myStoreApplication
Feature: Feature to test My Store Application


  Scenario: Verify order history of placed order 
    Given User is logged in the application 
    And User is on the My Account Page
    When User clicks on T-SHIRTS button from the menu items
    And Hover and click on Add to cart button of the product available
    And Click on Proceed to Checkout button on the cart page 
    And Click on Proceed to Checkout button on the summary page
    And User fill the comment section on the Address page
    And Click on Proceed to Checkout button on Address page
    And Click on Terms of Service checkbox on Shipping Page
    And Click on Proceed to Checkout button on Shipping Page
    And User clicks on Pay by check button on Payment page
    And User clicks on Comfirm order button
    And User clicks on Back to Order button
    And Click on Details button for the place order in Order History page
    Then Verify Order reference id, total price, payment option for the placed order
    And Verify the product name is correctly displayed of the place order
    And Verify the delivery address is correctly displayed in the details of placed order
    And Verify the comment added by the user is displayed in Messages section on the History page 
    

  Scenario: Verify User is able to update personal information in My Account
  	Given User is logged in the application 
    And User is on the My Account Page
  	And User clicks My Personal Information button
    And User updates his Personal information
    And Enter the current password and click on Save button
    Then Verify updation alert success message is displayed
    And Verify updated name of user on User Info button
  	