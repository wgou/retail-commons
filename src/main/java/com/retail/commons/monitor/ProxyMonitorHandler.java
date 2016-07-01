/**  
 * Project Name:retail-commons  
 * File Name:DaoExceptionHandler.java  
 * Package Name:com.retail.common.exception.ext  
 * Date:2016年3月24日下午1:04:36  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.monitor;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.dmall.monitor.sdk.method.MethodInfo;

/**  
 * 描述:<br/>统一方法监控处理 <br/>  
 * <pre>
 * 	说明：
 * 		统一方法监控,主要适用于service的方法监控.
 * 		使用方式在需要监控的方法或者class上添加@minotor注解
 * 		如果在class上添加了注解,默认所有方法都将会被监控.如果在方法上添加@monitor(false) 则不会对方法进行监控
 * </pre>
 * ClassName: ProxyExceptionHandler <br/>  
 * date: 2016年3月24日 下午1:04:36 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class ProxyMonitorHandler {
	
	private Logger logger = Logger.getLogger(ProxyMonitorHandler.class);
	
	public Object watchMonitor(ProceedingJoinPoint jp) throws Throwable{
		Method targetMethod  = ((MethodSignature)jp.getSignature()).getMethod();
		boolean isMonitor = isCheckMethodByMonitor(targetMethod,jp.getTarget());
		String monitoryKey =targetMethod.getDeclaringClass().getName() + "."+targetMethod.getName();
		if(isMonitor){
			MethodInfo methodInfo = MonitorHandler.methodStart(monitoryKey);
			logger.info(String.format("方法监控%s", monitoryKey));
			try {
				Object obj = jp.proceed();
				return obj;
			} catch (Throwable e) {
				MonitorHandler.methodFail(methodInfo);
				throw e;
			}finally{
				MonitorHandler.methodFinish(methodInfo);
			}
		}else{
			try {
				Object obj = jp.proceed();
				return obj;
			} catch (Throwable e) {
				throw e;
			}
		}
	}
	
		
	/**
	 * 检查方法是否需要监控
	 * FIXME 
	 * @param method
	 * @param target
	 * @return
	 */
	private boolean isCheckMethodByMonitor(Method method, Object target){
		boolean isMonitor = false;
		com.retail.commons.monitor.ext.MethodMonitor miontor = target.getClass().getAnnotation(com.retail.commons.monitor.ext.MethodMonitor.class);
		com.retail.commons.monitor.ext.MethodMonitor m = method.getAnnotation(com.retail.commons.monitor.ext.MethodMonitor.class);
		if((m !=null && m.value())){//只要方法上存在且值为true.则监控 
			 isMonitor = true;
		}else if((m !=null && !m.value())){ //方法上存在,值为false 不监控
			isMonitor = false;
		}else if(m == null && (miontor !=null && miontor.value())){ //方法上不存在，class上存,且值为true在则监控
			isMonitor = true;
		}
		return isMonitor;
		
	}
	
}
