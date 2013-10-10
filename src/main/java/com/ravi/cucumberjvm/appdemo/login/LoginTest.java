package com.ravi.cucumberjvm.appdemo.login;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.ravi.cucumberjvm.appdemo.util.ApplicationProperties;
import com.ravi.cucumberjvm.appdemo.webinterface.WebAppDriver;
import com.ravi.cucumberjvm.appdemo.webinterface.WebAppDriverImpl;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class LoginTest {
	private static Logger LOGGER = Logger.getLogger(LoginTest.class);
	private WebAppDriver webAppDriver = WebAppDriverImpl.getInstance();
	
	@Given("^I open \"([^\"]*)\" and type \"([^\"]*)\"$")
	public void I_Open(final String browser, final String url){
		LOGGER.debug("I am going to "+ url +" on  "+ browser);
		webAppDriver.openBrowser(browser);
		webAppDriver.navigate(ApplicationProperties.getProperty(url));
	}
	
	@Then("^I should be \"([^\"]*)\" to login$")
	public void I_should_be(String expectedResult){
		LOGGER.debug("Login - "+ expectedResult);
		Assert.assertEquals(expectedResult, webAppDriver.isElementPresent("contactinfo")? "successfull": "failed");
	}
}
