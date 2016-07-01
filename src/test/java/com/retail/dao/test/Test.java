package com.retail.dao.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.retail.commons.dao.ext.KeyValue;
import com.retail.commons.dao.ext.PagedList;
import com.retail.commons.exception.DaoException;
import com.retail.commons.exception.ServiceException;
import com.retail.commons.utils.SpringUtils;
import com.retail.xx.dao.TestDao;
import com.retail.xx.entity.TestBean;
import com.retail.xx.service.TestService;

/**  
 * Project Name:orm-core  
 * File Name:Test.java  
 * Package Name:  
 * Date:2016年3月22日下午1:25:37  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: Test <br/>  
 * date: 2016年3月22日 下午1:25:37 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class Test{
	
	
	private static TestDao testDao =null;
	private static TestService testService =null;
	
	static{
		new ClassPathXmlApplicationContext(new String[]{"classpath:spring-config.xml"});
		testDao = (TestDao)SpringUtils.getBean("testDao");
		testService = (TestService)SpringUtils.getBean("testService");
	}
	
	/**  
	 * 查询对象
	 * @throws DaoException 
	 */
	public TestBean find() throws DaoException {
		
		/*//查询一个对象
		 TestBean bean = new TestBean();
		 bean.setId(1);
		 TestBean t1 = testDao.findOne(bean);
		 
		 TestBean b = new TestBean();
		 b.setId(1);
		 Long l = testDao.find("select_sum", b);
		 
		 
		 TestBean bean1 = new TestBean();
		 bean1.setId(1);
		 bean1.setName("zhangsan1");
		 TestBean t2 = testDao.findOne(bean1);
		 
		 System.out.println("findOne1 : " + t1);
		 System.out.println("findOne2 : " +  t2);
		 System.out.println("=============================");
		 //查询集合

		 TestBean bean2 = new TestBean();
		 bean2.setName("zhangsan1");
		 bean2.setAddre("四川成都");
		 List<TestBean> list = testDao.findList(bean2);
		 
		 for(TestBean t : list){
			 System.out.println(t);
		 }*/
		 testService.findList();
		 
		return null;
	}

	/**
	 * 返回map集合
	 * @author gouwei  
	 * @return
	 * @throws DaoException 
	 */
	public Map<Integer,Object> findMap() throws DaoException{
		Map<Integer,Object> map = testDao.findMap("id",null);
		
		 TestBean bean2 = new TestBean();
		 bean2.setName("zhangsan1");
		 bean2.setAddre("四川成都1");
		 Map<Integer,Object> map1 =  testDao.findMap("id",bean2);
		 
		for(Map.Entry<Integer,Object> m : map.entrySet()){
			System.out.println(m.getKey() + " -> " + String.valueOf(m.getValue()));
		}
		System.out.println("==============");
		for(Map.Entry<Integer,Object> m : map1.entrySet()){
			System.out.println(m.getKey() + " -> " + String.valueOf(m.getValue()));
		}
		return map1;
	}
	
	/**
	 * 分页查询
	 * @throws DaoException 
	 */
	public PagedList<TestBean>  findPagedList() throws DaoException{
		TestBean bean2 = new TestBean();
		KeyValue<String,String> orderByItem = new KeyValue<String,String>("id",TestBean.SORT_DIRECTION_DESC);
		List<KeyValue<String,String>> list = new ArrayList<KeyValue<String,String>>(1);
		list.add(orderByItem);
		bean2.setOrderByItem(list);
		PagedList<TestBean> pagedList = testDao.findPagedList(1, 5,bean2);
		System.out.println("上一页:" +pagedList.getPrePage());
		System.out.println("当前页数:" + pagedList.getNowPage());
		System.out.println("下一页:" + pagedList.getNextPage());
		System.out.println("总页数:" + pagedList.getTotalPage());
		System.out.println("开始条数:" + pagedList.getStartRow());
		System.out.println("结束条数:" + pagedList.getEndRow());
		System.out.println("总条数:" + pagedList.getTotalRow());
		
		for(TestBean bean : pagedList.getDataList()){
			System.out.println(bean);
		}
		return pagedList;
	}
	/**
	 * update:测试修改 <br/>  
	 * @author gouwei  
	 * @return
	 * @throws DaoException 
	 */
	public int update() throws DaoException{

		 TestBean bean2 = new TestBean();
		 bean2.setId(4);
		 bean2.setName("zhangsan0001");
		 bean2.setAddre("四川成都");
		int rest1 = testDao.updateOneByTest(bean2);
		find();
		System.out.println("updateOne:" + rest1);
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i =1;i<5;i++){
			list.add(i);
		}
		TestBean bean = new TestBean();
		bean.setName("zhangsan_update");
		bean.addExtField("ids", list);
		int rest2 = testDao.updateBatchByTest(bean);
		find();
		
		System.out.println("updateBatch:" + rest2);
		return  0;
	}
	/**
	 * 
	 * insert:测试insert <br/>  
	 * @author gouwei  
	 * @return
	 * @throws DaoException 
	 */
	public  int insert() throws DaoException{
		 TestBean bean = new TestBean();
		 bean.setName("zhangsan4");
		 bean.setAddre("四川成都");
		 bean.setPhone("18612215231");
		 int rest1 = testDao.insertByTest(bean);
		 System.out.println("insertByTest:" +rest1 + " - " + bean.getId());
		 find();
		/*
		List<TestBean> list = new ArrayList<TestBean>();
		for(int i = 0;i<5;i++){
			TestBean bean1 = new TestBean();
			bean1.setName("zhangsan" + i);
			bean1.setAddre("四川成都"+i);
			bean1.setPhone("18612215231");
			list.add(bean1);
		}
		int rest2 = testDao.insertBathByTest(list);
		find();
		
		System.out.println("insertBathByTest:" +rest2);
		*/
		return 0;
	}
	
	 /**
	  * delete:测试删除. <br/>  
	  * @author gouwei  
	  * @return
	 * @throws DaoException 
	  */
	public  int delete() throws DaoException{
		 TestBean bean = new TestBean();
		 bean.setName("zhangsan4");
		 bean.setAddre("四川成都");
		 int rest1 = testDao.deleteByTest(bean);
		 find();
		System.out.println("deleteByTest:" +rest1);
		
		List<TestBean> list = new ArrayList<TestBean>();
		for(int i = 12;i<16;i++){
			TestBean bean1 = new TestBean();
			bean1.setId(i);
			list.add(bean1);
		}
		List<TestBean> list1 = new ArrayList<TestBean>();
		for(int i = 0;i<5;i++){
			TestBean bean1 = new TestBean();
			bean1.setName("zhangsan" + i);
			list1.add(bean1);
		}
		
		TestBean c = new TestBean();
		c.addExtField("ids", list);
		c.addExtField("names", list1);
		
		int rest2 = testDao.deleteBatchByTest(c );
		System.out.println("deleteBatchByTest:" +rest2);
		find();
		
		
		return 0;
	}
	/**
	 * testTranscation:测试Service事务回滚. <br/>  
	 * @author gouwei
	 * @throws ServiceException 
	 */
	public void testTranscation() throws ServiceException{
		testService.testTranscation("xx");
	}
	/**
	 * 多表操作
	 */
	public void findTestByCard(){
		TestBean t = new TestBean();
		t.setName("zhangsan1");
		Map<Integer,Map<String,String>> map = testDao.findTestByCard(t);
		for(Map.Entry<Integer, Map<String,String>> m : map.entrySet()){
			System.out.println(m.getKey() + " - " + m.getValue());
		}
	}
	public static void main(String[] args) {
		 
		Test t = new Test();
		try {
			t.find();
			//t.insert();
			//t.findMap();
			//t.findPagedList();
			//t.update();
			//t.delete();
			//t.testTranscation();
			//t.findTestByCard();
		} catch (DaoException e) {
			e.printStackTrace();  
			
		}
	}

	
}
