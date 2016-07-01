/**  
 * Project Name:damll-commons  
 * File Name:TestException.java  
 * Package Name:com.retail.exception.test  
 * Date:2016年3月24日上午10:59:38  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.exception.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.retail.commons.utils.SpringUtils;
import com.retail.xx.service.TestService;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: TestException <br/>  
 * date: 2016年3月24日 上午10:59:38 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class TestException {
	private static TestService testService =null;
	static{
		new ClassPathXmlApplicationContext(new String[]{"classpath:spring-config.xml"});
		testService = (TestService)SpringUtils.getBean("testService");
	}
	
	public static void main(String[] args) {
		try{
			testService.testTranscation("123213123");
			//testService.testServiceException();
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
}
