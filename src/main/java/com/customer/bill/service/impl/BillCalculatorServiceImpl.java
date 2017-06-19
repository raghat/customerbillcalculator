/**
 * 
 */
package com.customer.bill.service.impl;

import static org.apache.commons.lang3.Validate.notNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.bill.model.MenuItem;
import com.customer.bill.service.BillCalculatorService;
import com.customer.bill.service.ResourceBundleService;
import com.customer.bill.service.ServiceChargeService;

/**
 * @author raghav
 *
 */
@Service
public class BillCalculatorServiceImpl implements BillCalculatorService {

	private final ResourceBundleService resourceBundleService;
	private final ServiceChargeService serviceChargeService;

	@Autowired
	public BillCalculatorServiceImpl(ServiceChargeService serviceChargeService,
			ResourceBundleService resourceBundleService) {
		this.serviceChargeService = notNull(serviceChargeService);
		this.resourceBundleService = notNull(resourceBundleService);
	}

	/*
	 * (non-Javadoc) Gives total price of the item excluding service charge.
	 * 
	 * @see com.customer.bill.service.BillCalculatorService#
	 * 
	 * getTotalBillExcludingServiceCharge(java.util.List)
	 */
	@Override
	public BigDecimal getTotalBillExcludingServiceCharge(List<MenuItem> items) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		BigDecimal totalBill = getTotalPrice(items);
		// rounding off to 2 decimal places
		totalBill.setScale(2, RoundingMode.HALF_EVEN);
		return totalBill;
	}

	/*
	 * (non-Javadoc) Gives total price of the item plus service charge.
	 * 
	 * @see com.customer.bill.service.BillCalculatorService#
	 * getTotalBillIncludingServiceCharge(java.util.List, java.math.BigDecimal)
	 */
	@Override
	public BigDecimal getTotalBillIncludingServiceCharge(List<MenuItem> items) {
		Validate.notEmpty(items, "Item collection cannot be null or empty");
		BigDecimal totalPrice = getTotalPrice(items);
		BigDecimal serviceCharge = serviceChargeService.getServiceCharge(items, totalPrice);
		BigDecimal totalBill = totalPrice.add(serviceCharge);
		// rounding off to 2 decimal places
		totalBill.setScale(2, RoundingMode.HALF_EVEN);
		return totalBill;
	}

	/*
	 * (non-Javadoc) Gives total price of the items
	 * 
	 * @see com.customer.bill.service.BillCalculatorService#
	 * getTotalPrice(java.util.List)
	 */
	private BigDecimal getTotalPrice(List<MenuItem> items) {
		BigDecimal totalPrice = items.stream().map(item -> item.getItemName() + "Price")
				.map(itemPriceKey -> resourceBundleService.getConfigValue(itemPriceKey)).map(BigDecimal::new)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		return totalPrice;
	}
}