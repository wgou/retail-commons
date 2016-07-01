/**  
 * Project Name:retail-commons  
 * File Name:HttpClientUtils.java  
 * Package Name:com.retail.commons.utils  
 * Date:2016年5月13日下午3:43:19  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.commons.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

/**  
 * 描述:<br/>httpClient 请求操作 <br/>  
 * ClassName: HttpClientUtils <br/>  
 * date: 2016年5月13日 下午3:43:19 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class HttpClient {

	private Logger logger = Logger.getLogger(HttpClient.class);
	private URL url;
	private int connectionTimeout;
	private int readTimeOut;
	private final int defalue_connectionTimeout = 10000;
	private final int  defalue_readTimeOut = 5000;
	/**
	 * 构造函数
	 * @param url 目标地址
	 * @param connectionTimeout HTTP连接超时时间
	 * @param readTimeOut HTTP读写超时时间
	 */
	public HttpClient(String url, int connectionTimeout, int readTimeOut) {
		try {
			this.url = new URL(url);
			this.connectionTimeout = connectionTimeout;
			this.readTimeOut = readTimeOut;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 构造函数
	 * @param url 目标地址
	 * @param connectionTimeout HTTP连接超时时间
	 * @param readTimeOut HTTP读写超时时间
	 */
	public HttpClient(String url) {
		try {
			this.url = new URL(url);
			this.connectionTimeout = defalue_connectionTimeout;
			this.readTimeOut = defalue_readTimeOut;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 发送信息到服务端
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public int send(Map<String, String> data,String requestType, String ...charset) throws Exception {
		try {
			String encoding = "utf-8";
			if(charset !=null  && charset.length > 0)
				encoding = charset[0];
			HttpURLConnection httpURLConnection = createConnection(requestType);
			if(null == httpURLConnection){
				throw new Exception("创建联接失败");
			}
			String sendData = this.getRequestParamString(data, encoding);
			logger.debug("请求报文:[" + sendData + "]");
			this.requestServer(httpURLConnection, sendData,
					encoding);
			String  result = this.response(httpURLConnection, encoding);
			logger.debug("同步返回报文:[" + result + "]");
			return httpURLConnection.getResponseCode();
		} catch (Exception e) {
			throw e;
		}
	}
	

	/**
	 * 发送信息到服务端
	 * @param data
	 * @param encoding
	 * @return
	 * @throws Exception
	 */
	public String send(HttpURLConnection httpURLConnection,Map<String, String> data) throws Exception {
		try {
			String encoding = "utf-8";
			if(null == httpURLConnection){
				throw new Exception("创建联接失败");
			}
			String sendData = this.getRequestParamString(data, encoding);
			logger.debug("请求报文:[" + sendData + "]");
			this.requestServer(httpURLConnection, sendData,
					encoding);
			String  result = this.response(httpURLConnection, encoding);
			logger.debug("同步返回报文:[" + result + "]");
			return result;
		} catch (Exception e) {
			throw e;
		}
	}
 
	/**
	 * 创建连接
	 * @requestType 请求方式,GET / POST
	 * @return
	 * @throws ProtocolException
	 */
	public HttpURLConnection createConnection(String requestType) throws ProtocolException {
		HttpURLConnection httpURLConnection = null;
		try {
			httpURLConnection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		httpURLConnection.setConnectTimeout(this.connectionTimeout);// 连接超时时间
		httpURLConnection.setReadTimeout(this.readTimeOut);// 读取结果超时时间
		httpURLConnection.setDoInput(true); // 可读
		httpURLConnection.setDoOutput(true); // 可写
		httpURLConnection.setUseCaches(false);// 取消缓存
		httpURLConnection.setRequestProperty("Content-type",
				"*/*;charset=utf-8");
		httpURLConnection.setRequestMethod(requestType);
		return httpURLConnection;
	}

	/**
	 * 将Map存储的对象，转换为key=value&key=value的字符
	 * @param requestParam
	 * @param coder
	 * @return
	 */
	private String getRequestParamString(Map<String, String> requestParam,String encoding) {
		StringBuffer sf = new StringBuffer("");
		String reqstr = "";
		if (null != requestParam && 0 != requestParam.size()) {
			for (Entry<String, String> en : requestParam.entrySet()) {
				try {
					sf.append(en.getKey()
							+ "="
							+ (null == en.getValue() || "".equals(en.getValue()) ? "" : URLEncoder
									.encode(en.getValue(), encoding)) + "&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return "";
				}
			}
			reqstr = sf.substring(0, sf.length() - 1);
		}
		logger.debug("请求报文(已做过URLEncode编码):[" + reqstr + "]");
		return reqstr;
	}
	
	
	/**
	 * HTTP Post发送消息
	 *
	 * @param connection
	 * @param message
	 * @throws IOException
	 */
	public void requestServer(final URLConnection connection, String message, String encoder)
			throws Exception {
		PrintStream out = null;
		try {
			connection.connect();
			out = new PrintStream(connection.getOutputStream(), false, encoder);
			out.print(message);
			out.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != out) {
				out.close();
			}
		}
	}

	/**
	 * 显示Response消息
	 *
	 * @param connection
	 * @param CharsetName
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	private String response(final HttpURLConnection connection, String encoding)
			throws URISyntaxException, IOException, Exception {
		InputStream in = null;
		StringBuilder sb = new StringBuilder(1024);
		BufferedReader br = null;
		try {
			if (200 == connection.getResponseCode()) {
				in = connection.getInputStream();
				sb.append(new String(read(in), encoding));
			} else {
				in = connection.getErrorStream();
				sb.append(new String(read(in), encoding));
			}
			logger.info("HTTP Return Status-Code:["
					+ connection.getResponseCode() + "]");
			return sb.toString();
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != br) {
				br.close();
			}
			if (null != in) {
				in.close();
			}
			if (null != connection) {
				connection.disconnect();
			}
		}
	}
	
	private static byte[] read(InputStream in) throws IOException {
		byte[] buf = new byte[1024];
		int length = 0;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		while ((length = in.read(buf, 0, buf.length)) > 0) {
			bout.write(buf, 0, length);
		}
		bout.flush();
		return bout.toByteArray();
	}
	

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getReadTimeOut() {
		return readTimeOut;
	}

	public void setReadTimeOut(int readTimeOut) {
		this.readTimeOut = readTimeOut;
	}
 
	
}
