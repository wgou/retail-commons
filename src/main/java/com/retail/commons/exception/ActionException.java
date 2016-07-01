/**  
 * Project Name:retail-commons  
 * File Name:ActionException.java  
 * Package Name:com.retail.common.exception  
 * Date:2016年3月24日上午10:27:52  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.exception;

import com.retail.commons.base.BaseException;

/**  
 * 描述:<br/>Action异常处理 <br/>  
 * ClassName: ActionException <br/>  
 * date: 2016年3月24日 上午10:27:52 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class ActionException extends BaseException{
	 
	private static final long serialVersionUID = 1L;
	
	/**
	 * 默认构造方法输出
	 */
	public ActionException(){
		super();
	}
	/**
	 * 输出已知异常
	 * @param message 异常信息
	 */
	public ActionException(String message){
		super(message);
	}
	/**
	 * 未知异常
	 * @param t
	 */
	public ActionException(Throwable t){
		super(t);
	}
	/**
	 * 未知异常
	 * @param message 异常信息
	 * @param t 异常对象
	 */
	public ActionException(String message,Throwable t){
		super(message, t);
	}
		
}

