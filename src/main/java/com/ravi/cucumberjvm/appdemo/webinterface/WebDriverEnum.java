package com.ravi.cucumberjvm.appdemo.webinterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum WebDriverEnum {
	FIREFOX("Mozilla"){
		@Override
		public WebDriver getWebDriver() {
			return new FirefoxDriver();
		}
	},
	CHROME("Chrome"){
		@Override
		public WebDriver getWebDriver() {
			return new ChromeDriver();
		}
	};
	
	private String driverName;

	private WebDriverEnum(final String driverName) {
		this.driverName = driverName;
	}

	public String getDriverName() {
		return driverName;
	}
	
	abstract public WebDriver getWebDriver();
	
	public static WebDriverEnum getWebDriverEnum(String driverName) {
		for (WebDriverEnum webDriverEnum : WebDriverEnum.values()) {
			if (webDriverEnum.getDriverName().equals(driverName)) {
				return webDriverEnum;
			}
		}
		return null;
	}
}
