/**
 * 
 */
package com.customer.bill.service.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import com.customer.bill.model.ItemType;
import com.customer.bill.model.MenuItem;
import com.customer.bill.service.MenuItemService;

/**
 * @author raghav
 *
 */
@Service
public class MenuItemServiceImpl implements MenuItemService {

	/*
	 * This method checks if all the items in the list are drinks.
	 * 
	 * @see com.customer.bill.service.MenuItemService#hasAllDrinks()
	 */
	@Override
	public boolean hasAllDrinks(List<MenuItem> items) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		return items.stream().allMatch(item -> item.getItemType().equals(ItemType.DRINK));
	}

	/*
	 * This method returns true if the items has atleast one food item in it.
	 * This can have hotfood or drinks along with food item.
	 * 
	 * @see com.customer.bill.service.MenuItemService#hasAtleastOneFoodItem()
	 */
	@Override
	public boolean hasAtleastOneFoodItem(List<MenuItem> items) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		return items.stream().anyMatch(item -> item.getItemType().equals(ItemType.FOOD));
	}

	/*
	 * This method returns true if the items has atleast one hot food item in
	 * it.
	 * 
	 * @see com.customer.bill.service.MenuItemService#hasAtleastOneHotFoodItem()
	 */
	@Override
	public boolean hasAtleastOneHotFoodItem(List<MenuItem> items) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		return items.stream().anyMatch(item -> item.getItemType().equals(ItemType.HOTFOOD));
	}
}