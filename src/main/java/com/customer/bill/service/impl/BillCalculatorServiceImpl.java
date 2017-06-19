/**
 * 
 */
package com.customer.bill.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.customer.bill.model.MenuItem;
import com.customer.bill.service.BillCalculatorService;

/**
 * @author raghav
 *
 */
public class BillCalculatorServiceImpl implements BillCalculatorService {

	/* (non-Javadoc)
	 * @see com.customer.bill.service.BillCalculatorService#getTotalBillExcludingServiceCharge(java.util.List)
	 */
	public BigDecimal getTotalBillExcludingServiceCharge(List<MenuItem> items) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.customer.bill.service.BillCalculatorService#getTotalBillIncludingServiceCharge(java.util.List, java.math.BigDecimal)
	 */
	public BigDecimal getTotalBillIncludingServiceCharge(List<MenuItem> items, BigDecimal totalPrice) {
		// TODO Auto-generated method stub
		return null;
	}

}
