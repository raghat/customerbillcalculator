/**
 * 
 */
package com.customer.bill.service.impl;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.customer.bill.model.ItemType;
import com.customer.bill.model.MenuItem;
import com.customer.bill.service.MenuItemService;

/**
 * @author raghav
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MenuItemServiceImplTest {

	private MenuItemService menuItemService;

	@Before
	public void setUp() {
		menuItemService = new MenuItemServiceImpl();
	}

	@Test
	public void test_hasAllDrinks_returns_true_for_all_drinks() {
		// ARRANGE & ACT
		boolean hasAllDrinks = menuItemService.hasAllDrinks(
				Arrays.asList(new MenuItem("Cola", ItemType.DRINK), new MenuItem("Coffee", ItemType.DRINK)));
		// ASSERT
		assertTrue(hasAllDrinks);
	}

	@Test
	public void test_hasAllDrinks_returns_false_if_not_all_drinks() {
		// ARRANGE & ACT
		boolean hasAllDrinks = menuItemService.hasAllDrinks(
				Arrays.asList(new MenuItem("Cola", ItemType.DRINK), new MenuItem("SteakSandwich", ItemType.HOTFOOD)));
		// ASSERT
		assertFalse(hasAllDrinks);
	}

	@Test(expected = NullPointerException.class)
	public void test_hasAllDrinks_throwsException_for_null() {
		// ARRANGE & ACT
		menuItemService.hasAllDrinks(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasAllDrinks_throwsException_for_blank_list() {
		// ARRANGE & ACT
		menuItemService.hasAllDrinks(emptyList());
	}

	@Test
	public void test_hasAtleastOneFoodItem_returns_true_for_atleast_one_food_MenuItem() {
		// ARRANGE & ACT
		boolean hasAtleastOneFoodItem = menuItemService.hasAtleastOneFoodItem(
				Arrays.asList(new MenuItem("Cola", ItemType.DRINK), new MenuItem("SteakSandwich", ItemType.HOTFOOD),
						new MenuItem("CheeseSandwich", ItemType.FOOD)));
		// ASSERT
		assertTrue(hasAtleastOneFoodItem);
	}

	@Test
	public void test_hasAtleastOneFoodItem_returns_false_if_no_food_items() {
		// ARRANGE & ACT
		boolean hasAtleastOneFoodItem = menuItemService.hasAtleastOneFoodItem(
				Arrays.asList(new MenuItem("Cola", ItemType.DRINK), new MenuItem("SteakSandwich", ItemType.HOTFOOD)));
		// ASSERT
		assertFalse(hasAtleastOneFoodItem);
	}

	@Test(expected = NullPointerException.class)
	public void test_hasAtleastOneFoodItem_throwsException_for_null() {
		// ARRANGE & ACT
		menuItemService.hasAtleastOneFoodItem(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasAtleastOneFoodItem_throwsException_for_blank_list() {
		// ARRANGE & ACT
		menuItemService.hasAtleastOneFoodItem(emptyList());
	}

	@Test
	public void test_hasAtleastOneFoodItem_returns_false_for_no_hotfood_items() {
		// ARRANGE & ACT
		boolean hasAtleastOneHotFoodItem = menuItemService.hasAtleastOneHotFoodItem(
				Arrays.asList(new MenuItem("Cola", ItemType.DRINK), new MenuItem("CheeseSandwich", ItemType.FOOD)));
		// ASSERT
		assertFalse(hasAtleastOneHotFoodItem);
	}

	@Test
	public void test_hasAtleastOneHotFoodItem_returns_true_if_atleast_one_hotfood_MenuItem() {
		// ARRANGE & ACT
		boolean hasAtleastOneFoodItem = menuItemService.hasAtleastOneHotFoodItem(
				Arrays.asList(new MenuItem("Cola", ItemType.DRINK), new MenuItem("SteakSandwich", ItemType.HOTFOOD)));
		// ASSERT
		assertTrue(hasAtleastOneFoodItem);
	}

	@Test(expected = NullPointerException.class)
	public void test_hasAtleastOneHotFoodItem_throwsException_for_null() {
		// ARRANGE & ACT
		menuItemService.hasAtleastOneHotFoodItem(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hasAtleastOneHotFoodItem_throwsException_for_blank_list() {
		// ARRANGE & ACT
		menuItemService.hasAtleastOneHotFoodItem(emptyList());
	}

	@After
	public void tearDown() {
		menuItemService = null;
	}
}