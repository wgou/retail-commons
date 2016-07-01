/**  
 * Project Name:retail-commons  
 * File Name:TestAction.java  
 * Package Name:com.retail.xx.action  
 * Date:2016年4月8日下午5:35:31  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.xx.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.retail.commons.base.BaseAction;
import com.retail.commons.monitor.ext.MethodMonitor;
import com.retail.xx.service.TestService;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: TestAction <br/>  
 * date: 2016年4月8日 下午5:35:31 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
@MethodMonitor
@Controller
public class TestAction extends BaseAction {

	@Resource
	private  TestService testService ;
	
	public void testAction(){
		System.out.println("start action ...");
		testService.findList();
		System.out.println("end action ...");
	}
}
