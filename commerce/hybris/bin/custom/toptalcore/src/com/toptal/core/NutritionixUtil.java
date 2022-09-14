/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.toptal.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.toptal.core.constants.ToptalcoreConstants;


/**
 *
 */
public class NutritionixUtil
{

	public static final String BRANDED = "branded";
	private static final String NF_CALORIES = "nf_calories";
	private static final String THUMB = "thumb";
	private static final String PHOTO = "photo";
	private static final String COMMON = "common";

	private NutritionixUtil()
	{

	}


	public static String parseJsonPhoto(final String jsonResponse)
	{

		final JSONObject json = new JSONObject(jsonResponse);
		final JSONArray branded = json.getJSONArray(COMMON);

		for (int i = 0; i < branded.length(); ++i)
		{
			final JSONObject jsonFood = (JSONObject) branded.get(i);
			if (jsonFood.has(PHOTO))
			{
				return jsonFood.getJSONObject(PHOTO).getString(THUMB);
			}
		}


		return null;
	}

	public static String parseJsonCalories(final String jsonResponse)
	{

		final JSONObject json = new JSONObject(jsonResponse);
		final JSONArray branded = json.getJSONArray(BRANDED);

		for (int i = 0; i < branded.length(); ++i)
		{
			final JSONObject jsonFood = (JSONObject) branded.get(i);
			if (jsonFood.has(NF_CALORIES))
			{
				return String.valueOf(jsonFood.getInt(NF_CALORIES));
			}
		}

		return null;
	}

	public static String search(final String productName, final String apiId, final String apiKey) throws Exception
	{
		String jsonResponse = null;

		final String url = ToptalcoreConstants.NUTRITIONIX_SEARCH_URL + productName.replace(" ", "+");

		final HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("x-app-id", apiId);
		con.setRequestProperty("x-app-key", apiKey);
		con.setConnectTimeout(2000);
		con.setReadTimeout(2000);

		final InputStream is = con.getInputStream();

		jsonResponse = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.joining("\n"));

		con.disconnect();

		return jsonResponse;
	}

}
