package com.stepDef;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import com.Base.YamlReader;
import com.keywords.*;

import io.cucumber.java.en.*;

public class MyAccountTest extends YamlReader {
	
	String updatedFirstname;
	HomePageActions homePage = new HomePageActions();
	MyAccountPageActions myAccountPage = new MyAccountPageActions();


	@When("User clicks on user info button")
	public void User_Clicks_On_User_Info_Button() {
		homePage.clickOnUserInfoButton();
	}
	
	@When("User clicks My Personal Information button")
	public void User_clicks_My_Personal_Information_button() {
		myAccountPage.clickOnMyPersonalInformationButton();
	}
	
	@When("User updates his Personal information")
	public void User_Updates_His_Personal_Information() {
		Random r = new Random();
		updatedFirstname =  getYamlValue("myAccountPage.firstName") + (char)(r.nextInt(26) + 'a');
		myAccountPage.fillDetailOfGenericField(getYamlValue("myAccountPage.fields.firstName"), updatedFirstname);
	}
	
	@When("Enter the current password and click on Save button")
	public void Enter_the_current_password_and_click_on_Save_button() {
		myAccountPage.fillDetailOfGenericField(getYamlValue("myAccountPage.fields.currentPassword"), getYamlValue("credentials.password"));
		myAccountPage.clickOnSaveButton();
	}
	
	@Then("Verify updation alert success message is displayed")
	public void Verify_updation_alert_Success_Message_is_displayed() {
		assertEquals(myAccountPage.getAlertSuccessMessage(), getYamlValue("myAccountPage.successAlert"));
	}
	
	@Then("Verify updated name of user on User Info button")
	public void Verify_updated_name_of_user_on_User_Info_button() {
		assertEquals(homePage.getUpdatedUsernameFromUserInfo(), updatedFirstname + " " + getYamlValue("myAccountPage.lastName"));
	}
}
