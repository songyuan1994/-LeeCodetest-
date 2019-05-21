package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.catalina.connector.Response;
import org.apache.http.client.HttpClient;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenAuthTokenAppQueryRequest;
import com.alipay.api.request.AlipayOpenAuthTokenAppRequest;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.response.AlipayOpenAuthTokenAppQueryResponse;
import com.alipay.api.response.AlipayOpenAuthTokenAppResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserUserinfoShareResponse;
import com.everhomes.util.StringHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@ResponseBody
public class TestController {
	public String openId = "test";
	
	@RequestMapping("/login")
	public String loginTest(String code, HttpServletRequest request)
			throws IOException {
		if (code == null || code.equals("")) {
			System.out.println("NULL");
		} else {
			System.out.println("Code is :" + code);
		}
		String grant_type = "client_credential";
		String appid = "wx7bf4c307bbccd888";
		String secret = "d01397a401ee195f22009b7ec4f529ac";
		String strURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7bf4c307bbccd888&secret=d01397a401ee195f22009b7ec4f529ac";

		String pa_url = "http://localhost:8080/pay/order/createOrder";

		String param = "?grant_type=" + grant_type + "&appid=" + appid
				+ "&secret=" + secret + "&js_code=" + code;

		System.out.println("https://api.weixin.qq.com/sns/jscode2session"+ param);
		String testUrl = "https://api.weixin.qq.com/sns/jscode2session" + param;
		URL url = new URL(testUrl);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.connect();

		// 对应的accseeToke为:"13_Jw6dIQsBuD2e481uzz5esAjPpzf_zYFK68lZiGZMj4a0ROQeHQSdsUUvvsFiBjTDubl3djjJkqZVdatx7iXR5v3FvM8rfwgNJqg-6ta8Of8dxTYObhCg3Xax3jJQkMVurhRVH3rPnxE6nuU9NTHfABAYES"

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpConn.getInputStream()));
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();
		httpConn.disconnect();

		JSONObject json = JSONObject.fromObject(buffer.toString());
		System.out.println(json.toString());
		openId= (String) json.get("openid");
		System.out.println("得到的openId是： " + openId);

		return openId;
	}

	@RequestMapping("/testpay")
	public String testEhPay() throws IOException {
		//cmd.setAccountCode(accountCode);
		Map<String,String> paymentParms = new HashMap<String, String>();
		paymentParms.put("acct", openId);
		System.out.println("openId is :"+openId);
		JSONObject json = new JSONObject();
		json.put("amount", 10L);
		json.put("acct", openId);
		String json_encode=URLEncoder.encode(json.toString());
		
		String strURL = "http://localhost:8280/pay/testPaySDK"+"?cmd="+json_encode;

		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		httpConn.setRequestMethod("POST");
		httpConn.setConnectTimeout(30000);
		//httpConn.setReadTimeout(30000);
		httpConn.setUseCaches(false);
		httpConn.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpConn.getInputStream()));
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			line = new String(line.getBytes(), "utf-8");
			buffer.append(line);
		}
		reader.close();
		httpConn.disconnect();

		System.out.println("结果为： "+buffer.toString());
