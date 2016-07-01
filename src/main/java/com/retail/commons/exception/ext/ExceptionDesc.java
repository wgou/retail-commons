/**  
 * Project Name:retail-commons  
 * File Name:ExceptionDesc.java  
 * Package Name:com.retail.commons.exception.ext  
 * Date:2016年3月24日下午2:42:25  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.exception.ext;

import java.io.Serializable;

/**  
 * 描述:<br/>异常描述对象 <br/>  
 * ClassName: ExceptionDesc <br/>  
 * date: 2016年3月24日 下午2:42:25 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class ExceptionDesc implements Serializable{
	/** 
	 * serialVersionUID:TODO TODO; 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 异常系统
	 */
	private String exSystem;
	/**
	 * 异常目标对象
	 */
	private String exTragetObject;
	/**
	 * 异常代理对象
	 */
	private String extProxyObject;
	/**
	 * 异常方法
	 */
	private String exMethod;
	/**
	 * 异常方法参数
	 */
	private Object[] exMethodParams;
	/**
	 * 抛出异常
	 */
	private String exMessage;
	/**
	 * 异常详细信息
	 */
	private String exMessageDetail;
	
	
	public ExceptionDesc() {
		super();  
		
	}
	public ExceptionDesc(String exSystem, String exTragetObject,
			String extProxyObject, String exMethod, Object[] exMethodParams,
			String exMessage, String exMessageDetail) {
		super();
		this.exSystem = exSystem;
		this.exTragetObject = exTragetObject;
		this.extProxyObject = extProxyObject;
		this.exMethod = exMethod;
		this.exMethodParams = exMethodParams;
		this.exMessage = exMessage;
		this.exMessageDetail = exMessageDetail;
	}
	public String getExSystem() {
		return exSystem;
	}
	public void setExSystem(String exSystem) {
		this.exSystem = exSystem;
	}
	public String getExTragetObject() {
		return exTragetObject;
	}
	public void setExTragetObject(String exTragetObject) {
		this.exTragetObject = exTragetObject;
	}
	public String getExtProxyObject() {
		return extProxyObject;
	}
	public void setExtProxyObject(String extProxyObject) {
		this.extProxyObject = extProxyObject;
	}
	public String getExMethod() {
		return exMethod;
	}
	public void setExMethod(String exMethod) {
		this.exMethod = exMethod;
	}
	public Object[] getExMethodParams() {
		return exMethodParams;
	}
	public void setExMethodParams(Object[] exMethodParams) {
		this.exMethodParams = exMethodParams;
	}
	public String getExMessage() {
		return exMessage;
	}
	public void setExMessage(String exMessage) {
		this.exMessage = exMessage;
	}
	public String getExMessageDetail() {
		return exMessageDetail;
	}
	public void setExMessageDetail(String exMessageDetail) {
		this.exMessageDetail = exMessageDetail;
	}
	
	public String toJsonString(){
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"").append("exMethod").append("\"").append(getExMethod()).append("\"");
		sb.append("\"").append("exMethodParams").append("\"").append(getExMethodParams()).append("\"");
		sb.append("\"").append("extProxyObject").append("\"").append(getExtProxyObject()).append("\"");
		sb.append("\"").append("exTragetObject").append("\"").append(getExTragetObject()).append("\"");
		sb.append("}");
		return sb.toString();
	}
	
}
