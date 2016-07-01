/**  
 * Project Name:retail-commons  
 * File Name:ArraysUtils.java  
 * Package Name:com.retail.commons.utils  
 * Date:2016年4月7日下午12:57:26  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.utils;

import java.util.ArrayList;
import java.util.List;

/**  
 * 描述:<br/>集合操作<br/>  
 * ClassName: ArraysUtils <br/>  
 * date: 2016年4月7日 下午12:57:26 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class ArraysUtils {

	/**
	 * copyOfRange:List集合复制. <br/>  
	 * @author gouwei  
	 * @param list 被复制list
	 * @param from 复制起始位置
	 * @param to 复制结束为止
	 * @return 返回复制的list集合
	 */
	public static <T> List<T> copyOfRange(List<T> list,int from,int to){
	  int newLength = to - from;
      if (newLength < 0)
            throw new IllegalArgumentException(from + " > " + to);
		List<T> copyList = list.subList(from, to);
       return copyList;
	}
	/**
	 * partition:将一个list拆分为多个list. <br/>  
	 * @author gouwei  
	 * @param list
	 * @param partition
	 * @return
	 */
	public static <T>List<List<T>> partition(List<T> list,int partition){
		int len = list.size();
		int size = len%partition == 0?len/partition:(len/partition)+1;
		List<List<T>> newList = new ArrayList<List<T>>(size);
		if(partition > len){
			newList.add(list);
			return newList;
		}
		int offset = 0;
		int limit = 0;
		while(offset  < len){
			limit = offset + partition;
			limit = limit > len?len:limit;
			List<T> cotyList = copyOfRange(list,offset,limit);
			newList.add(cotyList);
			offset = limit;
		}
		return newList;
	}
	
}
