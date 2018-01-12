package net.util;

//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;

import com.google.gson.Gson;

public class JSONUtils {

	public static <T> T fromJson(Gson jsonObj, Class<T> typeOfT){
		if(null==jsonObj){
			return null;
		}
		return fromJson(jsonObj.toString(),typeOfT);
	}
	public static <T> T fromJson(String jsonString, Class<T> typeOfT){
		if(null==jsonString){
			return null;
		}
		Gson gson=new Gson();
		return (T)gson.fromJson(jsonString, typeOfT);
	}
	public static  <T> String toJson(T obj){
		if(obj==null){
			return "";
		}
		Gson gson=new Gson();
		return gson.toJson(obj);
	}
	
//	public static String getString(Gson json, String name){
//		String content = null;
//		try {
//			content = json.getString(name);
//		} catch (JSONException e) {
//		}
//		return content;
//	}
//
//	public static int getInt(JSONObject json, String name){
//		int content = 0;
//		try {
//			content = json.getInt(name);
//		} catch (JSONException e) {
//		}
//		return content;
//	}
//
//	public static int getInt(JSONArray json, int index){
//        int content = 0;
//        try {
//            content = json.getInt(index);
//        } catch (JSONException e) {
//        }
//        return content;
//    }
//
//	public static long getLong(JSONArray json, int index){
//        long content = 0;
//        try {
//            content = json.getInt(index);
//        } catch (JSONException e) {
//        }
//        return content;
//    }
//
//	public static String getString(JSONArray json, int index){
//        String content = "";
//        try {
//            content = json.getString(index);
//        } catch (JSONException e) {
//        }
//        return content;
//    }
//
//	public static boolean getBoolean(JSONObject json, String name){
//		boolean content = false;
//		try {
//			content = json.getBoolean(name);
//		} catch (JSONException e) {
//		}
//		return content;
//	}
//
//	public static JSONArray getJSONArray(JSONObject json, String name){
//		JSONArray content = null;
//		try {
//			content = json.getJSONArray(name);
//		} catch (JSONException e) {
//		}
//		return content;
//	}
//
//	public static String getJSONString(JSONObject json, String name){
//	    String content = null;
//        try {
//            content = json.getString(name);
//        } catch (JSONException e) {
//        }
//        return content;
//    }
//
//	public static JSONObject getJSONObject(JSONObject json, String name){
//		JSONObject content = null;
//		try {
//			content = json.getJSONObject(name);
//		} catch (JSONException e) {
//		}
//		return content;
//	}
//
//	public static JSONObject getJSONObject(JSONArray json, int index){
//		JSONObject content = null;
//        try {
//            content = json.getJSONObject(index);
//        } catch (JSONException e) {
//        }
//		return content;
//	}
//
//	public static long getLong(JSONObject json, String name){
//		long content = 0;
//		try {
//			content = json.getLong(name);
//		} catch (JSONException e) {
//		}
//		return content;
//	}
//
//	public static Double getDouble(JSONObject json, String name){
//		Double content = 0.0;
//		try {
//			content = json.getDouble(name);
//		} catch (JSONException e) {
//		}
//		return content;
//	}
}
