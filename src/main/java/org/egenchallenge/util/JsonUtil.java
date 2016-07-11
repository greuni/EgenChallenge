package org.egenchallenge.util;

import org.egenchallenge.entity.User;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonUtil {

	public static String toJson(Object object)
	{
		return new Gson().toJson(object);
	}
	public static ResponseTransformer json()
	{
		return JsonUtil::toJson;
	}
	
	public static User fromJsonToUser(String json, Object classT)
	{
		return (User) new Gson().fromJson(json, classT.getClass());
		
	}
}
