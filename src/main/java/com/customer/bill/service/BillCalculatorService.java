/**
 * 
 */
package com.customer.bill.service;

import java.math.BigDecimal;
import java.util.List;

import com.customer.bill.model.MenuItem;

/**
 * @author raghav
 *
 */
public interface BillCalculatorService {
	public BigDecimal getTotalBillExcludingServiceCharge(List<MenuItem> items);

	public BigDecimal getTotalBillIncludingServiceCharge(List<MenuItem> items, BigDecimal totalPrice);
}
