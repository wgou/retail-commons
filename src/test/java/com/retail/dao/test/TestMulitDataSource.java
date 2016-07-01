/**  
 * Project Name:retail-commons  
 * File Name:TestMulitDataSource.java  
 * Package Name:com.retail.dao.test  
 * Date:2016年4月11日下午1:19:25  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.dao.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.retail.commons.dao.ext.SqlSessionContextHolder;
import com.retail.commons.utils.JsonUtils;
import com.retail.commons.utils.SpringUtils;
import com.retail.xx.dao.ChginstDao;
import com.retail.xx.dao.ErpPrivilegeDao;
import com.retail.xx.dao.TestDao;
import com.retail.xx.entity.Chginst;
import com.retail.xx.entity.ErpPrivilege;
import com.retail.xx.entity.TestBean;
import com.retail.xx.service.TestService;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: TestMulitDataSource <br/>  
 * date: 2016年4月11日 下午1:19:25 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class TestMulitDataSource {
	private static TestDao testDao =null;
	private static ChginstDao chginstDao =null;
	private static ErpPrivilegeDao erpPrivilegeDao =null;
	private static TestService testService =null;
	static{
		new ClassPathXmlApplicationContext(new String[]{"classpath:spring-config.xml"});
		testDao = (TestDao)SpringUtils.getBean("testDao");
		testService = (TestService)SpringUtils.getBean("testService");
		chginstDao = (ChginstDao)SpringUtils.getBean("chginstDao");
		
		erpPrivilegeDao = (ErpPrivilegeDao)SpringUtils.getBean("erpPrivilegeDao");
	}
	
	
	public static void testDatasource1(){
		List<TestBean> list = testDao.findList();
		for(TestBean bean : list){
			System.out.println(bean);
		}
		long l = testDao.findCount(new TestBean());
		testService.testTranscation("123213");
		//testDatasource2();
		testDao.findList();
	}
	public static void testDatasource2(){
		List<ErpPrivilege> list = erpPrivilegeDao.getErpList();
			System.out.println(list.size());
	}
	
	public static void testCh(){
		List<Chginst> list = chginstDao.getList();
		System.out.println(" --------------- " + list.size() + " --------------- ");
	}
	
	public static void main(String[] args) {
		for(int i =0;i<1;i++){
				try{
					//testDatasource1();
					List<TestBean> list = testDao.findList();
					System.out.println(list.size() + "============================== " + i + " =====================");
					testCh();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
		}
	}
	
	
}
