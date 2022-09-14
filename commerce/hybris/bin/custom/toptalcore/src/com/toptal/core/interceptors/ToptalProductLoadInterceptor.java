/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.toptal.core.interceptors;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.LoadInterceptor;

import javax.annotation.Resource;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.toptal.core.services.ToptalNutritionixService;


/**
 *
 */
public class ToptalProductLoadInterceptor implements LoadInterceptor<ProductModel>
{
	@Resource(name = "toptalNutritionixService")
	private ToptalNutritionixService toptalNutritionixService;

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;


	@Override
	public void onLoad(final ProductModel productModel, final InterceptorContext ctx) throws InterceptorException
	{

		final Boolean retrieveCalories = configurationService.getConfiguration().getBoolean("nutritionix.enable.calorie.retrieval",
				Boolean.FALSE);

		if (retrieveCalories && StringUtils.isEmpty(productModel.getCalories()))
		{
			toptalNutritionixService.populateNutritionix(productModel);
		}
	}

}
