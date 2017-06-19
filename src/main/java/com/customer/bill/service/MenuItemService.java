/**
 * 
 */
package com.customer.bill.service;

import java.util.List;

import com.customer.bill.model.MenuItem;

/**
 * @author raghav
 *
 */
public interface MenuItemService {
	public boolean hasAllDrinks(List<MenuItem> items);

	public boolean hasAtleastOneFoodItem(List<MenuItem> items);

	public boolean hasAtleastOneHotFoodItem(List<MenuItem> items);
}
