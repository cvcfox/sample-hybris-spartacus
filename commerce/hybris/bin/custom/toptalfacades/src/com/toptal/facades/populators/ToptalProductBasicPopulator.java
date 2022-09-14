/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.toptal.facades.populators;

import de.hybris.platform.commercefacades.product.converters.populator.ProductBasicPopulator;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


/**
 *
 */
public class ToptalProductBasicPopulator<SOURCE extends ProductModel, TARGET extends ProductData>
		extends ProductBasicPopulator<SOURCE, TARGET>
{

	@Override
	public void populate(final SOURCE productModel, final TARGET productData) throws ConversionException
	{
		super.populate(productModel, productData);
		productData.setCalories(productModel.getCalories());
		productData.setExtImg(productModel.getExtImg());
	}





}
