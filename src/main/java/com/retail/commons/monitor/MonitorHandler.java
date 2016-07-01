/**  
 * Project Name:retail-commons  
 * File Name:MonitorsHandler.java  
 * Package Name:com.retail.commons.monitor  
 * Date:2016年4月8日下午5:15:07  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.monitor;

import com.dmall.monitor.sdk.Monitor;
import com.dmall.monitor.sdk.method.MethodInfo;

/**  
 * 描述:<br/>监控扩展 <br/>  
 * ClassName: MonitorsHandler <br/>  
 * date: 2016年4月8日 下午5:15:07 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class MonitorHandler {
	/**
	 * 说明：参数alarmKey在【自定义报警】管理中创建的监控点编码，参数content报警通知内容,
	 * 通知内容不宜过长，如果只发邮件，字数必须在1000字以内，如果是短信，内容必须控制在500以内。
	 * @author gouwei  
	 * @param alarmKey
	 * @param content
	 */
	public static void alarm(final String alarmKey, final String content){
		Monitor.alarm(alarmKey,content);
	}
	/**
	 * 方法开始调用监控接口
	 * @param monitoryKey 
	 * 	getClass().getDeclaringClass().getName() + "."+targetMethod.getName();
	 */
	public static MethodInfo methodStart(String monitoryKey){
		MethodInfo methodInfo = Monitor.methodStart(monitoryKey);
		return methodInfo;
	}
	
	/**
	 * 方法结束调用监控接口
	 * @param methodInfo 
	 */
	public static void methodFinish(MethodInfo methodInfo){
		 Monitor.methodFinish(methodInfo);
	}
	
	/**
	 * 方法异常调用监控接口
	 * @param methodInfo 
	 */
	public static void methodFail(MethodInfo methodInfo){
		 Monitor.methodFail(methodInfo);
	}
	
	
}
