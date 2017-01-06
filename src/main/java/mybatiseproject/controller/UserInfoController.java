package mybatiseproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mybatiseproject.service.UserInfoService;
import vo.UserInfo;

@Controller  
@RequestMapping(value="/user")  
public class UserInfoController { 
	@Autowired
	UserInfoService userInfoService;
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