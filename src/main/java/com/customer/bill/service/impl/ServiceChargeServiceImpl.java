/**
 * 
 */
package com.customer.bill.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.bill.model.MenuItem;
import com.customer.bill.service.MenuItemService;
import com.customer.bill.service.ServiceChargeService;

/**
 * @author raghav
 *
 */
@Service
public class ServiceChargeServiceImpl implements ServiceChargeService {

	private MenuItemService menuItemService;

	@Autowired
	public ServiceChargeServiceImpl(MenuItemService menuItemService) {
		this.menuItemService = Validate.notNull(menuItemService);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.customer.bill.service.ServiceChargeService#getServiceCharge(java.util
	 * .List)
	 */
	@Override
	public BigDecimal getServiceCharge(List<MenuItem> items, BigDecimal totalPrice) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		BigDecimal serviceCharge = BigDecimal.ZERO;
		if (menuItemService.hasAtleastOneHotFoodItem(items)) {
			// service charge is 20% of total price.
			serviceCharge = totalPrice.divide(BigDecimal.TEN).multiply(new BigDecimal("2"));
			if (serviceCharge.compareTo(ServiceChargeService.MAX_SERVICE_CHARGE) > 0) {
				return ServiceChargeService.MAX_SERVICE_CHARGE;
			} else {
				return serviceCharge;
			}
		} else if (menuItemService.hasAtleastOneFoodItem(items)) {
			// if the logic hits this block then there is exactly one food item
			// with no hot food item but can have drinks or not
			serviceCharge = totalPrice.divide(BigDecimal.TEN);
		}
		// All drinks. no need to check for hasAllDrinks.
		return serviceCharge;
	}
}