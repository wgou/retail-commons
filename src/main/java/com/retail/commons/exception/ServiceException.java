/**  
 * Project Name:retail-commons  
 * File Name:ServiceException.java  
 * Package Name:com.retail.common.exception  
 * Date:2016年3月24日上午10:26:02  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.exception;

import com.retail.commons.base.BaseException;

/**  
 * 描述:<br/>业务层异常处理 <br/>  
 * ClassName: ServiceException <br/>  
 * date: 2016年3月24日 上午10:26:02 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public final class ServiceException extends BaseException{
	 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 默认构造方法输出
	 */
	public ServiceException(){
		super();
	}
	/**
	 * 输出已知异常
	 * @param message 异常信息
	 */
	public ServiceException(String message){
		super(message);
	}
	/**
	 * 未知异常
	 * @param t
	 */
	public ServiceException(Throwable t){
		super(t);
	}
	/**
	 * 未知异常
	 * @param message 异常信息
	 * @param t 异常对象
	 */
	public ServiceException(String message,Throwable t){
		super(message, t);
	}
		
}
