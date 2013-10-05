package com.ravi.cucumberjvm.appdemo.webinterface;

import org.junit.Assert;
import org.junit.Test;

public class WebDriverEnumTest {

	@Test
	public void testGetWebDriverEnum_FireFoxDriver(){
		Assert.assertEquals(WebDriverEnum.FIREFOX, WebDriverEnum.getWebDriverEnum("Mozilla"));
	}
	
	@Test
	public void testGetWebDriverEnum_ChromeDriver(){
		Assert.assertEquals(WebDriverEnum.CHROME, WebDriverEnum.getWebDriverEnum("Chrome"));
	}
}
