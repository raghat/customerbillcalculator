/**
 * 
 */
package com.customer.bill.service.impl;

import static org.mockito.Mockito.when;

import java.util.ResourceBundle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.customer.bill.service.ResourceBundleService;

/**
 * @author raghav
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ResourceBundleServiceImplTest {
	@Autowired
	private ResourceBundleService resourceBundleService;
	@Mock
	private ResourceBundle resourceBundle;

	@Before
	public void setUp() {
		resourceBundleService = new ResourceBundleServiceImpl();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getConfigValue_throwsException_for_invalid_key() {
		// ARRANGE & ACT
		when(resourceBundle.containsKey("CRAP")).thenReturn(false);
		resourceBundleService.getConfigValue("CRAP");
	}

	/*
	 * Commenting this OUT as I can't find PowerMockito in my maven setup. Needs
	 * static method mocking.
	 * 
	 * @Test public void test_getConfigValue_throwsException_for_valid_key() {
	 * // ARRANGE & ACT
	 * when(resourceBundle.containsKey("ColaPrice")).thenReturn(false);
	 * when(resourceBundle.getString("ColaPrice")).thenReturn("0.5"); // ASSERT
	 * assertTrue(resourceBundleService.getConfigValue("ColaPrice").equals("0.5"
	 * )); }
	 */

	@After
	public void tearDown() {
		resourceBundleService = null;
	}
}
