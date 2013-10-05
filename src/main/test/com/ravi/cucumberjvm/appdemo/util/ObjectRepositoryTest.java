package com.ravi.cucumberjvm.appdemo.util;

import org.junit.Assert;
import org.junit.Test;

public class ObjectRepositoryTest {
	@Test
	public void testGetElementProperty_WhenElementPresent(){
		Assert.assertNotNull(ObjectRepository.getElementProperty("contactinfo"));
	}
	@Test
	public void testGetElementProperty_WhenElementNotPresent(){
		Assert.assertNull(ObjectRepository.getElementProperty("junk"));
	}
}
