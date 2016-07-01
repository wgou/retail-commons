/**  
 * Project Name:retail-commons  
 * File Name:DaoExceptionHandler.java  
 * Package Name:com.retail.common.exception.ext  
 * Date:2016年3月24日下午1:04:36  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.exception.ext;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.aop.ThrowsAdvice;


/**  
 * 描述:<br/>异常统一处理 <br/>  
 * <pre>
 * 	说明：
 * 		统一异常代理类,主要是集中式处理分层业务的不同异常类型,根据不同的业务层,输出不同异常对象
 * 		此处暂时忽略Action层异常,交由HandlerExceptionResolver 接口实现处理
 * 注意：
 * 		1：在编写dao层和service层代码时,如果在方法体中使用try-cartch语句,必须要显示抛出异常。
 * 		2：在dao层和service层,编码人员预计可能会发生的已知异常,需要手动try-catch并显示的抛出加以说明的异常,以方便问题快速定位
 *  	3：在显示抛出异常时,dao层必须是抛出DaoException 异常对象,service层必须是抛出ServiceException对象
 * 
 * </pre>
 * ClassName: ProxyExceptionHandler <br/>  
 * date: 2016年3月24日 下午1:04:36 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public final class ProxyExceptionHandler implements ThrowsAdvice{
	//此处应该指定输出error文件
	private Logger logger = Logger.getLogger(ProxyExceptionHandler.class);

    /**
	 * afterThrowing:Service层异常处理 <br/>  
	 * @author gouwei  
	 * @param JoinPoint 发生异常对象
	 * @param Exception 产生的异常  
	 */
    public void afterThrowing(JoinPoint jp, Exception  ex){
    	ExceptionDesc exceptionDesc = new ExceptionDesc();
    	exceptionDesc.setExMethod(jp.getSignature().toString());
    	exceptionDesc.setExMethodParams(jp.getArgs());
    	exceptionDesc.setExTragetObject(jp.getTarget().getClass().getName());
    	exceptionDesc.setExtProxyObject( jp.getThis().getClass().getName());
    //	exceptionDesc.setExMessage(ex.getMessage());
    //	exceptionDesc.setExMessageDetail(ex.fillInStackTrace().getLocalizedMessage());
    	/////////////////// 统一日志 输出  格式化 or on ? //////////////////////////////
    	logger.error(exceptionDesc.toJsonString(),ex);
        
    }  
}
