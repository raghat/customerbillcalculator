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
public interface ServiceChargeService {
	public BigDecimal getServiceCharge(List<MenuItem> items);
}
