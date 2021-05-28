package com.TestRunner;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Base.TestInitiator;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/features",
glue = {"com.stepDef"}, 
plugin = {"pretty", "html:target/cucumber/report.html",
		"pretty", "json:target/cucumber/report.json"})

public class CucumberTestRunner extends AbstractTestNGCucumberTests{
	
	@BeforeClass
	public static void classSetup()  {
			TestInitiator.setUp();
	} 

	@AfterClass
	public static void classTeardown(){
		TestInitiator.closeAll();
	}

}
