/**
 * 
 */
package com.customer.bill.service.impl;

import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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

	@Before
	public void setUp() {
		billService = new BillCalculatorServiceImpl(serviceChargeService, resourceBundleService);
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
