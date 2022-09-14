/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.toptal.core.services.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.Locale;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.toptal.core.NutritionixUtil;
import com.toptal.core.services.ToptalNutritionixService;


public class DefaultToptalNutritionixService implements ToptalNutritionixService
{
	private static final Logger LOG = Logger.getLogger(DefaultToptalNutritionixService.class);

	@Resource(name = "configurationService")
	private ConfigurationService configurationService;

	@Resource(name = "modelService")
	private ModelService modelService;

	@Override
	public void populateNutritionix(final ProductModel productModel)
	{
		try
		{
			final String apiId = configurationService.getConfiguration().getString("nutritionix.api.id");
			final String apiKey = configurationService.getConfiguration().getString("nutritionix.api.key");

			final String jsonResponse = NutritionixUtil.search(productModel.getName(Locale.ENGLISH), apiId, apiKey);

			if (StringUtils.isNotBlank(jsonResponse))
			{
				productModel.setCalories(NutritionixUtil.parseJsonCalories(jsonResponse));
				productModel.setExtImg(NutritionixUtil.parseJsonPhoto(jsonResponse));
				modelService.save(productModel);
			}
		}
		catch (final Exception e)
		{
			LOG.error("Unable to get calories for product " + productModel.getCode() + ": " + e.getMessage());
		}

	}

}
