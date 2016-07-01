package com.retail.commons.utils;
/**
 * UUID32生成
 * @author 苟伟
 *
 */
public class UUID {
	public static String getUUID32(){
		String uuid = java.util.UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
	
}
