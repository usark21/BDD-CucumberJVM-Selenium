package com.ravi.cucumberjvm.appdemo.util;

import java.io.FileInputStream;
import java.util.Properties;

public class ApplicationProperties {
	private static final String PROPERTIES_FILE_PATH = System
			.getProperty("user.dir")
			+ "\\src\\main\\resources\\config\\application.properties";
	private static Properties props;

	private ApplicationProperties() {
	}

	static {
		props = new Properties();
		try {
			FileInputStream fs = new FileInputStream(PROPERTIES_FILE_PATH);
			props.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Properties getProperties() {
		return props;
	}

	public static String getProperty(String key) {
		return (String) getProperties().get(key);
	}

	public static String getProperty(String key, String def) {
		String s = (String) getProperties().get(key);
		return s != null ? s : def;
	}
}
