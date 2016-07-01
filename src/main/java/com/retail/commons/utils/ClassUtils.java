/**  
 * Project Name:retail-commons  
 * File Name:ClassUtils.java  
 * Package Name:com.retail.commons.utils  
 * Date:2016年3月31日下午4:43:48  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: ClassUtils <br/>  
 * date: 2016年3月31日 下午4:43:48 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class ClassUtils {

	private static final String getPrefix = "^(?:get|is)"; 
	private static final String setPrefix = "set"; 
	
	/**
	 * getInvokeSetParamsBean:给对象set方法赋值 <br/>  
	 * @author gouwei  
	 * @param t
	 * @param setMethod
	 * @param value
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T>void getInvokeSetParamsBean(T t,Method setMethod,String value) throws IllegalAccessException,InvocationTargetException {
		Object parameter = null;
		Class<?> clazzParamType = setMethod.getParameterTypes()[0];
		if(clazzParamType == String.class){
			parameter = value;
		}else if(clazzParamType== Integer.class || clazzParamType ==int.class){
			parameter = Integer.parseInt(value);
		}else if(clazzParamType== Double.class || clazzParamType== double.class){
			parameter = Double.parseDouble(value);
		}else if(clazzParamType== Long.class || clazzParamType== long.class){
			parameter = Long.parseLong(value);
		}else if(clazzParamType== Float.class || clazzParamType== float.class){
			parameter = Float.parseFloat(value);
		}else if(clazzParamType== Short.class || clazzParamType== short.class){
			parameter = Short.valueOf(value);
		}else if(clazzParamType== Boolean.class || clazzParamType== boolean.class){
			parameter =Boolean.valueOf(value);
		}else if(clazzParamType== java.sql.Date.class){
			parameter =Date.valueOf(value);
		}else if(clazzParamType== Timestamp.class){
			parameter =Timestamp.valueOf(value);
		}else if(clazzParamType== Time.class){
			parameter =Time.valueOf(value);
		}else if(clazzParamType== BigDecimal.class){
			parameter =BigDecimal.valueOf(Long.parseLong(value));
		}
		setMethod.invoke(t, parameter);
	}
	
	/**
	 * getMethodMap:获取类的所有get方法. <br/>  
	 * @author gouwei  
	 * @param clazz
	 * @supperClass 是否加载父类的方法,不填参数.默认为false.不加载
	 * @return  Map<String, Method> key 方法属对应性名称, value 方法
	 */
	public static  Map<String, Method> getMethodMap(Class<?> clazz,boolean... supperClass ) {
		Method[] methods =null;
		if(supperClass.length ==0 || supperClass[0] == false)
			methods = clazz.getDeclaredMethods();
		else
			methods = clazz.getMethods();
		
		int initialCapacity = methods.length / 2;
		Map<String, Method> getMethodMap = new HashMap<String, Method>(initialCapacity + 1);
		for (Method method : methods) {
			String name = method.getName();
			if (isGetMethod(method) && isGetMethodParams(method)) {
				getMethodMap.put(toStandardFiledName(name), method);
			}
		}
		return getMethodMap;
	} 
	
	/**
	 * 
	 * setMethodMap:获取该类的set方法. <br/>  
	 *  
	 * @author gouwei  
	 * @param clazz
	 * @supperClass 是否加载父类的方法,不填参数.默认为false.不加载
	 * @return  Map<String, Method> key 方法属对应性名称, value 方法
	 */
	public static  Map<String, Method> setMethodMap(Class<?> clazz,boolean... supperClass ) {
		Method[] methods =null;
		if(supperClass.length ==0 || supperClass[0] == false)
			methods = clazz.getMethods();
		else
			methods = clazz.getDeclaredMethods();
		
		int initialCapacity = methods.length / 2;
		Map<String, Method> setMethodMap = new HashMap<String, Method>(initialCapacity);
		for (Method method : methods) {
			String name = method.getName();
			if (isSetMethod(method) && isSetMethodParams(method)) {
				setMethodMap.put(toStandardFiledName(name), method);
			}
		}
		return setMethodMap;
	} 
		
	//判断该方法是否为is/get方法
	private static boolean isGetMethod(Method method){
		return (method.getName().matches(getPrefix+".*") && !method.getName().matches(getPrefix+"$"));
	}
	//判断该is/get方法是否带有参数
	private static boolean isGetMethodParams(Method method){
		return method.getGenericParameterTypes().length == 0;
	}
	//判断该方法是否为set方法
	private static boolean isSetMethod(Method method){
		return (method.getName().startsWith(setPrefix) && !setPrefix.equals(method.getName()));
	}
	//判断set方法是否只具有一个参数
	private static boolean isSetMethodParams(Method method){
		return method.getGenericParameterTypes().length == 1;
	}
	//将方法名转化为属性
	private static String toStandardFiledName(String name) {
	    int subIndex = name.startsWith("is") ? 2 : 3;        
		String fieldname = name.substring(subIndex);
		return fieldname.substring(0, 1).toLowerCase() + fieldname.substring(1);
	} 
	//获得get方法的值
	public static Object getMethodValue(Object obj,Method method) throws IllegalArgumentException, IllegalAccessException, Exception{
		Object o = method.invoke(obj);
		return o;
	}
}
