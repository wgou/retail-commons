/**  
 * Project Name:retail-commons  
 * File Name:ChginstDao.java  
 * Package Name:com.retail.xx.dao  
 * Date:2016年4月19日下午7:49:26  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.xx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.retail.commons.base.BaseDao;
import com.retail.commons.dao.ext.DAOProperties;
import com.retail.commons.dao.ext.DataSource;
import com.retail.xx.entity.Chginst;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: ChginstDao <br/>  
 * date: 2016年4月19日 下午7:49:26 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
@DAOProperties(tableName="CHGINST",nameSpace="namespace_chginst")
@DataSource("mysql1")
@Repository
public class ChginstDao extends BaseDao{

	public List<Chginst> getList(){
		return this.findList();
	}
}
