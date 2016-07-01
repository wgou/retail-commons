package com.retail.commons.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 描述:<br/>Json工具<br/>  
 * ClassName: JsonUtils <br/>  
 * date: 2016年3月24日 下午3:51:39 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version
 */
public class JsonUtils {

	/** 日志生成器 */
	protected static Logger log = Logger.getLogger(JsonUtils.class);
	/** jackson的解析实例 */
	static ObjectMapper om = new ObjectMapper();
	static{
		//忽略掉不认识的属性
		om.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	// static XmlMapper xml = new XmlMapper();
	/**
	 * 从一个JSON 对象字符格式中得到一个java对象 说明：Bean的无参构造函数一定要写, 否则会报:
	 * net.sf.json.JSONException: java.lang.NoSuchMethodException
	 * @param <T>
	 * 
	 * @param jsonString
	 * @param pojoCalss
	 * @return
	 */
	public static <T> T getObjectFromJsonString(String jsonString,
			Class<T> pojoCalss) {
		T pojo = null;
		// 传统json的实现,嵌套解析会有问题
		// JSONObject jsonObject = JSONObject.fromObject(jsonString);
		// pojo = JSONObject.toBean(jsonObject, pojoCalss);
		try {
			pojo = om.readValue(jsonString, pojoCalss);
		} catch (JsonParseException e) {
			log.error("json解析异常,jsonString="+jsonString, e);
		} catch (JsonMappingException e) {
			log.error("jsonMapping解析异常,msg="+e.getLocalizedMessage(), e);
		} catch (IOException e) {
			log.error("json输出IO异常,msg="+e.getLocalizedMessage(), e);
		}
		return pojo;
	}

	/**
	 * 从json HASH表达式中获取一个map
	 * 
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMapFromJsonString(String jsonString) {
		return getObjectFromJsonString(jsonString, Map.class);
	}


	/**
	 * 从Map对象得到Json字串
	 * 
	 * @param map
	 * @return
	 */
	public static String getJsonStringFromMap(Map<?,?> map) {
		return getJsonStringFromObject(map);
	}

	/**
	 * 用JSONStringer构造一个JsonString
	 * 
	 * @param m
	 * @return
	 */
	public static String getJsonStringFromObject(Object obj) {
		StringWriter sw = new StringWriter();
		try {
			om.writeValue(sw, obj);
		} catch (JsonGenerationException e) {
			log.error("json解析异常,msg="+e.getLocalizedMessage(), e);
		} catch (JsonMappingException e) {
			log.error("jsonMapping解析异常,msg="+e.getLocalizedMessage(), e);
		} catch (IOException e) {
			log.error("json输出IO异常,msg="+e.getLocalizedMessage(), e);
		}
		return sw.toString();
	}

}
