/**  
 * Project Name:retail-commons  
 * File Name:DaoExceptionHandler.java  
 * Package Name:com.retail.common.exception.ext  
 * Date:2016年3月27日下午1:04:36  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */

package com.retail.commons.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.util.Assert;
import org.xml.sax.InputSource;

/**  
 * 描述:<br/>dom4j 操作xml<br/>  
 * ClassName: AbstractDaoExt <br/>  
 * date: 2016年3月27日下午1:04:36 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class Dom4jXmlUtil {

	/** TODO */
	private static XPath xpath = XPathFactory.newInstance().newXPath();

	/** 日志记录器 */
	static Logger logger = Logger.getLogger(Dom4jXmlUtil.class);

	/** 格式化xml */
	public static OutputFormat format = OutputFormat.createPrettyPrint();
	/** 字符输出器 */
	private static StringWriter stringOut = new StringWriter();

	/** 文档解析器类 */
	private static SAXReader reader = new SAXReader();

	/**
	 * 根据文件名创建dom4j对象
	 * 
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Document createNewDom4jDocument(String filePath, String charSet) throws FileNotFoundException {
		Document result = null;
		InputSource source = new InputSource(new FileReader(new File(filePath)));
		source.setEncoding(charSet);
		try {
			result = reader.read(source);
		} catch (DocumentException e) {
			logger.error("创建文档出错", e);
		}
		return result;
	}

	/**
	 * 增加子节点
	 * 
	 * @param parent
	 * @param newNode
	 * @return
	 */
	public static Node addChild(Element parent, Node newNode) {
		if (parent == null || newNode == null)
			return null;
		parent.add(newNode);
		return newNode;
	}

	/**
	 * 增加子节点
	 * 
	 * @param doc
	 * @param parent
	 * @param nodeName
	 * @param nodeValue
	 * @return
	 */
	public static Node addChild(Element parent, String nodeName, String nodeValue) {
		if (parent == null || nodeName == null)
			return null;
		Element ele = parent.addElement(nodeName);
		if (nodeValue != null && nodeValue.trim().length() != 0)
			return ele.addText(referTxtOrAttr(nodeValue));// node.appendChild(doc.createTextNode(nodeValue));
		return ele;
	}

	/**
	 * 增加属性
	 * 
	 * @param ele
	 * @param attrNmae
	 * @param value
	 */
	public static void addAttribute(Element ele, String attrNmae, String value) {
		if (ele == null || attrNmae == null || value == null)
			return;
		ele.addAttribute(attrNmae, referTxtOrAttr(value));
	}

	/**
	 * 将map的所有key添加到元素的属性中去
	 * 
	 * @param ele
	 * @param attrmap
	 */
	public static void addAttribute(Element ele, Map<String, String> attrmap) {
		if (ele == null || attrmap == null || attrmap.isEmpty())
			return;
		for (String attrNmae : attrmap.keySet()) {
			ele.addAttribute(attrNmae, referTxtOrAttr(attrmap.get(attrNmae)));
		}
	}

	/**
	 * 给元素增加文本
	 * 
	 * @param parent
	 * @param nodeText
	 * @return
	 */
	public static Node addChildText(Element parent, String nodeText) {
		if (parent == null || nodeText == null)
			return null;
		return parent.addText(referTxtOrAttr(nodeText));
	}

	/**
	 * 根据表达式从指定节点获得指定类型的对象
	 * 
	 * @param <T>
	 * @param expression
	 * @param item
	 *            : referance item
	 * @param returnType
	 *            : return type
	 * @return
	 */
	public static List selectXmlItem(String expression, Object item, QName returnType) {
		if (expression == null || expression.trim().length() == 0 || item == null || returnType == null)
			return null;
		try {
			Document document = (Document) item;
			List list = document.selectNodes(expression);
			return list;
		} catch (Exception e) {
			logger.error("获取表达式对象出错,expression=" + expression, e);
		}
		return null;
	}

	/**
	 * dom4j文档保存为文件
	 * 
	 * @param doc
	 * @param filename
	 * @param encoding
	 * @param standalone
	 * @return
	 */
	public static boolean saveDocument(Document doc, String filename, String encoding, boolean standalone) {
		if (doc == null || filename == null || filename.trim().length() == 0)
			return false;
		try {
			if (encoding != null && encoding.trim().length() != 0) {
				format.setEncoding(encoding);// 指定XML编码
			}
			XMLWriter writer = new XMLWriter(new FileOutputStream(filename), format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			logger.error("保存文件异常:", e);
			return false;
		}
		return true;
	}

	/**
	 * dom4j 文档输出到流
	 * 
	 * @param doc
	 * @param os
	 * @param encoding
	 * @param standalone
	 * @return
	 */
	public static boolean saveDocument(Document doc, OutputStream os, String encoding, boolean standalone) {
		if (os == null)
			return false;
		try {
			if (encoding != null && encoding.trim().length() != 0) {
				format.setEncoding(encoding);// 指定XML编码
			}
			XMLWriter writer = new XMLWriter(os, format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			logger.error("输出文档异常", e);
			return false;
		}
		return true;
	}

	/**
	 * xml格式转转义
	 * 
	 * @param str
	 * @return
	 */
	public static String referTxtOrAttr(String str) {
		if (str != null) {
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			str = str.replaceAll("&", "&amp;");
			str = str.replaceAll("'", "&apos;");
			str = str.replaceAll("\"", "&quot;");
		}
		return str;
	}

	/**
	 * dom4j文档转换为字符串
	 * 
	 * @param doc
	 * @return
	 */
	public static String documentToString(org.dom4j.Document doc) {
		String xmlDoc = "<error>-1</error>";
		xmlDoc = doc.asXML();
		return xmlDoc;

	}

	/**
	 * 将Document对象优雅格式化成字符串 
	 * @param doc	文档对象
	 * @param charSet	要输出的字符编码
	 * @return
	 */
	public static String documentToPrettyString(org.dom4j.Document doc, String charSet) {
		String xmlDoc = "<error>-1</error>";
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding(charSet);
			// 创建写出对象
			StringWriter sw = new StringWriter();
			XMLWriter writer = new XMLWriter(sw, format);
			writer.write(doc);
			xmlDoc = sw.toString();
			writer.close();
		} catch (Exception e) {
			logger.error("转换document对象异常,msg=" + e.getLocalizedMessage(), e);
		}
		return xmlDoc;

	}

	/**
	 * 字符串转换为 dom4j文档
	 * 
	 * @param strXml
	 * @return
	 */
	public static Document StringTodocument(String strXML) {
		Document responseDoc = null;
		try {
			responseDoc = DocumentHelper.parseText(strXML);
		} catch (DocumentException e1) {
			logger.error("DocumentException转换异常,xml=" + strXML, e1);

		}
		return responseDoc;

	}

	/**
	 * 将map的所有值转换为element，clazz的名称为元素名
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static Element mapToElement(Map<?, ?> map, Class<?> clazz) {
		Element base = DocumentHelper.createElement(clazz.getSimpleName());
		for (Object entry : map.keySet()) {
			String key = entry.toString();
			Object value = map.get(key);
			if (value != null)
				base.addAttribute(key, (String) value);
		}
		return base;
	}

	/**
	 * 将一个元素转换成map
	 * 
	 * @param ele
	 * @return
	 */
	public static Map<String, Object> elementToMap(Element ele) {
		Assert.notNull(ele, "传入的Element不能为空");
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		List<Attribute> attList = ele.attributes();
		for (Attribute att : attList) {
			String key = att.getName();
			try {
				map.put(key, att.getValue());
			} catch (IllegalArgumentException e) {
				logger.error("获取属性非法参数错误," + key + ",msg=" + e.getLocalizedMessage(), e);
			}
		}
		return map;
	}

	 
}
