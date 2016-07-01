package com.retail.commons.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MathUtils
{
	/**
	 * double格式化，保留小数点n位 
	 * 1.345 -> 1.34
	 * 1.346 -> 1.35
	 * @param number
	 * @param n
	 * @return
	 */
	public static double precisionDotMethod(double number, int n)
	{
		
		BigDecimal b = new BigDecimal(number);
		double f1 = b.setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	
	/**
	 * double格式化，保留小数点n位 
	 * @param number
	 * @param n
	 * @return
	 */
	public static String decimalDotMethod(double number, int n)
	{
		String num = "#.";
		for (int i = 0; i < n; i++){
			num += "0";
		}
		DecimalFormat f = new DecimalFormat(num); // 创建一个格式化类f
		String rtnString = f.format(number); // 格式化数据a,将a格式化为f
		return rtnString;
	}

	/**
	 * float格式化，保留小数点n位  
	 * @param number
	 * @param n
	 * @return
	 */
	public static String precisionDotMethod(float number, int n)
	{
		NumberFormat f = NumberFormat.getInstance(); // 创建一个格式化类f
		f.setMaximumFractionDigits(n); // 设置小数位的格式
		String rtnString = f.format(number); // 格式化数据a,将a格式化为f
		return rtnString;
	}
	/**
	 * 十进制数据格式化为字符串 
	 * @param number   要转换的数值
	 * @param pattern  样式如00000,000.000,#.000
	 * @return
	 */
	public static String precisionStringPattern(double number,String pattern)
	{
		DecimalFormat f = new DecimalFormat(pattern); // 创建一个格式化类f
		String rtnString = f.format(number); // 格式化数据a,将a格式化为f
		return rtnString;
	}
	/**
	 * 将字符串转换为int值，若为空则返回默认值
	 * 
	 * @param str
	 *            要转换的字符串
	 * @param defaultValue
	 *            为空时的默认值
	 * @return
	 */
	public static int null2int(String str, int defaultValue) {

		return str == null ? defaultValue : Integer.parseInt(str);
	}

	/**
	 * 在指定范围内产生随机数
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int random(int start, int end) {
		if(start>end || start <0 || end <0){
			return -1;
		}
		return (int)(Math.random()*(end-start+1))+start;
	}

	 
}
