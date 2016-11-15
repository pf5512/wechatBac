package mybatiseproject.controller;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.rong.RongCloud;
import io.rong.models.TokenReslut;
import mybatiseproject.service.AService;

@Controller  
@RequestMapping(value="/user")  
public class UserController { 
	@Autowired
	AService aservice;
	
    @RequestMapping(value="/showUser") 
    @ResponseBody
    public String toIndex(HttpServletRequest request,Model model){  
        model.addAttribute("user", aservice.queryNameService());
        return aservice.queryNameService();  
    }  
    
    @RequestMapping(value="/token") 
    @ResponseBody
    public ModelMap getToken() throws Exception{
    	String appKey = "k51hidwq1ib0b";//替换成您的appkey
    	String appSecret = "0DBRzehWvzMV";//替换成匹配上面key的secret
    	ModelMap map=new ModelMap();
    	Reader reader = null ;
    	RongCloud  rongCloud = RongCloud.getInstance(appKey, appSecret);
    	TokenReslut userGetTokenResult = rongCloud.user.getToken("userId1", "username", "http://www.rongcloud.cn/images/logo.png");
    	map.put("result", userGetTokenResult.getToken());
    	return map;
    }
    
}  