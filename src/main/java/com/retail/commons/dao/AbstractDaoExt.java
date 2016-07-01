/**  
 * Project Name:retail-commons   
 * File Name:AbstractDaoExt.java  
 * Package Name:com.retail.common.db   
 * Date:2016年3月23日下午5:50:33  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.retail.commons.dao.ext.Criteria;

/**  
 * 描述:<br/>数据库操作抽象类<br/>  
 * ClassName: AbstractDaoExt <br/>  
 * date: 2016年3月23日 下午5:50:33 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public abstract class AbstractDaoExt extends SqlSessionDaoSupport implements IBaseDao {
	
	/**
	 * selectCount:查询条数 <br/>  
	 * @author gouwei  
	 * @param statement Mapper.xml中映射ID
	 * @param params 
	 * 			 Criteria 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @return 查询结果对象
	 */
	@Override
	public <T extends Criteria>Long selectCount(String statement,T t) {
		Long count = getSqlSession().selectOne(statement, t);
	    return count ;
	}
	
	/**
	 * find:返回指定对象 <br/>  
	 * @author gouwei  
	 * @param statement Mapper.xml中映射ID
	 * @param params 
	 * 			 Criteria 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @return 查询结果对象
	 */
	public <T>T find(String statement,Criteria criteria){
		T t = getSqlSession().selectOne(statement,criteria);
		return t;
	}
	
	/**
	 * selectOne:数据库查询一个对象 <br/>  
	 * @author gouwei  
	 * @param statement Mapper.xml中映射ID
	 * @param params 
	 * 			 Criteria 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @return 查询结果对象
	 */
	@Override
	public <T extends Criteria>T select(String statement,T t) {
		T entity = getSqlSession().selectOne(statement,t);
		return entity;
	}
	
	/**
	 * selectList:查询对象集合 <br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params  Criteria 对象 
	 * @param mapKey 你想用那个字段的值来作为返回map的key
	 * @return 查询结果List集合
	 */
	@Override
	public <T extends Criteria>List<T> selectList(String statement,T t)  {
		List<T> list = getSqlSession().selectList(statement,t);
		return list;
	}
	
	/**
	 * selectMap:查询对象集合 <br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params  Criteria 对象 
	 * @param mapKey 你想用那个字段的值来作为返回map的key
	 * @return 查询结果Map集合[{key:{id:xx,name:xxx}},{key:{id:xx,name:xxx}},]
	 */
	@Override
	public <K, V>Map<K,V> selectMap(String statement, String mapKey,Criteria t) {
		Map<K,V> map = getSqlSession().selectMap(statement,t,mapKey);
		return map;
	}

	/**
	 * update:修改对象<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params 
	 *  		Criteria 对象 
	 * @return 修改结果
	 */
	public <T extends Criteria>int update(String statement,T t){
		return getSqlSession().update(statement, t);
	}
 
	
	/**
	 * insert:插入一个对象<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params 
	 *  		Criteria 对象 
	 * @return 插入成功条数
	 */
	public  <T extends Criteria>int insert(String statement,T t)  {
		return getSqlSession().insert(statement, t);
	}
	
	
	/**
	 * insert:批量插入对象,在mapper中使用foreach 循环取出数据<br/>
	 * sql： insert into xx(xxx,xxx,xxx) values (xx,xx,xxx),(xxx,xxx,xxxx)
	 * @author gouwei  
	 * @param statement
	 * @param params 
	 *  		Criteria 对象 集合
	 * @return 插入成功条数
	 */
	public  <T extends Criteria>int insert(String statement,List<T> list)  {
		return getSqlSession().insert(statement, list);
	}

   /**
	 * delete:删除一个对象<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params 
	 *  		Criteria 对象 
	 * @return 删除成功条数
	 */
	public  <T extends Criteria>int delete(String statement,T t)  {
		return getSqlSession().delete(statement, t);
	}
		
	/**
	 * delete:批量删除对象,使用方式在Mapper中循环list,采用in方式删除<br/> 
	 * @author gouwei  
	 * @param statement
	 * @param params List<Object>对象
	 * @return 删除成功条数
	 */
	public  <T>int delete(String statement,List<T> list)  {
		return getSqlSession().delete(statement, list);
	}

}
