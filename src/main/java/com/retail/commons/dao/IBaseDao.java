/**  
 * Project Name:retail-commons   
 * File Name:IBaseDao.java  
 * Package Name:com.retail.common.db 
 * Date:2016年3月22日下午3:26:14  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao;

import java.util.List;
import java.util.Map;

import com.retail.commons.dao.ext.Criteria;

/**  
 * 描述:<br/>数据库操作接口 <br/>  
 * ClassName: IBaseDao <br/>  
 * date: 2016年3月22日 下午3:26:14 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public interface IBaseDao {
	
	public static final String SQL_SELECT = "select";
	public static final String SQL_UPDATE = "update";
	public static final String SQL_DELETE = "delete";
	public static final String SQL_INSERT = "insert";
	public static final String SQL_COUNT = "count";
	public static final String SQL_BATCH = "Batch";
	public static final String SQL_ONE = "One";
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final String IBATIS_PROPERYTY_PREFIX = "_";
	
	/**
	 * selectCount:查询条数 <br/>  
	 * @author gouwei  
	 * @param statement Mapper.xml中映射ID
	 * @param params  Criteria 对象 
	 * @return 查询结果对象
	 */
	public  <T extends Criteria>Long selectCount(String statement,T t) ;
	
	/**
	 * find:返回指定对象 <br/>  
	 * @author gouwei  
	 * @param statement Mapper.xml中映射ID
	 * @param params 
	 * 			 Criteria 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @return 查询结果对象
	 */
	public <T>T find(String statement,Criteria criteria);
	/**
	 * select:查询数据库对象 <br/>  
	 * @author gouwei  
	 * @param statement Mapper.xml中映射ID
	 * @param params  Criteria 对象 
	 * @return 查询结果对象
	 */
	public  <T extends Criteria>T select(String statement,T t) ;
	
	/**
	 * select:查询数据库对象 <br/>  
	 * @author gouwei  
	 * @param statement Mapper.xml中映射ID
	 * @param params  Criteria 对象 
	 * @return 查询结果List<T>对象
	 */
	public  <T extends Criteria>List<T> selectList(String statement,T t) ;
	
	
	/**
	 * selectMap:将查询结果组合为map对象返回. 当多表联查且没有对象接收查询结果时使用<br/>  
	 * @author gouwei  
	 * @param statement Mapper.xml中映射ID
	 * @param params  Criteria 对象 
	 * @return 查询结果的Map对象
	 */
	public  <K, V>Map<K,V> selectMap(String statement,String mapKey,Criteria t) ;

	/**
	 * update:修改对象<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params  Criteria 对象 
	 * @return 修改结果
	 */
	public  <T extends Criteria>int update(String statement,T t);
	
	
	
	/**
	 * insert:插入一个对象<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params  Criteria 对象 
	 * @return 插入成功条数
	 */
	public  <T extends Criteria>int insert(String statement,T t);
	
	/**
	 * insert:批量插入对象,在mapper中使用foreach 循环取出数据<br/>
	 * sql： insert into xx(xxx,xxx,xxx) values (xx,xx,xxx),(xxx,xxx,xxxx)
	 * @author gouwei  
	 * @param statement
	 * @param params 
	 *  		Criteria 对象 集合
	 * @return 插入成功条数
	 */
	public  <T extends Criteria>int insert(String statement,List<T> list);
	
	/**
	 * delete:删除一个对象<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params 
	 *  		Criteria 对象 
	 * @return 删除成功条数
	 */
	public  <T extends Criteria>int delete(String statement,T t);
	
	/**
	 * delete:批量删除对象,使用方式在Mapper中循环list,采用in方式删除<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params 
	 *  		Object 对象 
	 * @return 删除成功条数
	 */
	public  <T>int delete(String statement,List<T> list);
	
	
}
