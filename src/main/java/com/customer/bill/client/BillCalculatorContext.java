/**
 * 
 */
package com.customer.bill.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author raghav
 *
 */
public class BillCalculatorContext {
	@Configuration
	@ComponentScan(basePackages = { "com.customer.bill.service.impl" })
	public static class ComponentScanConfig {
	}

	protected static AnnotationConfigApplicationContext loadAnnotationContext(Class<?> componentScanConfigClass) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(componentScanConfigClass);
		ctx.refresh();
		return ctx;
	}

	protected static AnnotationConfigApplicationContext load() {
		return loadAnnotationContext(ComponentScanConfig.class);
	}
}