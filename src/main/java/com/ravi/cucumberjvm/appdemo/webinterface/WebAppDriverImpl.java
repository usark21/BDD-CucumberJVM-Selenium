package com.ravi.cucumberjvm.appdemo.webinterface;

import static com.ravi.cucumberjvm.appdemo.util.ApplicationProperties.getProperty;
import static com.ravi.cucumberjvm.appdemo.util.ObjectRepository.getElementProperty;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebAppDriverImpl implements WebAppDriver {
	private static Logger LOGGER = Logger.getLogger(WebAppDriverImpl.class);
	private static final String LOG4J_FILE_PATH = System.getProperty("user.dir")+"//src//main//resources//META-INF//log4j.xml";
	private static WebAppDriverImpl webAppDriver;
	private static WebDriver driver = null;
	private static final String CONTACT_INFO = "contactinfo";
	private static final String APP_URL = "appurl";
	private static final String PASSWORD = "password";
	private static final String USER_ID = "userid";
	private static final String USER_NAME = "username";
	private static final String LOGIN = "login";

	private WebAppDriverImpl() {
	}

	public static WebAppDriverImpl getInstance() {
		if (webAppDriver == null) {
			webAppDriver = new WebAppDriverImpl();
			DOMConfigurator.configure(LOG4J_FILE_PATH);
		}
		return webAppDriver;
	}

	@Override
	public void openBrowser(String browser) {
		LOGGER.debug("Opening Browser " + browser);
		driver = new SeleniumDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Override
	public void navigate(String url) {
		LOGGER.debug("Naviating to " + url);
		driver.get(url);
	}

	@Override
	public boolean isElementPresent(String element) {
		if (driver.findElements(By.xpath(getElementProperty(element, "xpath")))
				.size() > 0)
			return true;
		return false;
	}

	@Override
	public void type(String text, String element) {
		LOGGER.debug("Typing in " + text);
		driver.findElement(By.xpath(getElementProperty(element,"xpath")))
				.sendKeys(text);
	}
	
	@Override
	public void click(String element) {
		LOGGER.debug("Clicking on " + element);
		driver.findElement(By.xpath(getElementProperty(element,"xpath"))).click();
	}

	@Override
	public boolean isUserLoggedIn() {
		return isElementPresent(CONTACT_INFO);
	}

	@Override
	public void performDefaultLogin() {
		LOGGER.debug("performing default login");
		navigate(getProperty(APP_URL));
		type(getProperty(USER_NAME), USER_ID);
		type(getProperty(PASSWORD), PASSWORD);
		click(LOGIN);
	}

}
