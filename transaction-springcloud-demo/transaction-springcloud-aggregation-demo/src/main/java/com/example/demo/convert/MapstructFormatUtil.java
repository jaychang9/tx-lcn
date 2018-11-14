package com.example.demo.convert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zj
 * @date 2018/5/14 下午2:41
 * @description
 */

public class MapstructFormatUtil {

	public static List<String> jsonStrToStringArrayFormat(String json) {
		List<String> list;
		try {
			list = JSON.parseArray(json,String.class);
		} catch (JSONException e){
			return new ArrayList<>();
		}
		return list;
	}

	public static String dateToTimestampStrFormat(Date date) {
		return date != null ? date.getTime() + "" : "";
	}

}
