/**  
 * Project Name:retail-commons  
 * File Name:BaseException.java  
 * Package Name:com.retail.common.exception  
 * Date:2016年3月24日上午10:23:16  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.base;

/**  
 * 描述:<br/>异常基类 <br/>  
 * ClassName: BaseException <br/>  
 * date: 2016年3月24日 上午10:23:16 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class BaseException extends RuntimeException {

	/** 
	 * serialVersionUID:TODO TODO; 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 基本异常默认构造方法
	 */
	public BaseException() {
		super();
	}

	/**
	 * 基本异常构造函数
	 * @param message 异常信息
	 */
	public BaseException(String message) {
		super(message);
	}

	/**
	 * 基本异常构造函数
	 * @param message 异常信息
	 * @param newNested 异常信息对象
	 */
	public BaseException(String message, Throwable newNested) {
		super(message, newNested);
	}

	/**
	 * 基本异常构造函数
	 * @param newNested 异常信息对象
	 */
	public BaseException(Throwable newNested) {
		super(newNested);
	}

}
