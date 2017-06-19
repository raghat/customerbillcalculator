/**
 * 
 */
package com.customer.bill.client;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.customer.bill.model.ItemType;
import com.customer.bill.model.MenuItem;
import com.customer.bill.service.BillCalculatorService;

/**
 * @author raghav
 *
 */
public class BillCalculator {

	private static final Logger logger = getLogger(BillCalculator.class);
	private static final String RESOURCE_BUNDLE = "item-config";

	public static void main(String[] args) {
		String items[] = { "Cola", "SteakSandwich" };
		AnnotationConfigApplicationContext ctx = BillCalculatorContext.load();
		BillCalculatorService service = ctx.getBean(BillCalculatorService.class);
		ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE);
		List<MenuItem> itemList = new ArrayList<>();
		Arrays.asList(items).stream()
				.forEach(item -> itemList.add(new MenuItem(item, ItemType.valueOf(resourceBundle.getString(item)))));
		logger.info("Final price excluding service charge " + service.getTotalBillExcludingServiceCharge(itemList));
		logger.info("Final price including service charge " + service.getTotalBillIncludingServiceCharge(itemList));
	}
}