/**  
 * Project Name:orm-core  
 * File Name:TestService.java  
 * Package Name:com.retail.xx.service  
 * Date:2016年3月23日下午3:51:01  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.xx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.retail.commons.base.BaseService;
import com.retail.commons.dao.ext.SqlSessionContextHolder;
import com.retail.commons.exception.ServiceException;
import com.retail.commons.monitor.ext.MethodMonitor;
import com.retail.xx.dao.TestDao;
import com.retail.xx.entity.TestBean;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: TestService <br/>  
 * date: 2016年3月23日 下午3:51:01 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
@Service
@MethodMonitor
public class TestService extends BaseService{
	@Resource
	private TestDao testDao;
	
	public List<TestBean> findList(){
		List<TestBean> list = testDao.findList();
		for(TestBean bean : list){
			System.out.println(bean);
		}
		return list;
	}
	@Transactional
	public int testTranscation(String xxxxxxxxxxxx){
		System.out.println(xxxxxxxxxxxx);
		TestBean bean = new TestBean();
		bean.setId(16);
		bean.setName("zhangsan1");
	    int update1 = testDao.updateOneByTest(bean);
	    System.out.println("update1 :" + update1);
	    /*TestBean bean1 = new TestBean();
	    bean1.setId(2);*/
	   /* //dao异常
		bean1.setName("zhangsan02zhangsan02zhangsan02zhangsan02zhangsan02zhangsan02zhangsan02zhangsan02");
		int update2 = testDao.updateOneByTest(bean1);
		System.out.println("update2 :" + update2);*/
		return update1;
		
	}
	@MethodMonitor(false)
	public List<TestBean> testMonitor(){
		
		return null;
	}
	public List<TestBean> findList(String xx,String str,Object o){
		
		System.out.println("进入方法 .....");
		
		System.out.println("退出方法 .....");
		return null;
	}
	
	public void testServiceException(){
		
		if(1  != 0){
			throw new ServiceException("已知异常.需要手动构造.");
		}
		
	}

}
