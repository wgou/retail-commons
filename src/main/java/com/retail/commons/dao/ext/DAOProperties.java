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
 * 描述:<br/>公共dao层  注解 <br/>  
 * ClassName: TableName <br/>  
 * date: 2016年3月23日 下午5:39:17 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DAOProperties {

	public String nameSpace() default "";
	public String tableName() default "";
}
