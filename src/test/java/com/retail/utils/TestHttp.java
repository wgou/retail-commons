/**  
 * Project Name:retail-commons  
 * File Name:TestHttp.java  
 * Package Name:com.retail.utils  
 * Date:2016年5月13日下午4:04:20  
 * Copyright (c) 2016, 成都瑞泰尔科技有限公司 All Rights Reserved.  
 *  
 */
package com.retail.utils;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;
import com.retail.commons.utils.HttpClient;

/**  
 * 描述:<br/>TODO; <br/>  
 * ClassName: TestHttp <br/>  
 * date: 2016年5月13日 下午4:04:20 <br/>  
 * @author  苟伟(gouewi@retail-tek.com)   
 * @version   
 */
public class TestHttp {

 
	public static String getOrder(long id){
		String order="{\"ofcConsumer\":{\"ernam\":\"DMALL\",\"isSuccess\":0,\"name1\":\"test\",\"name2\":\"多点客户号\",\"orderId\":\""+id+"\",\"pstlz\":\"100000\",\"sortl\":\"185001\",\"stras\":\"北京市 海淀区 田村小区橡树湾\",\"telf1\":\"15828538387\",\"yn\":0},\"ofcOrder\":{\"businessTime\":\"2016-04-10 10:04:22\",\"invoiceFlag\":1,\"isExpReq\":-1,\"isSuccess\":0,\"items\":[{\"eaTag\":-1,\"isSuccess\":0,\"itemName\":\"海天金标生抽王500ML/瓶\",\"matnr\":\"249978\",\"orderId\":\""+id+"\",\"quantity\":6,\"refMatnr\":\"-1\",\"salePrice\":8.9,\"saleUnit\":\"EA\",\"specNum\":-1,\"yn\":0}],\"orderId\":\""+id+"\",\"orderSource\":1,\"saleType\":1,\"shipmentTime\":\"02-06 13:00-13:59\",\"shipmentType\":\"1\",\"shopId\":5001,\"systemStatus\":0,\"yn\":0}}";
		return order;
	}
	
	public static void sendOrder(){

		int count = 0;
		int error = 0;
		Random rd = new Random();
		long orderId = 90000;
		long start = System.currentTimeMillis();
		int i = 0;
		while(true){
			i++;
			try{
				HttpClient http = new HttpClient("http://10.13.2.32/goods-web/order/orderreceive");
				HttpURLConnection connection = http.createConnection("POST");
				connection.setRequestProperty("Content-type","application/json;accountName=(.*?));(password=(.*?);;");
				http.requestServer(connection, getOrder(orderId++), "utf-8");
				if(200 == connection.getResponseCode()){
					count++;
				}else{
					error++;
				}
				System.out.println(getOrder(orderId));
				System.out.println("code:"+connection.getResponseCode()+",成功次数:" + count+ ",失败：" + error);
				//TimeUnit.SECONDS.sleep(100);
				if(i > 1000){
					break;
				}
				TimeUnit.SECONDS.sleep(1);
			}catch(Exception ex){
				ex.printStackTrace();
				error++;
			}
		}
		
		System.out.println("耗时：" + (System.currentTimeMillis() - start));
	 
	
	}
	
	
	public static void jd(){
		
		String url = "http://rain.jd.com/act/record/dispatch";
		HttpClient http = new HttpClient(url);
		try {
			HttpURLConnection connection  = http.createConnection("POST");
			connection.addRequestProperty("Cookie", "_tp=V0C4MEzikX6UX0N67%2FI60OwFAjyZcTnM94cV8%2B%2BCDog%3D; unick=%E5%B0%8F%E4%B9%9E%E4%B8%90_%E8%90%BD%E5%B0%98; _pst=jd_48aec7eeac651; TrackID=1QmOkYQ_O7_jAuf1m-5-8GjBsOq941FqUyTOBbSbeEtnGM8Aw6-GdqO3OUlWAOXLweKp2iGP2PVrPsR8kUF6kwVOIAl9C-16SeVpr-Uwof40; pinId=ZcUVx4aN14MOkBH_wMo4QbV9-x-f3wj7; pin=jd_48aec7eeac651; unpl=V2_bzNtbUsEFhV0CBIBLBkLUmIHElURXxAXIlgVVn4aC1diChBaclRCFXIUR1BnG10UZwAZWUVcQx1FC3ZUfBpVBlcHF1VHVUQUcTh2V3opXARXBxNcR1NBEnMMdmR8KWw1YAYVW0teRhFFCXZVS1IyBCoHE1xHU0EScwx2VQ%3d%3d; dmpjs=dmp-d145138af27fb561961ef1d87a8e7e73209df6d; __jdv=122270672|dmp|dmp_51|cpc|dmp_51_10109_d145138af27fb561961ef1d87a8e7e73209df6d_1464924337; ipLocation=%u56DB%u5DDD; areaId=22; ipLoc-djd=22-1930-50949-0; user-key=e5f26f86-d166-4de7-9ddc-50b8ab3b06e6; cn=0; _rdCube=%7B%22p554460%22%3A%22%2C2447521%22%7D; _jrda=2; thor=B9094346FF7F6E299393986012C855D47AA5B56B14871E20040B7AE7356EEDDA3D41FF33255572E4C54C933E3D3C7D9FA835E96F0F86695928D523237733017D8E655DF7AA7B945A4C31CBED4B805E9B33E0E14D5A004C95CB9D702E9582435C865D0E1FC8C1BC651B0ADD9CC7966DAAFA21E36F689BEFDC5D8A686656277E2E60F33700F5DA0D8D1C3C143BBAEAE0C0560E8C17F35412589BBCAFE74C83C58A; __jda=162662207.500453675.1458369980.1465872809.1465878049.17; __jdb=162662207.11.500453675|17.1465878049; __jdc=162662207; _jrdb=1465880090206; __jdu=500453675; 3AB9D23F7A4B3C9B=4D42BCA618DF43EA4FC2107029EEABD6F5DD6FE0B50119CB930388B48DD59AF2D151FD186CD72A39F3727D607112CA30");
			connection.addRequestProperty("Host", "rain.jd.com");
			connection.addRequestProperty("Cache-Control","max-age=0");
			Map<String, String> data = new HashMap<>();
			data.put("eid", "4D42BCA618DF43EA4FC2107029EEABD6F5DD6FE0B50119CB930388B48DD59AF2D151FD186CD72A39F3727D607112CA30");
			data.put("fp", "6d8fde6276558122a3d14f928b7143b9");
			String msg = http.send(connection, data);
			JSONObject json = JSONObject.parseObject(msg);
			String xx = (String)json.get("msg");
			int type = (int)json.get("type");
			switch (type) {
			case -1:
				System.out.println("妈蛋抽中了空气....");
				break;
			case 0:
				System.out.println("妈蛋抽中了空气....");
				break;
			case 1:
				System.out.println("TMD 优惠券 " + xx);
				break;
			case 2:
				System.out.println("TMD 中了 " + xx);
				break;
			case 3:
				System.out.println("TMD 中了翻倍  " + xx);
				break;
			case 4:
				System.out.println("TMD 优惠券 " + xx);
				break;
			default:
				break;
			}
		} catch (ProtocolException e) {
			e.printStackTrace();  
		} catch (Exception e) {
			e.printStackTrace();  
			
		}
			
	}

	public static void main(String[] args) {
		for(;;){
			jd();
			/*try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();  
				
			}*/
		}
	}
}
