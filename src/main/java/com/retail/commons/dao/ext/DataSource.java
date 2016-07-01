/**  
 * Project Name:retail-commons  
 * File Name:TableName.java  
 * Package Name:com.retail.common.db.ext  
 * Date:2016年3月23日下午5:39:17  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao.ext;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
 * 描述:<br/>数据源注解 <br/> 
 * 使用方式，在dao层我们用此注解来区分 当前dao使用的数据源 
 * 组件提供ContextTypeHandler.MYSQL,ContextTypeHandler.ORACLE,ContextTypeHandler.SQLSERVER
 * 即spring配置中我们配置多数据源的方式：
 * 	<property name="targetSqlSessionFactory">
        <map>     
            <entry value-ref="mysqlSqlSessionFactory" key="mysql"/>
            <entry value-ref="mysqlSqlSessionFactory" key="sqlserver"/>
            <entry value-ref="oracleSqlSessionFactory" key="oracle"/>
        </map> 
    </property>
    <property name="defaultTargetSqlSessionFactory" ref="oracleSqlSessionFactory"/>
 * 当然用户任然可以自定义数据源名称,但是需要在此注解中给出数据源的key
 * ClassName: TableName <br/>  
 * date: 2016年3月23日 下午5:39:17 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DataSource {

	public String value();
	
}
