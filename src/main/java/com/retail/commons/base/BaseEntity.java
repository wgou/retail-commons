/**  
 * Project Name:retail-commons  
 * File Name:BaseEntity.java  
 * Package Name:com.retail.common.base 
 * Date:2016年3月22日下午1:23:57  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.base;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;

import com.retail.commons.dao.ext.Criteria;

/**  
 * 描述:<br/>实体类父类 <br/>  
 * ClassName: BaseEntity <br/>  
 * date: 2016年3月22日 下午1:23:57 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
@JsonAutoDetect(value=JsonMethod.FIELD, fieldVisibility=Visibility.ANY)
public class BaseEntity extends Criteria{

	/** 
	 * serialVersionUID:TODO TODO; 
	 */
	private static final long serialVersionUID = 1L;

}
