/**  
 * Project Name:retail-commons  
 * File Name:DaoExceptionHandler.java  
 * Package Name:com.retail.common.exception.ext  
 * Date:2016年3月24日下午1:04:36  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao.ext;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**  
 * 描述:<br/>多数据源拦截器 <br/>  
 * <pre>
 * 	说明：
 * 		 对dao层所有方法进行拦截,对class 或者方法上的 DataSource 注解解析
 *    确定当前class 或 当前方法使用的是那个数据源
 * </pre>
 * ClassName: ProxyExceptionHandler <br/>  
 * date: 2016年3月24日 下午1:04:36 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class MultipleAopHandler {
	
	private Logger logger = Logger.getLogger(MultipleAopHandler.class);
	
	public Object selectDataType(ProceedingJoinPoint jp) throws Throwable{
		Method targetMethod  = ((MethodSignature)jp.getSignature()).getMethod();
		DataSource datasource = jp.getTarget().getClass().getAnnotation(DataSource.class);
		if(datasource !=null){
			SqlSessionContextHolder.setDbType(datasource.value());
			DataSource md = targetMethod.getAnnotation(DataSource.class);
			if(md!=null)
				SqlSessionContextHolder.setDbType(md.value());
		}
	    logger.debug("当前线程Thread:"+Thread.currentThread().getName()+" 当前的数据源 key is "+ SqlSessionContextHolder.getDbType());  
		try {
			Object obj = jp.proceed();
			return obj;
		} catch (Throwable e) {
			throw e;
		}finally{
			SqlSessionContextHolder.clearDbType();
		}
	}
	
		
	/**
	 * 检查方法是否需要监控
	 * FIXME 
	 * @param method
	 * @param target
	 * @return
	 */
	private boolean isCheckMethodByDataSource(Method method, Object target){
		DataSource datasource = target.getClass().getAnnotation(DataSource.class);
		return datasource !=null;
		
	}
	
}
