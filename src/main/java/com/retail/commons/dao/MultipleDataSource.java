/**  
 * Project Name:retail-commons  
 * File Name:MultipleSqlSessionDaoSupport.java  
 * Package Name:com.retail.commons.dao  
 * Date:2016年4月19日下午4:27:59  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.retail.commons.dao.ext.SqlSessionContextHolder;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: MultipleSqlSessionDaoSupport <br/>  
 * date: 2016年4月19日 下午4:27:59 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

	/**  
	 * TODO 简单描述该方法的实现功能.  
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()  
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		  
		return SqlSessionContextHolder.getDbType();
	}

}
