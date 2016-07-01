package com.retail.monitor.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.retail.commons.utils.SpringUtils;
import com.retail.xx.action.TestAction;
import com.retail.xx.service.TestService;

/**
 * 测试监控
 * <p>TestMonitor</p>
 * <p>TODO</p>
 *
 * @author		苟伟(gouwei@chinastrinfo.com)
 * @version		0.0.0
 * <table style="border:1px solid gray;">
 * <tr>
 * <th width="100px">版本号</th><th width="100px">动作</th><th width="100px">修改人</th><th width="100px">修改时间</th>
 * </tr>
 * <!-- 以 Table 方式书写修改历史 -->
 * <tr>
 * <td>0.0.0</td><td>创建类</td><td>luochen</td><td>2016年3月26日 上午11:04:58</td>
 * </tr>
 * <tr>
 * <td>XXX</td><td>XXX</td><td>XXX</td><td>XXX</td>
 * </tr>
 * </table>
 */
public class TestMonitor {

	private static TestService testService =null;
	private static TestAction testAction =null;
	
	static{
		new ClassPathXmlApplicationContext(new String[]{"classpath:spring-config.xml"});
		testService = (TestService)SpringUtils.getBean("testService");
		testAction = (TestAction)SpringUtils.getBean("testAction");
	}
	
	public static void main(String[] args) {
		//testService.testMonitor();
		//testService.findList("123","333",new Object[]{"ttt"});
		testAction.testAction();
	}
}
