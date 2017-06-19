/**
 * 
 */
package com.customer.bill.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.customer.bill.model.MenuItem;
import com.customer.bill.service.ServiceChargeService;

/**
 * @author raghav
 *
 */
public class ServiceChargeServiceImpl implements ServiceChargeService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.customer.bill.service.ServiceChargeService#getServiceCharge(java.util
	 * .List)
	 */
	@Override
	public BigDecimal getServiceCharge(List<MenuItem> items) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		return null;
	}

}
