/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.toptal.core.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.codehaus.plexus.util.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.toptal.core.NutritionixUtil;


/**
 *
 */
public class NutritionixTest
{

	private static String apiId = "ebe49aeb";
	private static String apiKey = "7da241ab7ac978223dab9b2c0a76be38";

	@Test
	public void testResults()
	{
		try
		{
			final String jsonResponse = NutritionixUtil.search("banana", apiId, apiKey);
			final JSONObject json = new JSONObject(jsonResponse);
			final JSONArray branded = json.getJSONArray(NutritionixUtil.BRANDED);

			assertEquals(true, branded.length() > 0);
		}
		catch (final Exception e)
		{
			fail("Exception thrown: " + e.getMessage());
		}
	}


	@Test
	public void testCalories()
	{
		try
		{
			final String jsonResponse = NutritionixUtil.search("banana", apiId, apiKey);
			final String calories = NutritionixUtil.parseJsonCalories(jsonResponse);

			assertEquals(true, Integer.valueOf(calories) > 0);
		}
		catch (final Exception e)
		{
			fail("Exception thrown: " + e.getMessage());
		}
	}



	@Test
	public void testPhotoRetrieval()
	{
		try
		{
			final String jsonResponse = NutritionixUtil.search("banana", apiId, apiKey);
			final String photoUrl = NutritionixUtil.parseJsonPhoto(jsonResponse);

			assertEquals(true, StringUtils.isNotBlank(photoUrl) && photoUrl.contains("http"));
		}
		catch (final Exception e)
		{
			fail("Exception thrown: " + e.getMessage());
		}
	}

}
