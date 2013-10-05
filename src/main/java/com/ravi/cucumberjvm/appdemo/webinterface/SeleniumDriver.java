package com.ravi.cucumberjvm.appdemo.webinterface;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ravi.cucumberjvm.appdemo.util.ApplicationProperties;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SeleniumDriver extends EventFiringWebDriver {
	private static Logger LOGGER = Logger.getLogger(SeleniumDriver.class);	
    private static final String WEBDRIVERNAME = "webdriver";
	private static final WebDriver WEBDRIVER = WebDriverEnum.getWebDriverEnum(ApplicationProperties.getProperty(WEBDRIVERNAME)).getWebDriver();
    private static Thread QUIT_THREAD = new Thread() {
        @Override
        public void run() {
        	WEBDRIVER.quit();
        }
    };
    
    static {
		Runtime.getRuntime().addShutdownHook(QUIT_THREAD);
    }
    
    @Override
    public void quit() {
        if (Thread.currentThread() != QUIT_THREAD) {
            throw new UnsupportedOperationException("It's a shared WebDriver and will close when the JVM exits.");
        }
        super.quit();
    }

    @Before
    public void deleteAllCookies() {
        manage().deleteAllCookies();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/jpeg");
        } catch (WebDriverException unSupportedException) {
        	LOGGER.error(unSupportedException.getMessage());
        }
    }
    
    public SeleniumDriver() {
        super(WEBDRIVER);
    }
}
