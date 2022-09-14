/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.toptal.core.services;

import de.hybris.platform.core.model.product.ProductModel;


public interface ToptalNutritionixService
{
	/**
	 * Loads the Nutritionix information into the product if missing
	 */
	void populateNutritionix(ProductModel productModel);
}
