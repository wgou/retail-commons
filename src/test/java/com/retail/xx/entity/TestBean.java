/**  
 * Project Name:orm-core  
 * File Name:TestBean.java  
 * Package Name:com.retail.orm.core  
 * Date:2016年3月22日下午3:06:20  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.xx.entity;

import com.retail.commons.base.BaseEntity;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: TestBean <br/>  
 * date: 2016年3月22日 下午3:06:20 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class TestBean extends BaseEntity{

	/** 
	 * serialVersionUID:TODO TODO; 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String addre;
	private String phone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddre() {
		return addre;
	}
	public void setAddre(String addre) {
		this.addre = addre;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	/**  
	 * TODO 简单描述该方法的实现功能.  
	 * @see java.lang.Object#toString()  
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("id").append(":").append(getId()).append(",");
		sb.append("name").append(":").append(getName()).append(",");
		sb.append("addre").append(":").append(getAddre()).append(",");
		sb.append("phone").append(":").append(getPhone());
		sb.append("}");
		return sb.toString();
		
	}
}
