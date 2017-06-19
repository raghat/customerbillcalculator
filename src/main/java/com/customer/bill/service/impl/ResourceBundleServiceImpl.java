/**
 * 
 */
package com.customer.bill.service.impl;

import java.util.ResourceBundle;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

import com.customer.bill.service.ResourceBundleService;

/**
 * @author raghav
 *
 */
@Component
public class ResourceBundleServiceImpl implements ResourceBundleService {
	private static final String RESOURCE_BUNDLE = "item-config";
	private final ResourceBundle resourceBundle;

	public ResourceBundleServiceImpl() {
		this.resourceBundle = Validate.notNull(ResourceBundle.getBundle(RESOURCE_BUNDLE));
	}

	@Override
	public String getConfigValue(String key) {
		if (resourceBundle.containsKey(key)) {
			return resourceBundle.getString(key);
		} else {
			throw new IllegalArgumentException("Item key not configured in the sytem");
		}
	}
}