/**  
 * Project Name:retail-commons  
 * File Name:Test.java  
 * Package Name:com.retail.common.base  
 * Date:2016年3月22日上午11:54:17  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.retail.commons.dao.AbstractDaoExt;
import com.retail.commons.dao.ext.Criteria;
import com.retail.commons.dao.ext.DAOProperties;
import com.retail.commons.dao.ext.PagedList;

/**  
 * 描述:<br/>封装mybatis数据库操作父类 <br/>  
 * ClassName: Test <br/>  
 * date: 2016年3月22日 上午11:54:17 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public  class BaseDao extends AbstractDaoExt {

	protected final String sql_select_one;			//selectOne_tablename
	protected final String sql_select;				//select_tablename
	protected final String sql_count;				//count_tableName
	protected final String sql_insert; 				//insert_tableName
	protected final String sql_insert_batch;		//insertBatch_tableName
	protected final String sql_update;				//update_tableName
    protected final String sql_update_batch;		//updateBatch_tableName
    protected final String sql_delete;				//delete_tableName
    protected final String sql_delete_batch;		//deleteBatch_tableName
    private final String nameSpace;					 
    private final String tableName;		
    
    public BaseDao() {
    	
    	//获取子类dao 操作注解属性
    	DAOProperties myTable = (DAOProperties) getClass().getAnnotation(DAOProperties.class);
        Assert.notNull(myTable);
        tableName = myTable.tableName();
        Assert.notNull(tableName,getClass().getName() + " @DAOProperties annotation tableName is null");
        String nameSpaceTmp = myTable.nameSpace();
        nameSpace = StringUtils.isEmpty(nameSpaceTmp) ? "" : nameSpaceTmp + ".";
        sql_select_one 	 = new StringBuffer().append(SQL_SELECT).append(SQL_ONE).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        sql_select 		 = new StringBuffer().append(SQL_SELECT).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        sql_count 		 = new StringBuffer().append(SQL_COUNT).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        sql_insert		 = new StringBuffer().append(SQL_INSERT).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        sql_insert_batch = new StringBuffer().append(SQL_INSERT).append(SQL_BATCH).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        sql_update 		 = new StringBuffer().append(SQL_UPDATE).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        sql_update_batch = new StringBuffer().append(SQL_UPDATE).append(SQL_BATCH).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        sql_delete 		 = new StringBuffer().append(SQL_DELETE).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        sql_delete_batch = new StringBuffer().append(SQL_DELETE).append(SQL_BATCH).append(IBATIS_PROPERYTY_PREFIX).append(tableName).toString();
        
    }
    
    /**
	 * selectCount:查询条数 <br/>  
	 * @author gouwei  
	 * @param params  Criteria 对象
	 * @return 查询结果对象
	 */
	public long findCount(Criteria criteria){
		Long count = getSqlSession().selectOne(addNameSpace(sql_count),criteria);
		 return count == null ? 0 : count.intValue();
	}
	
	/**
	 * selectOne:数据库查询对象 <br/>  
	 * @author gouwei  
	 * @param params  Criteria 对象 
	 * @return 查询结果对象
	 */
	public <T extends Criteria>T findOne(T t){
		Assert.notNull(t, "查询条件不能为空.");
		T entity = select(addNameSpace(sql_select_one),t);
		return entity;
	}
	
	/**
	 * selectList:数据库查询对象 <br/>  
	 * @author gouwei  
	 * @param params  Criteria 对象 
	 * @return 查询结果对象
	 */
	public <T extends Criteria>List<T> findList(){
		List<T> list = findList(null);
		return list;
	}
	/**
	 * selectList:查询对象集合 <br/>  
	 * @author gouwei  
	 * @param params 
	 * 			 Criteria 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @return 查询结果集合
	 */
	public <T extends Criteria>List<T> findList(T t){
		List<T> list = selectList(addNameSpace(sql_select),t);
		return list;
	}
	/**
	 * selectList:查询对象集合 <br/>  
	 * @author gouwei  
	 * @param params 
	 * 			 Criteria 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @param mapKey 你想用那个字段的值来作为返回map的key
	 * @return 查询结果Map集合[{key:{id:xx,name:xxx}},{key:{id:xx,name:xxx}},]
	 */
	public <K, V>Map<K,V> findMap(String mapKey,Criteria criteria){
		Map<K,V> map = selectMap(addNameSpace(sql_select),mapKey,criteria);
		return map;
	}
	/**
	 * selectPagedList:分页查询 
	 * 			排序规则不需要再mapper中编写,在参数中传递<br/>  
	 * @author gouwei  
	 * @param addNameSpace(sql_select_one)
	 * @param nowPage 当前页数
	 * @param pageSize 每页条数
	 * @param orderBy 排序规则语法： cloumn.asc 或者 cloumn.desc 多个使用","分隔
	 * @param params 
	 *  		Criteria 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @return 分页对象
	 */
	public <T extends Criteria>PagedList<T> findPagedList(final int nowPage,final int pageSize,T t){
		PagedList<T> pagedList = findPagedList(addNameSpace(sql_count), addNameSpace(sql_select), nowPage, pageSize, t);
		return pagedList;
	}

	/**
	 * selectPagedList:自定义分页查询 
	 * 			排序规则不需要再mapper中编写,在参数中传递<br/>  
	 * @author gouwei  
	 * @param statement1  
	 * @param statement2
	 * @param nowPage 当前页数
	 * @param pageSize 每页条数
	 * @param orderBy 排序规则语法： cloumn.asc 或者 cloumn.desc 多个使用","分隔
	 * @param params 
	 *  		Criteria 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @return 分页对象
	 */
	public <T extends Criteria>PagedList<T> findPagedList(String statement1,String statement2,final int nowPage,final int pageSize,T t){
		 Assert.notNull(t, "查询条件不能为空.");
		Long count = getSqlSession().selectOne(statement1,t);
		long totalRow = count == null ? 0 : count.intValue();
		PagedList<T> pagedList = new PagedList<T>(pageSize, nowPage, totalRow);
		 if (totalRow == 0) {
			 pagedList.setDataList(new ArrayList<T>());
			 return pagedList;
	       }
		List<T> list = selectList(statement2,buildCriteria(t,nowPage,pageSize));
		pagedList.setDataList(list);
		return pagedList;
	}

	/**
	 * update:修改对象<br/>  
	 * @author gouwei  
	 * @param params Criteria 对象 
	 * @return 修改结果
	 */
	public <T extends Criteria>int update(T t){
		Assert.notNull(t, "修改条件不能为空.");
		return update(addNameSpace(sql_update), t);
	}
	
	/**
	 * update:批量修改对象<br/>  
	 * @author gouwei  
	 * @param params Criteria 对象 
	 * @return 修改结果
	 * @ 
	 */
	public <T extends Criteria>int updateBatch(T t){
		Assert.notNull(t, "批量修改对象不能为空.");
		return update(addNameSpace(sql_update_batch), t);
	}
	
	/**
	 * insert:插入一个对象<br/>  
	 * @author gouwei  
	 * @param params 
	 *  		Criteria 对象 
	 * @return 插入成功条数
	 */
	public  <T extends Criteria>int insert(T t){
		Assert.notNull(t, "插入对象不能为空.");
		return insert(addNameSpace(sql_insert), t);
	}
	
	/**
	 * insert:批量插入对象,在mapper中使用foreach 循环取出数据<br/>
	 * sql： insert into xx(xxx,xxx,xxx) values (xx,xx,xxx),(xxx,xxx,xxxx)
	 * @author gouwei  
	 * @param params Criteria 对象 集合
	 *  		
	 * @return 插入成功条数
	 */
	public  <T extends Criteria>int insertBatch(List<T> list){
		Assert.notNull(list, "批量插入对象不能为空.");
		return insert(addNameSpace(sql_insert_batch), list);
	}
	
	 /**
 	 * delete:删除一个对象<br/>  
 	 * @author gouwei  
 	 * @param statement
 	 * @return 删除成功条数
 	 */
 	public  <T extends Criteria>int delete(){
 		return delete(null);
 	}
    /**
 	 * delete:删除一个对象<br/>  
 	 * @author gouwei  
 	 * @param statement
 	 * @param params 
 	 *  		Criteria 对象 
 	 * @return 删除成功条数
 	 */
 	public  <T extends Criteria>int delete(T t){
 		Assert.notNull(t, "删除条件不能为空.");
 		return delete(addNameSpace(sql_delete), t);
 	}
 		
 	/**
 	 * delete:批量删除对象,使用方式在Mapper中循环list,采用in方式删除<br/>  
 	 * @author gouwei  
 	 * @param statement
 	 * @param params 
 	 *  		Object 对象 
 	 * @return 删除成功条数
 	 */
 	public  <T extends Criteria>int deleteBatch(T t){
 		Assert.notNull(t, "批量删除条件不能为空.");
 		return delete(addNameSpace(sql_delete_batch), t);
 	}
   
 	/**
     * 添加命名空间
     * @param statement
     * @return
     */
    private String addNameSpace(String statement){
        return new StringBuffer().append(nameSpace).append(statement).toString();
    }
    
    /**
     * 构建MYSQL分页查询,子类可重写该方法自行实现其它数据库类型
     * @param criteria
     * @param nowPage 当前页数
     * @param pageSize  每页条数
     * @return 
     * @return
     */
    protected <T extends Criteria> T buildCriteria(T t, int nowPage, int pageSize){
        Assert.notNull(t, "查询条件不能为空.");
        int offset = nowPage > 1 ? (nowPage - 1) * pageSize : 0;
        int limit = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
        t.addExtField("offset", offset);
        t.addExtField("limit", limit);
        return t;
    }
    

}
