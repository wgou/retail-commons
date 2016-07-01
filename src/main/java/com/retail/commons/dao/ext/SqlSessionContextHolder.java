/**  
 * Project Name:retail-commons  
 * File Name:SqlSessionContextHolder.java  
 * Package Name:com.retail.commons.dao.ext  
 * Date:2016年4月19日下午3:40:33  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao.ext;


/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: SqlSessionContextHolder <br/>  
 * date: 2016年4月19日 下午3:40:33 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class SqlSessionContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
  
    public static void setDbType(String dataSourceKey) {  
        contextHolder.set(dataSourceKey);  
    }  
  
    public static String getDbType(){
    	return contextHolder.get();
    }
    
    public static void clearDbType() {
        contextHolder.remove();
    }
}
