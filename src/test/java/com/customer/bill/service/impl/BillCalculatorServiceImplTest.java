/**
 * 
 */
package com.customer.bill.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.customer.bill.model.ItemType;
import com.customer.bill.model.MenuItem;
import com.customer.bill.service.BillCalculatorService;
import com.customer.bill.service.ResourceBundleService;
import com.customer.bill.service.ServiceChargeService;

/**
 * @author raghav
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BillCalculatorServiceImplTest {

	@Mock
	private ServiceChargeService serviceChargeService;
	@Mock
	private ResourceBundleService resourceBundleService;
	private BillCalculatorService billService;
	List<MenuItem> items = Arrays.asList(new MenuItem("Cola", ItemType.DRINK),
			new MenuItem("SteakSandwich", ItemType.HOTFOOD));
	private BigDecimal totalPrice = new BigDecimal("5.0");

	@Before
	public void setUp() {
		billService = new BillCalculatorServiceImpl(serviceChargeService, resourceBundleService);
		when(serviceChargeService.getServiceCharge(items, totalPrice)).thenReturn(new BigDecimal("1.0"));
		when(resourceBundleService.getConfigValue("ColaPrice")).thenReturn("0.5");
		when(resourceBundleService.getConfigValue("SteakSandwichPrice")).thenReturn("4.5");
	}

	@Test
	public void test_getTotalBillIncludingServiceCharge() {
		// ARRANGE
		BigDecimal expected = new BigDecimal("6.0");
		// ACT
		BigDecimal actual = billService.getTotalBillIncludingServiceCharge(items);
		// ASSERT
		assertTrue(expected.equals(actual));
	}

	@Test
	public void test_getTotalBillExcludingServiceCharge() {
		// ARRANGE
		BigDecimal expected = new BigDecimal("5.0");
		// ACT
		BigDecimal actual = billService.getTotalBillExcludingServiceCharge(items);
		// ASSERT
		assertTrue(expected.equals(actual));
	}

	@Test(expected = NullPointerException.class)
	public void test_getTotalBillExcludingServiceCharge_null_Test() {
		// ARRANGE & ACT
		billService.getTotalBillExcludingServiceCharge(null);
	}

	@Test(expected = NullPointerException.class)
	public void test_getTotalBillIncludingServiceCharge_null_Test() {
		// ARRANGE & ACT
		billService.getTotalBillIncludingServiceCharge(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getTotalBillExcludingServiceCharge_throwsException_for_blank_list() {
		// ARRANGE & ACT
		billService.getTotalBillExcludingServiceCharge(Collections.emptyList());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getTotalBillIncludingServiceCharge_throwsException_for_blank_list() {
		// ARRANGE & ACT
		billService.getTotalBillIncludingServiceCharge(Collections.emptyList());
	}

	@After
	public void tearDown() {
		billService = null;
	}
}
