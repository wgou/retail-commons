/**  
 * Project Name:orm-core  
 * File Name:TestDao.java  
 * Package Name:com.retail.xx.dao  
 * Date:2016年3月23日下午3:51:37  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.xx.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.retail.commons.base.BaseDao;
import com.retail.commons.dao.ext.DAOProperties;
import com.retail.commons.dao.ext.DataSource;
import com.retail.commons.dao.ext.PagedList;
import com.retail.xx.entity.TestBean;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: TestDao <br/>  
 * date: 2016年3月23日 下午3:51:37 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
@DAOProperties(tableName="test",nameSpace="test")
@DataSource("mysql")
@Repository
public class TestDao extends BaseDao{
	
	/**
	 * selectOne:数据库查询一个对象 <br/>  
	 * @author gouwei  
	 * @return 查询结果对象
	 * @ 
	 */
	public TestBean findByTest(TestBean test) {
		TestBean entity = findOne(test);
		return entity;
	}

	/**
	 * selectList:查询对象集合 <br/>  
	 * @author gouwei  
	 * @return 查询结果集合
	 * @ 
	 */
	
	public List<TestBean> findListByTest(TestBean test)  {
		List<TestBean> list = findList(test);
		return list;
	}
	/**
	 * selectList:查询对象集合 <br/>  
	 * @author gouwei  
	 * @param mapKey 你想用那个字段的值来作为返回map的key
	 * @return 查询结果Map集合[{key:{id:xx,name:xxx}},{key:{id:xx,name:xxx}},]
	 * @ 
	 */
	
	public <K, V>Map<K,V> findMapByTest( String mapKey,TestBean test)  {
		Map<K,V> map = findMap(mapKey, test);
		return map;
	}
	/**
	 * selectPagedList:分页查询 
	 * 			排序规则不需要再mapper中编写,在参数中传递<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param nowPage 当前页数
	 * @param pageSize 每页条数
	 * @param orderBy 排序规则语法： cloumn.asc 或者 cloumn.desc 多个使用","分隔
	 * @param params 
	 *  		BaseEntity 对象 或者 Map<String,Object> 
	 * 			 如果查询条件只有一个,可以直接传递字符串
	 * @return 分页对象
	 * @ 
	 */
	public PagedList<TestBean> findPagedListByTest( int nowPage, int pageSize, TestBean test) {
		 PagedList<TestBean> pagedList = findPagedList(nowPage, pageSize, test);
		 return pagedList;
	}
	/**
	 * update:修改数据<br/>  
	 * @author gouwei  
	 * @param statement
	 * @return 修改结果
	 */
	public int updateOneByTest(TestBean test) {
		return update(test);
	}
	
	 
	/**
	 * updateBatchByTest:批量修改. <br/>  
	 * @author gouwei  
	 * @param bean
	 * @return
	 * @
	 */
	public int updateBatchByTest(TestBean bean) {
		return super.updateBatch(bean);
	}
	
	  
	/**
	 * insert:插入一个对象<br/>  
	 * @author gouwei  
	 * @param statement
	 * @param params 
	 *  		BaseEntity 对象 
	 * @return 插入成功条数
	 * @ 
	 */
	public  int insertByTest(TestBean t) {
		return insert(t);
	}
	
	
	/**
	 * insert:批量插入对象,在mapper中使用foreach 循环取出数据<br/>
	 * sql： insert into xx(xxx,xxx,xxx) values (xx,xx,xxx),(xxx,xxx,xxxx)
	 * @author gouwei  
	 * @param statement
	 * @return 插入成功条数
	 * @ 
	 */
	public int insertBathByTest(List<TestBean> list) {
		return insertBatch(list);
	}



	/**
	 * insert:删除对象,在mapper中使用foreach 循环取出数据<br/>
	 * sql： delete from table where id = xx
	 * @author gouwei  
	 * @param statement
	 * @return 插入成功条数
	 * @ 
	 */
	public int deleteByTest(TestBean test) {
		return delete(test);
	}
	
	/**
	 * insert:批量删除对象,在mapper中使用foreach 循环取出数据<br/>
	 * sql： delete from table where id in (xx,xxx,xx)
	 * @author gouwei  
	 * @param statement
	 * @return 插入成功条数
	 * @ 
	 */
	public int deleteBatchByTest(TestBean test) {
		return deleteBatch(test);
	}
 
	/**
	 * 多表操作
	 */
	public Map<Integer,Map<String,String>> findTestByCard(TestBean test){
		return selectMap("select_test_card", "id", test);
	}
	
}
