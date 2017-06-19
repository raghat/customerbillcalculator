/**
 * 
 */
package com.customer.bill.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.customer.bill.model.MenuItem;
import com.customer.bill.service.BillCalculatorService;

/**
 * @author raghav
 *
 */
public class BillCalculatorServiceImpl implements BillCalculatorService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.customer.bill.service.BillCalculatorService#
	 * getTotalBillExcludingServiceCharge(java.util.List)
	 */
	@Override
	public BigDecimal getTotalBillExcludingServiceCharge(List<MenuItem> items) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.customer.bill.service.BillCalculatorService#
	 * getTotalBillIncludingServiceCharge(java.util.List, java.math.BigDecimal)
	 */
	@Override
	public BigDecimal getTotalBillIncludingServiceCharge(List<MenuItem> items, BigDecimal totalPrice) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		return null;
	}

}
