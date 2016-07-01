/**  
 * Project Name:retail-commons  
 * File Name:Test.java  
 * Package Name:com.retail.utils  
 * Date:2016年3月31日下午3:44:08  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import com.retail.commons.utils.ExcelUtils;
import com.retail.commons.utils.JsonUtils;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: Test <br/>  
 * date: 2016年3月31日 下午3:44:08 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class TestUtils {
	
	private int c0;
	private String c1;
	private String c2;
	private String c3;
	private String c4;
	private String c5;
	private String c6;
	private String c7;
	private String c8;
	private String c9;
	private String c10;
	private String c11;
	private String c12;
	
	

	public int getC0() {
		return c0;
	}

	public void setC0(int c0) {
		this.c0 = c0;
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	public String getC3() {
		return c3;
	}

	public void setC3(String c3) {
		this.c3 = c3;
	}

	public String getC4() {
		return c4;
	}

	public void setC4(String c4) {
		this.c4 = c4;
	}

	public String getC5() {
		return c5;
	}

	public void setC5(String c5) {
		this.c5 = c5;
	}

	public String getC6() {
		return c6;
	}

	public void setC6(String c6) {
		this.c6 = c6;
	}

	public String getC7() {
		return c7;
	}

	public void setC7(String c7) {
		this.c7 = c7;
	}

	public String getC8() {
		return c8;
	}

	public void setC8(String c8) {
		this.c8 = c8;
	}

	public String getC9() {
		return c9;
	}

	public void setC9(String c9) {
		this.c9 = c9;
	}

	public String getC10() {
		return c10;
	}

	public void setC10(String c10) {
		this.c10 = c10;
	}

	public String getC11() {
		return c11;
	}

	public void setC11(String c11) {
		this.c11 = c11;
	}

	public String getC12() {
		return c12;
	}

	public void setC12(String c12) {
		this.c12 = c12;
	}

	@Test
	public static void testExcelRead(){
		
		File file = new File("E:\\test.xlsx");
		try {
			InputStream in = new FileInputStream(file);
			String[] cloumn = new String[]{"c0","c1","c2","c3","c4","c5","c6","c7","c8","c9","c10","c11","c12"};
			List<TestUtils> list = ExcelUtils.readExcel(cloumn, in, TestUtils.class,"xlsx");
			for(TestUtils t : list){
				System.out.println(JsonUtils.getJsonStringFromObject(t));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();  
		} catch (IOException e) {
			e.printStackTrace();  
		}
		
	}
	
	 
}
