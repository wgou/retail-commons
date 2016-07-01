/**  
 * Project Name:retail-commons  
 * File Name:ExcelUtils.java  
 * Package Name:com.retail.commons.utils  
 * Date:2016年3月31日下午2:41:58  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**  
 * 描述:<br/>excel导入<br/>  
 * ClassName: ExcelUtils <br/>  
 * date: 2016年3月31日 下午2:41:58 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class ExcelUtils {

	private final static int START_INDEX = 1;
	/**
	 * readExcel:读取excel文件内容. <br/>  
	 * @author gouwei  
	 * @param cloumn 返回对象属性数组,该数组顺序与excel的每列对应
	 * @param input  excel文件流
	 * @param clazz  接收excel内容的对象
	 * @param suffix 文件后缀,用于判断excel 版本
	 * @index 重第几行开始读取,默认重第1行开始,第0行为标题行
	 * @return 
	 * @throws IOException 
	 */
	public static <T>List<T> readExcel(String[] cloumn,InputStream input,Class<T> clazz,String suffix,int... index) throws IOException{
		Workbook wb = null;  
        if (isExcel2007(suffix)){  
            wb = new XSSFWorkbook(input);
        }else {  
        	POIFSFileSystem fs = new POIFSFileSystem(input);
        	wb = new HSSFWorkbook(fs);  
        }  
		int readIndex = index.length ==0 ?START_INDEX:index[0];
		//开始读取的行
		Sheet sheet = wb.getSheetAt(0);
		//获取第一列
		Row row = sheet.getRow(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		//获取不为空的总列数
		int cloNum = row.getPhysicalNumberOfCells();
		
		List<T> list = new ArrayList<>(rowNum);
		for(int i=readIndex;i<=rowNum;i++){
			row = sheet.getRow(i);
			T t = null;
			try {
				t = clazz.newInstance();
			} catch (Exception e) {
				e.printStackTrace();  
			}
			boolean isNull = true;
			for(int j=0;j<cloNum;j++){
				
				String value = getCellFormatValue(row.getCell(j)).trim();
				if(StringUtils.isNotBlank(value)){
					rowConverClass(cloumn[j],value,t);
					isNull = false;
				}
			}
			if(!isNull) //过滤空行数据
				list.add(t);
		}
		return list;
	}
	
	
	/**
	 * 导出excel
	 * FIXME 
	 * @param title excel sheet名字
	 * @param headers excel第一行
	 * @param dataset 数据
	 * @param out request输出流
	 */
	 public static void exportExcel(String title, String[] headers,  
	            List<String[]> dataset, OutputStream out)  
	    {  
	        // 声明一个工作薄  
	        HSSFWorkbook workbook = new HSSFWorkbook();  
	        // 生成一个表格  
	        HSSFSheet sheet = workbook.createSheet(title);  
	        // 设置表格默认列宽度为15个字节  
	        sheet.setDefaultColumnWidth(15);
	        // 生成一个样式  
	        HSSFCellStyle style = workbook.createCellStyle();  
	        // 设置这些样式  
	        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);  
	        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
	        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
	        style.setBorderRight(HSSFCellStyle.BORDER_THIN);  
	        style.setBorderTop(HSSFCellStyle.BORDER_THIN);  
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	        // 生成一个字体  
	        HSSFFont font = workbook.createFont();  
	        font.setColor(HSSFColor.VIOLET.index);  
	        font.setFontHeightInPoints((short) 12);  
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
	        // 把字体应用到当前的样式  
	        style.setFont(font);  
	        // 生成并设置另一个样式  
	        HSSFCellStyle style2 = workbook.createCellStyle();  
	        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);  
	        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);  
	        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);  
	        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);  
	        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);  
	        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);  
	        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
	        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
	        // 生成另一个字体  
	        HSSFFont font2 = workbook.createFont();  
	        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);  
	        // 把字体应用到当前的样式  
	        style2.setFont(font2);  
	  
	        // 声明一个画图的顶级管理器  
	      //  HSSFPatriarch patriarch = sheet.createDrawingPatriarch();  
	        // 定义注释的大小和位置,详见文档  
	       // HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,  
	       //         0, 0, 0, (short) 4, 2, (short) 6, 5));  
	        // 设置注释内容  
	        //comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));  
	        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.  
	       // comment.setAuthor("leno");  
	  
	        // 产生表格标题行  
	        HSSFRow row = sheet.createRow(0);  
	        for (int i = 0; i < headers.length; i++)  
	        {  
	            HSSFCell cell = row.createCell(i);  
	            cell.setCellStyle(style);  
	            HSSFRichTextString text = new HSSFRichTextString(headers[i]);  
	            cell.setCellValue(text);  
	        } 
	        //产生内容
	        for(int i = 0;i<dataset.size();i++){
	        	 row = sheet.createRow(i+1);
	        	 String[] data = dataset.get(i);
	        	  for(int j = 0;j<data.length;j++){
	        		  HSSFCell cell = row.createCell(j);  
	        		  cell.setCellStyle(style2);
	        		  String value = data[j];
	        		  HSSFRichTextString richString = new HSSFRichTextString(value);  
                      HSSFFont font3 = workbook.createFont();  
                      font3.setColor(HSSFColor.BLUE.index);  
                      richString.applyFont(font3);  
                      cell.setCellValue(richString);  
	        	  }
	        }
	        try  
	        {  
	            workbook.write(out);  
	            out.flush();
	        }  
	        catch (IOException e)  
	        {  
	            e.printStackTrace();  
	        }  
	    }  
	
	 
	
    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private static String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                 
            case HSSFCell.CELL_TYPE_NUMERIC: // 数字  
            	BigDecimal bd = new BigDecimal(cell.getNumericCellValue()); 
            	cellvalue = bd.longValue() + "";  
                break;  

            case HSSFCell.CELL_TYPE_STRING: // 字符串  
            	cellvalue = cell.getStringCellValue();  
                break;  

            case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean  
            	cellvalue = cell.getBooleanCellValue() + "";  
                break;  

            case HSSFCell.CELL_TYPE_BLANK: // 空值  
            	cellvalue = "";  
                break; 
                
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                	String format = "yyyy-MM-dd";
                	switch (cell.getCellStyle().getDataFormat()) {
					case 22:
						format =  "yyyy-MM-dd HH:mm:ss";
						break;
					case 14:
						format =  "yyyy-MM-dd";
						break;
					case 21:
						format =  "HH:mm:ss";
						break;
					case 17:
						format =  "yyyy-MM";
						break;
					case 20:
						format =  "HH:mm";
						break;
					case 58:
						format =  "MM-dd";
						break;
					} ;
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat(format);
                    cellvalue = sdf.format(date);
                }else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            default:
                cellvalue = "";
            }
        }
        return cellvalue;
    }

    private static boolean isExcel2007(String suffix)  
    {  
  
        return suffix.toLowerCase().matches("xlsx");  
  
    } 
    
    /**
     * 对象赋值
     */
    private static <T>T rowConverClass(String cloumn,String value,T t){
		Map<String,Method> methodMap = ClassUtils.setMethodMap(t.getClass());
		Method m = methodMap.get(cloumn);
		if(m !=null){
			try {
				ClassUtils.getInvokeSetParamsBean(t, m, value);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();  
			}
		}
		return t;
    }
    
}