//		JSONObject json = JSONObject.fromObject(buffer.toString());
//		System.out.println(json.toString());
		
		
		return buffer.toString();
	}
	
	@RequestMapping("/testUser")
	public String testUser() throws IOException{
		String strURL = "http://localhost:8080/pay/user/testCard";
		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		httpConn.setRequestMethod("POST");
		httpConn.setConnectTimeout(30000);
		httpConn.setReadTimeout(30000);
		httpConn.setUseCaches(false);
		httpConn.connect();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpConn.getInputStream()));
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			line = new String(line.getBytes(), "utf-8");
			buffer.append(line);
		}
		reader.close();
		httpConn.disconnect();

		System.out.println("结果为： "+buffer.toString());
		return null;
	}
	
	
	@RequestMapping("/testQc")
	public String testQc(String imgPathEncode,HttpServletResponse response) throws IOException{
		// response.setContentType("jpg");
		String file_name ="testsysssaa222";
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 byte[] b = new byte[1024];
		 response.setHeader("Content-Disposition", "attachment; filename=\"" + file_name+".jpg" + "\"");
		 response.setContentType("application/x-download");
		for(int i=1;i<4;i++){
			 String imgPath = "E:/test/20181227115206.jpg";//URLDecoder.decode(imgPathEncode, "utf-8");
		     File file = new File(imgPath);
		     if(file.exists()) {
		            //FileInputStream in = new FileInputStream(file);
		            BufferedImage buf = ImageIO.read(file); 
		            ImageIO.write(buf, "jpg", out);
		        }
		     System.out.println("返回成功！"+i);
		}
	    OutputStream os = response.getOutputStream(); 
	    b = out.toByteArray();
	    os.write(b);
        os.flush();
        os.close();
		
//		 response.setHeader("Content-Disposition", "attachment; filename=\"" + "testsy.jpg" + "\"");  
//	      // response.addHeader("Content-Length", "" + data.length);  
//	       response.setContentType("application/octet-stream;charset=UTF-8");  
//	        String imgPath = "E:/test/20181227115206.jpg";//URLDecoder.decode(imgPathEncode, "utf-8");
//	        File file = new File(imgPath);
//	        if(file.exists()) {
//	            //FileInputStream in = new FileInputStream(file);
//	            BufferedImage buf = ImageIO.read(file); 
//	            OutputStream os = response.getOutputStream();
//	            ByteArrayOutputStream out = new ByteArrayOutputStream();
//	            ImageIO.write(buf, "jpg", out);
//	            
//	            byte[] b = out.toByteArray();
//	            os.write(b);
//	            //System.out.println("Ins is "+ins.toString());
////	            while(ins.read(b)!= -1) {
////	                os.write(b);
////	            }
//	           // ImageIO.write(buf, "jpg", response.getOutputStream());// 将文件流放入response中
//	            os.flush();
//	            os.close();
//	        }
		return null;
	}
	
	@RequestMapping("/testQc222")
	public String testQc222(String imgPathEncode,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String file_name ="sss_商户收款吗2";
		String decode_file_name = URLEncoder.encode(file_name,"UTF-8");
		 OutputStream os = response.getOutputStream(); 
		 ZipOutputStream zipOutputStream = new ZipOutputStream(os);
		 String agent = request.getHeader("USER-AGENT").toLowerCase();
		 response.setContentType("application/x-download;charset=UTF-8");
		 if (agent.contains("firefox")) {
			 response.setCharacterEncoding("utf-8");
			 response.setHeader("Content-Disposition", "attachment;filename=" + new String(file_name.getBytes(), "ISO8859-1") + ".zip" );
	         System.out.println("fire");
		 	} else {
	        	response.setHeader("Content-Disposition", "attachment;filename=" + decode_file_name + ".zip");
	        }
//		 response.setContentType("application/x-download;charset=UTF-8");
//		 response.setHeader("Content-Disposition", "attachment; filename=\"" + file_name+".zip" + "\"");
		for(int i=1;i<4;i++){
			 String imgPath = "E:/test/20181227115206.jpg";//URLDecoder.decode(imgPathEncode, "utf-8");
		     File file = new File(imgPath);
		     ImageOutputStream im ;
			 InputStream in = null;
			 String dir=".jpg";
		     if(file.exists()) {
		         BufferedImage buf = ImageIO.read(file); 
		    	 String fileName = "sytestIn"+i;
		    	 compressFile(zipOutputStream,dir,fileName,buf);
		        }
		     
		     System.out.println("返回成功！"+i);
		}
        
        
        // 冲刷输出流
        zipOutputStream.flush();
        // 关闭输出流
        zipOutputStream.close();
        os.flush();
        os.close();
        return null;
	}
	
	private static void compressFile(ZipOutputStream zipOutputStream, String dir,String fileName,BufferedImage buf ) throws Exception {
		 try {
             // 压缩文件
             ZipEntry zipEntry = new ZipEntry( fileName+dir);
             zipOutputStream.putNextEntry(zipEntry);
             ImageOutputStream im ;
			 InputStream in = null;
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			im = ImageIO.createImageOutputStream(bs);
			ImageIO.write(buf, "jpg", im);
			in = new ByteArrayInputStream(bs.toByteArray()); 
             // 读取文件
             BufferedInputStream bis = new BufferedInputStream(in);

             int count = 0;
             byte data[] = new byte[2048];
             while ((count = bis.read(data, 0, 2048)) != -1) {
                 zipOutputStream.write(data, 0, count);
             }
             bis.close();
             zipOutputStream.closeEntry();
         } catch (Exception e) {
             throw new Exception(e.getMessage(),e);
         }
	} 
	
	
	public static void fileDownload(final HttpServletResponse response, String filePath, String fileName) throws Exception{  
        
	      // byte[] data = FileUtil.toByteArray2(filePath);  
//	       fileName = URLEncoder.encode(fileName, "UTF-8");  
//	       response.reset();  
//	       response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");  
//	       response.addHeader("Content-Length", "" + data.length);  
//	       response.setContentType("application/octet-stream;charset=UTF-8");  
//	       OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());  
//	       outputStream.write(data);  
//	       outputStream.flush();  
//	       outputStream.close();
//	       response.flushBuffer();
	       
	   } 

	
	@RequestMapping("/testReadQc")
	public String testReadQc(TestReadQcCmd cmd,HttpServletRequest request,HttpServletResponse response) throws IOException{
		Long id = cmd.getId(); 
		System.out.println("The id is {} "+id);
		String userAgent = request.getHeader("User-Agent");
         System.out.println("The User-Agent are : "+userAgent);
            int payWay = 0;
            String agent = userAgent.toLowerCase();
            if (agent.indexOf("micromessenger")>0) {
                //用户使用微信访问页面
                payWay = 1;
                System.out.println("微信...");
                String url ="";//(获取用户授权信息的链接地址)
                response.sendRedirect(url );
            }else if(agent.indexOf("alipayclient")>0){
                //用户使用支付宝访问页面
                payWay = 2;
                System.out.println("支付宝...");
            }
        return null;
	}
	
	
	@RequestMapping("/testAliAouth")	
	  public void  test(String auth_code,HttpServletResponse response) throws Exception{
		  System.out.println("The auth_code are "+auth_code);
		  AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016092300574454","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCijTch3CLi18f/fxZCeFSJnwn5mL1YNMAs4qxoq+GnLYdcMO6vPRim6zq8sIVOWIVaRtNtag2QJR4djob9ofCwZMJ08mtRwaoWmc4vwksQcau6n9JGP3Pyf3nAKQngT3zD/UfS4YPI5yzi2ZPRXlVN1+67GZ4lYx/UCGNvnXzovYwCeG43OrU1k7k/gx+mLYSbIzklZZ0fH5bxcFYS6QcGzZa0x7LD7BFwSYyWlazcQ7wpqVCpDwq0mRKJMlIFRzxqiJwYFyZADg6IBZphq06WylTs+MT6O22oQ0bbRpXoGccSnJRHDe7e6daVsJPjhjY5VRTHW4JdEh0w/M/3Gb21AgMBAAECggEAaCKxvDZr/wkf7lV7bC/scJH7cPRh8N0ydE7vBst+b3xiaDRM5OTuIxk1cuZfMFbTb4dKMaEseTjeNy802c3iBQ836HXZPPIlxf7YsY32St2Xl6KFsk06OZNi6zEfS52An4pmdfnVVGKNRfL/mLSnT4xTO3fo8ai0HkEVes7Y07x5aGwntsmziUO2/kTkoGZvzpLFdhVNlCSIR/56Pfk2xRjryVo+uqswgWiIWpPsoppZgCvaXX1ItG7Id7X2eam8CeZybRlwptnuwy4F/dtVdNcZ/62SGUKvQUeAI8fh66mgZQupzI4g90XuGXp9u9R60l+fU4Um/cmdWvxhpiwi4QKBgQDygF8XjAZ8ygpK2hchdYY0gpQz4e0X53qSjqriwxjbDVsgsRCSPRH+84wrMOAKEw2xZk8Vf/eStnqMrHfmrLKc2hS7AScCOcwzYQono+d1XpPrZS+qbHOwt9rvFD7WEDldL3zzKSykzysr1auTgkbROKCanWhWqdJtBDzCc5V8rQKBgQCrmZCC/1C3vYupTBy3CAtdNh8bvuC4nziBQ4eUGdYIb8/hVV2as4KDI7R/ezUSERNJQJjqVMHlesWWK3e01AidwvwtzEBqKtaTCyYZPO/VVy8bxwrzef1FLILlApuk3v68WDStt/+uhrMtXD5xpkywZGBxx2/nBO6iZackFs6eKQKBgQCBaVxV1pYHtlJzy5sYcf1ivGSWo3TBkvhoidZMGU2EaMY+1f8/63NVGWeuDPEirzRZfX2qvZXDJ7qSo9+ArJzM89yoR18n4uxEZv7iVKfKjORndKJRUnsSzar6d1VpK1NRlWwa39hBQ4WIaQidOaLNOGkM2f+6b/opz18VblVSKQKBgQCXl8n6b+K271P586tKZmjjp3RD5pRPhRk92JJlW42hVmWnAur2R678ewZxuD5h/4OyKsbr/IRuXc8/opbVwJr8A80UCGS/Zai5rheyJAsbxTFwsJ4UCaic+32HIo6tT/JqIOIotWvCmmyfneXsMKV/Dq3E1hMdW1YVUQge8acGQQKBgGdTEWPcEIjXEVGMl0FxM2DYuxKdRgWrG/gab6DUTs+EQAQSr4HtF0cB5yJtqKLzeuW08O6OcHOcJGc4zAsvamoal68te3PdQUVcqJRSHo7yREPkjHGn6136GgxGxVFaYRfhJMFfW7s9fFXYbxAVXm7dOrlkQfpObmphojDm2fkB",
				  "json","utf-8","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxNZ/pweTewA5YoNkiAMASnRLZuS2hKQZuXyQ7LYTQKOOoMFTHdErDCthNjOVi9apvh0jQfPW7p+VsHfbNFbpue2dS8L1b9QCpuD+3xgublPNzmWSjne1eNxB5+ud0hG3ZJ2+Zi4fHL2stoKpOb1GR+kXh1b8WRxMDPIaBCUyy4is9uYYyPCq+j6UtTSbtXHq3l7Iqw4e2h30poRUnWln1cI8cvyivo3PlqBhZq6S60i5rCIf2cxGM5tWWBNkpJyrIvQcedfexF6GFM7bZ5S63ucZWdUbPH6ml7JB6wk3xuuA3anvyvl/3p4U764L1RE7bncBRsiRc4p/V077C0azhQIDAQAB","RSA2");
		 // AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.user.userinfo.share
		
		  AlipaySystemOauthTokenRequest request3 = new AlipaySystemOauthTokenRequest(); 
		  request3.setCode(auth_code);
		  //这个就是第一步获取的auth_code 
		  request3.setGrantType("authorization_code");
		  //这个固定值,参考https://docs.open.alipay.com/api_9/alipay.system.oauth.token
		  AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request3);
		  System.out.println("同步返回结果： "+oauthTokenResponse.getBody());
		  System.out.println("UserId "+oauthTokenResponse.getUserId());
		  
		  
