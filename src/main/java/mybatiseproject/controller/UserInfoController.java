package mybatiseproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import mybatiseproject.service.UserInfoService;
import vo.UserInfo;

@Controller  
@RequestMapping(value="/user")  
public class UserInfoController { 
	@Autowired
	UserInfoService userInfoService;
	public static String MASTER_SECRET="243c678f004b52021687a09c";
	public static String APP_KEY="9e99063e3b9568b4dd538881";
    /**
     * 上传头像
     * @param portrait
     * @param id
     * @return
     */
    @RequestMapping(value="/updateUserInfo",method=RequestMethod.POST) 
    @ResponseBody
    public ModelMap updateUserInfo (@RequestParam("portrait") MultipartFile portrait,@RequestParam String id,@RequestParam String nickName,@RequestParam String sex) {
    	ModelMap map=new ModelMap();
    	map.put("result", userInfoService.upLoadUserPortrait(portrait,id,nickName,sex));
    	return map;
    }
    /**
     * 获取用户资料
     * @param id
     * @return
     */
    @RequestMapping(value="/getUserInfo",method=RequestMethod.GET) 
    @ResponseBody
    public UserInfo getUserInfo (@RequestParam String id) {
    	return userInfoService.getUserInfo(id);
    }
   

}  