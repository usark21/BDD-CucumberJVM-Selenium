package com.ravi.cucumberjvm.appdemo.menu;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.ravi.cucumberjvm.appdemo.webinterface.WebAppDriver;
import com.ravi.cucumberjvm.appdemo.webinterface.WebAppDriverImpl;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AdminMenuTest {
	private static Logger LOGGER = Logger.getLogger(AdminMenuTest.class);
	private WebAppDriver webAppDriver = WebAppDriverImpl.getInstance();
	
	@Given("^User logged in \"([^\"]*)\"$")
	public void User_logged_in(String browser){
		webAppDriver.openBrowser(browser);
		if(!webAppDriver.isUserLoggedIn()){
			LOGGER.debug("Do default login");
			webAppDriver.performDefaultLogin();
		}
	}
	
	@Then("^Admin tab on headermenu bar should be present$")
	public void Admin_tab_on_menu_bar_should_be_present(DataTable dataTable){
		List<String> menus= dataTable.asList(String.class);
		for(String menu : menus){
			LOGGER.debug("Menu Item " + menu);
			Assert.assertTrue("Element not found in Menu " + menu, webAppDriver.isElementPresent(menu));
		}
	}
	
	@And("^\"([^\"]*)\" should be present$")
	public void Should_be_present(String webElement){
		LOGGER.debug("Web Element " + webElement + "should be present");
		Assert.assertTrue("Element " + webElement + "not found", webAppDriver.isElementPresent(webElement));
	}
}
