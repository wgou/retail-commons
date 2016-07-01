/**  
 * Project Name:retail-commons  
 * File Name:ErpPrivilegeDao.java  
 * Package Name:com.retail.xx.dao  
 * Date:2016年4月11日下午1:16:23  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.xx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.retail.commons.base.BaseDao;
import com.retail.commons.dao.ext.DAOProperties;
import com.retail.commons.dao.ext.DataSource;
import com.retail.xx.entity.ErpPrivilege;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: ErpPrivilegeDao <br/>  
 * date: 2016年4月11日 下午1:16:23 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
@DAOProperties(tableName="erp_privilege",nameSpace="namespace_erpprivilege")
@DataSource("mysql1")
@Repository
public class ErpPrivilegeDao extends BaseDao{

	public List<ErpPrivilege> getErpList(){
		
		return this.findList();
	}
}
