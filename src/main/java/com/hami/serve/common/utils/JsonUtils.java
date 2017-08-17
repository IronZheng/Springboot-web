package com.hami.serve.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.Type;
import java.util.List;

/**
 * json工具类
 * 
 * @author lsquan
 *
 */
public class JsonUtils {
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	private static Gson gsonByExpose = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
			.setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	public static String toJson(Object obj, Gson gson) {
		return gson.toJson(obj);
	}

	public static String toJson(Object obj) throws Exception {
		return toJson(obj, gson);
	}

	public static String toJsonByExpose(Object obj) throws Exception {
		return toJson(obj, gsonByExpose);
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromJson(String json, Class<?> clazz, Gson gson) throws Exception {
		if (json.startsWith("[")) {
			return gson.fromJson(json, getType(clazz));
		}
		return (T) gson.fromJson(json, clazz);
	}

	public static <T> T fromJson(String json, Class<?> clazz) throws Exception {
		return fromJson(json, clazz, gson);
	}

	public static <T> T fromJsonByExpose(String json, Class<?> clazz) throws Exception {
		return fromJson(json, clazz, gsonByExpose);
	}

	private static Type getType(Class<?> clazz) throws Exception {
		return $Gson$Types.newParameterizedTypeWithOwner(null, List.class, new Type[] { clazz });
	}

	public static String formatJson(String json) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}
}