/**  
 * Project Name:retail-commons  
 * File Name:ContextTypeHandler.java  
 * Package Name:com.retail.commons.dao.ext  
 * Date:2016年4月11日上午11:45:40  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao.ext;

/**  
 * 描述:<br/>多数据源链接信息保存描述 <br/>  
 * ClassName: ContextTypeHandler <br/>  
 * date: 2016年4月11日 上午11:45:40 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class DataSourceType {

	public static final String  MYSQL = "mysql";
	public static final String  SQLSERVER = "sqlserver";
	public static final String  ORACLE = "oracle";
	
	private static final ThreadLocal<String> tlContext = new ThreadLocal<String>();
	
	public static void setContextType(String dataSourceType){
		tlContext.set(dataSourceType);
	}
	public static String getContextType(){
		return tlContext.get();
	}
	public static void removeContextType(){
		tlContext.remove();
	}
}
