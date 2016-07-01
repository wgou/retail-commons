/**  
 * Project Name:retail-commons 
 * File Name:KeyValue.java  
 * Package Name:com.retail.common.db.ext    
 * Date:2016年3月23日下午8:58:53  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao.ext;

import java.io.Serializable;

/**  
 * 描述:<br/>扩展字段值<br/>  
 * ClassName: KeyValue <br/>  
 * date: 2016年3月23日 下午8:58:53 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class KeyValue<K,V> implements Serializable{

	/** 
	 * serialVersionUID:TODO TODO; 
	 */
	private static final long serialVersionUID = 1L;
	
  
   public KeyValue() {
		  
		
	}
   public KeyValue(K k, V v) {
		super();
		this.k = k;
		this.v = v;
	}
	private K k;
	private V v;
	public K getK() {
		return k;
	}
	public void setK(K k) {
		this.k = k;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	
	
}
