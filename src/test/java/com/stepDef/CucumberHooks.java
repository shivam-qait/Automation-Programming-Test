package com.stepDef;


import com.Base.*;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks extends BaseWebComponent{
	
	public CucumberHooks() {
		super("loginPage");
	}
	
	@Before
	public void openURL() {
		driver.get(getYamlValue("baseURL"));
		signInTheApplication();
	}
	
	public void signInTheApplication() {
		click(element("btn_Login"));
		enterText(element("input_Email"), getYamlValue("credentials.username"));
		enterText(element("input_Password"), getYamlValue("credentials.password"));
		click(element("btn_SignIn"));
	}
	
	public void signOutFromApplication() {
		click(element("btn_Logout"));
	}
	
	@After
	public void embedResult(Scenario scenario) {
		signOutFromApplication();
		System.out.println("********************");
		System.out.println(
				"Scenario: " + scenario.getName() + " : " + scenario.getStatus());
		System.out.println("********************");
		waitTillTime(5000);
	}

}
