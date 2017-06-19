/**
 * 
 */
package com.customer.bill.service.impl;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.customer.bill.model.ItemType;
import com.customer.bill.model.MenuItem;
import com.customer.bill.service.MenuItemService;
import com.customer.bill.service.ServiceChargeService;

/**
 * @author raghav
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ServiceChargeServiceImplTest {

	private MenuItemService menuItemService;
	private ServiceChargeService serviceChargeService;
	private static final BigDecimal LOW_TOTAL_PRICE = new BigDecimal(50);
	private static final BigDecimal HIGH_TOTAL_PRICE = new BigDecimal(1000);

	@Before
	public void setUp() {
		menuItemService = new MenuItemServiceImpl();
		serviceChargeService = new ServiceChargeServiceImpl(menuItemService);
	}

	@Test
	public void test_getServiceCharge_for_all_drinks() {
		// ARRANGE
		List<MenuItem> items = Arrays.asList(new MenuItem("Cola", ItemType.DRINK),
				new MenuItem("Coffee", ItemType.DRINK));
		BigDecimal expected = BigDecimal.ZERO;
		// ACT
		BigDecimal actual = serviceChargeService.getServiceCharge(items, LOW_TOTAL_PRICE);
		// ASSERT
		assertTrue(expected.equals(actual));
	}

	@Test
	public void test_getServiceCharge_for_atleast_one_food_item_but_no_hotfood() {
		// ARRANGE
		List<MenuItem> items = Arrays.asList(new MenuItem("Cola", ItemType.DRINK),
				new MenuItem("CheeseSandwich", ItemType.FOOD));
		BigDecimal expected = new BigDecimal(5);
		// ACT
		BigDecimal actual = serviceChargeService.getServiceCharge(items, LOW_TOTAL_PRICE);
		// ASSERT
		assertTrue(expected.equals(actual));
	}

	@Test
	public void test_getServiceCharge_for_atleast_one_hotfood() {
		// ARRANGE
		List<MenuItem> items = Arrays.asList(new MenuItem("Cola", ItemType.DRINK),
				new MenuItem("SteakSandwich", ItemType.HOTFOOD));
		BigDecimal expected = new BigDecimal(10);
		// ACT
		BigDecimal actual = serviceChargeService.getServiceCharge(items, LOW_TOTAL_PRICE);
		// ASSERT
		assertTrue(expected.equals(actual));
	}

	@Test
	public void test_getServiceCharge_for_atleast_one_hotfood_with_high_total_price() {
		// ARRANGE
		List<MenuItem> items = Arrays.asList(new MenuItem("Cola", ItemType.DRINK),
				new MenuItem("SteakSandwich", ItemType.HOTFOOD));
		BigDecimal expected = ServiceChargeService.MAX_SERVICE_CHARGE;
		// ACT
		BigDecimal actual = serviceChargeService.getServiceCharge(items, HIGH_TOTAL_PRICE);
		// ASSERT
		assertTrue(expected.equals(actual));
	}

	@Test(expected = NullPointerException.class)
	public void test_getServiceCharge_throwsException_for_null() {
		// ARRANGE & ACT
		serviceChargeService.getServiceCharge(null, HIGH_TOTAL_PRICE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getServiceCharge_throwsException_for_blank_list() {
		// ARRANGE & ACT
		serviceChargeService.getServiceCharge(Collections.emptyList(), HIGH_TOTAL_PRICE);
	}

	@After
	public void tearDown() {

	}
}