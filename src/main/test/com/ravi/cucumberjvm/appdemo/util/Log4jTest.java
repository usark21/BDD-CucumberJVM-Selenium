package com.ravi.cucumberjvm.appdemo.util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.testng.Assert;

public class Log4jTest {
	private static Logger logger = Logger.getLogger(Log4jTest.class);

	@Test
	public void testLogging() {
		String xmlFilePath = System.getProperty("user.dir")+"//src//main//resources//META-INF//log4j.xml";
		Assert.assertNotNull(xmlFilePath);
		Assert.assertNotEquals("", xmlFilePath);
		DOMConfigurator.configure(xmlFilePath);
		logger.debug("Tesing Log");
		Assert.assertTrue(true);
	}
}
