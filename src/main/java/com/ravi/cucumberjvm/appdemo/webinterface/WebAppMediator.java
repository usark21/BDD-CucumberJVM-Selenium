package com.ravi.cucumberjvm.appdemo.webinterface;

public interface WebAppMediator {
	void click(String element);
	void openBrowser(String browser);
	void navigate(String url);
	boolean isElementPresent(String element);
	void type(String content, String element);
	boolean isUserLoggedIn();
	void performDefaultLogin();
}
