package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    
    
//    public class AliArTestAction {
//    	private static final long serialVersionUID = 1L;/*APPID*/
//    	private static final String APP_ID = "20***50023260";/*应用私钥 —— 本地生成的私钥*/
//    	private static final String APP_PRIVATE_KEY = "应用私钥2048";/*支付宝公钥 —— 应用公钥对应的支付宝公钥*/
//    	private static final String ALIPAY_PUBLIC_KEY = "支付宝公钥";/*访问应用授权URL时会自动生成 app_auth_code * 
//    	url 拼接: https://openauth.alipaydev.com/oauth2/appToAppAuth.htm?app_id=2016081500253260&;redirect_uri=http://127.0.0.1:8080/aliar_tools/aliar/aliartest.action */
//    	private String app_auth_code;
//    	
//    	public String getApp_auth_code() {
//    		return app_auth_code;}
//    	public void setApp_auth_code(String app_auth_code)
//    	{ this.app_auth_code = app_auth_code;}
//    	
//    	public String aliartest(){
//    		String str = ""; System.out.println("app_auth_code = "+app_auth_code); 
//    		/** 正式环境下的网关 : https://openapi.alipay.com/gateway.do* 沙箱下的网关: https://openapi.alipaydev.com/gateway.do*
//    		 * /// AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",APP_ID,APP_PRIVATE_KEY,"json","GBK",ALIPAY_PUBLIC_KEY,"RSA2");AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",APP_ID,APP_PRIVATE_KEY,"json","GBK",ALIPAY_PUBLIC_KEY,"RSA2"); 
//    		 * AlipayOpenAuthTokenAppRequest request = new AlipayOpenAuthTokenAppRequest();/** grant_type : 授权类型 ; 如果使用app_auth_code换取token,则为authorization_code,如果使用refresh_token换取新的token,则为refresh_token* code : 授权码 ;
//    		 *  与refresh_token二选一,用户对应用授权后得到,即第一步中开发者获取到的app_auth_code值* refresh_token : 刷新令牌 ; 与code二选一,可为空,刷新令牌时使用*/ 
//    		request.setBizContent("{" + "/"grant_type/":/"authorization_code/"," +"/"code/":/""+ app_auth_code +"/"" + //"/"refresh_token/":/""+ refresh_token +"/"" +"}"); 
//    		 AlipayOpenAuthTokenAppResponse response; 
//    		try {response = alipayClient.execute(request); 
//    		if(response.isSuccess()){ System.out.println("调用成功");} 
//    		else { System.out.println("调用失败");}
//    		str = response.getBody();System.out.println(response.getBody()); }
//    		catch (AlipayApiException e) {// TODO Auto-generated catch blocke.printStackTrace();
//    			str = "{/"resultCode/":-1,/"resultDesc/":/"aliartest异常/",/"res/":[]}"; }
//    		ServletActionContext.getRequest().setAttribute("userXml",str); return SUCCESS;}}
//    		}
//    	}
//    }
}
