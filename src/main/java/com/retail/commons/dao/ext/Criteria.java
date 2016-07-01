/**  
 * Project Name:retail-commons  
 * File Name:Criteric.java  
 * Package Name:com.retail.common.db.ext  
 * Date:2016年3月23日下午8:57:24  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao.ext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnore;

/**  
 * 描述:<br/>公共dao层扩展字段 <br/>  
 * ClassName: Criteric <br/>  
 * date: 2016年3月23日 下午8:57:24 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class Criteria implements Serializable{
	
	/** 
	 * serialVersionUID:TODO TODO; 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 排序方向-升序
     */
    public static final String SORT_DIRECTION_ASC = "ASC";
    /**
     * 排序方向-降序
     */
    public static final String SORT_DIRECTION_DESC = "DESC";
    
    /**
     * 排序规则
     */
    @JsonIgnore
    private List<KeyValue<String, String>> orderByItem;
    
    /**
     * 扩展字段
     */
    @JsonIgnore
    private Map<String,Object> extField;

	 
    /**
     * 添加扩展字段
     */
    @SuppressWarnings("unchecked")
    public <T extends Criteria> T addExtField(String key,Object value){
    	if(extField == null){
    		extField = new HashMap<String,Object>();
    	}
    	extField.put(key, value);
    	return (T)this;
    }


	public List<KeyValue<String, String>> getOrderByItem() {
		return orderByItem;
	}


	public void setOrderByItem(List<KeyValue<String, String>> orderByItem) {
		this.orderByItem = orderByItem;
	}


	public Map<String, Object> getExtField() {
		return extField;
	}


	public void setExtField(Map<String, Object> extField) {
		this.extField = extField;
	}
    
    

}
