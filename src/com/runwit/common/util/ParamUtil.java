package com.runwit.common.util;

import java.text.SimpleDateFormat;

public class ParamUtil {
	
	public static String getString(String str){
		if(str == null)
			return "";
		return str.trim();
	}
	
	public static String appendParam(String url, String paramName, String paramValue){
		int quesIdx = url.indexOf('?');
		if(quesIdx < 0)
			return url + "?" + paramName + "=" + paramValue;
		else
			return url + "&" + paramName + "=" + paramValue;
	}
	
	public static String parseDateTime(java.util.Date d, String pattern){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(d);
		}catch(Exception ex){
			ex.printStackTrace();
			return d.toString();
		}
	}
	

}