//		  AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();
//		  request.setBizContent("{" +
//				  "    \"grant_type\":\"authorization_code\"," +
//				  "    \"code\":\""+auth_code +
//				  "\"}");
//		  //授权类接口执行API调用时需要带上accessToken
//		
//		  
//		  AlipayOpenAuthTokenAppResponse response= alipayClient.execute(request);
//		  System.out.println("同步返回结果： "+response.getBody());
//		  //获取app_auth_token
//		  String auth_token = response.getAppAuthToken();
//		  String userId  = response.getUserId();
//		  System.out.println("The userId is "+userId);
//		  
//		  AlipayOpenAuthTokenAppQueryRequest request2 = new AlipayOpenAuthTokenAppQueryRequest();
//		  request.setBizContent("{" +
//		  "    \"app_auth_token\":\""+auth_token +
//		  "\"}");
//		  AlipayOpenAuthTokenAppQueryResponse response2 = alipayClient.execute(request2);
//		  
//		  System.out.println("鉴权状态结果： "+response2.getBody());
//		  System.out.println("The userId is "+response2.getUserId());	
		  //System.out.println(response.toString());
		  response.sendRedirect("https://www.baidu.com/");
		 // return "https://www.baidu.com/"; 
		
	  }
	  
	@RequestMapping("/testWechatAouth")	
	  public void  testWechatAouth(HttpServletRequest request,String code,HttpServletResponse response) throws Exception{
		System.out.println("The code are {}"+code);
		String grant_type = "client_credential";
		String appid = "wxb41bf4f38a9ee046";
		
		String sercert = "b4adeea11eca0e0c92447d26ebe9310e";
		String strURL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+sercert+"&code="+code+"&grant_type=authorization_code";


//		String param = "?grant_type=" + grant_type + "&appid=" + appid
//				+ "&secret=" + secret + "&js_code=" + code;

		System.out.println("Url"+ strURL);
//		String testUrl = "https://api.weixin.qq.com/sns/jscode2session" + param;
		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.connect();

		// 对应的accseeToke为:"13_Jw6dIQsBuD2e481uzz5esAjPpzf_zYFK68lZiGZMj4a0ROQeHQSdsUUvvsFiBjTDubl3djjJkqZVdatx7iXR5v3FvM8rfwgNJqg-6ta8Of8dxTYObhCg3Xax3jJQkMVurhRVH3rPnxE6nuU9NTHfABAYES"

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpConn.getInputStream()));
		String line;
		StringBuffer buffer = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();
		httpConn.disconnect();

		JSONObject json = JSONObject.fromObject(buffer.toString());
		System.out.println(json.toString());
		openId= (String) json.get("openid");
		System.out.println("得到的openId是： " + openId);
		
	}
	
	
	
	
	
	
	@RequestMapping("/testReadExcle")	
	  public String testReadExcle() throws Exception{
		
		return null;
	}
	  
	  
}
