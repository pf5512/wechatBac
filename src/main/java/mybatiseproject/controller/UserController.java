package mybatiseproject.controller;

import java.io.Reader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.rong.RongCloud;
import io.rong.models.TokenReslut;
import mybatiseproject.service.UserService;
import vo.FriendsListVo;
import vo.UserInfo;

@Controller  
@RequestMapping(value="/user")  
public class UserController { 
	@Autowired
	UserService aservice;
	
//    @RequestMapping(value="/showUser") 
//    @ResponseBody
//    public String toIndex(HttpServletRequest request,Model model){  
//        model.addAttribute("user", aservice.queryNameService());
//        return aservice.queryNameService();  
//    }  
    
    @RequestMapping(value="/token",method=RequestMethod.GET) 
    @ResponseBody  
    public ModelMap getToken() throws Exception{
    	String appKey = "k51hidwq1ib0b";//替换成您的appkey
    	String appSecret = "0DBRzehWvzMV";//替换成匹配上面key的secret
    	ModelMap map=new ModelMap();
    	Reader reader = null ;
    	RongCloud  rongCloud = RongCloud.getInstance(appKey, appSecret);
    	TokenReslut userGetTokenResult = rongCloud.user.getToken("123", "username", "http://www.rongcloud.cn/images/logo.png");
    	map.put("result", userGetTokenResult.getToken());
    	return map;
    }
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/login",method=RequestMethod.POST) 
    @ResponseBody
    public ModelMap login(String userName,String password) throws Exception{
    	return aservice.login(userName, password);
    }
    /**
     * 注册
     * @param userName
     * @param phone
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/regist",method=RequestMethod.POST) 
    @ResponseBody
    public ModelMap regist(String userName,String phone,String password) {
    	ModelMap map=new ModelMap();
    	map.put("result", aservice.regist(userName, phone, password));
    	return map;
    }
   /**
    * 添加好友
    * @param friendId
    * @return
    */
    @RequestMapping(value="/addFriend",method=RequestMethod.POST) 
    @ResponseBody
    public ModelMap addFriend(String userId,String friendId) {
    	ModelMap map=new ModelMap();
    	map.put("result", aservice.addFriend(userId,friendId));
    	return map;
    }
    /**
     * 同意好友申请
     * @param friendId
     * @return
     */
    @RequestMapping(value="/agreeApply",method=RequestMethod.PUT) 
    @ResponseBody
    public ModelMap agreeFriendsApply(String userId,String friendId) {
    	ModelMap map=new ModelMap();
    	map.put("result", aservice.agreeFriendsApply(userId,friendId));
    	return map;
    }
    /**
     * 获取好友列表
     * @param userId
     * @return
     */
    @RequestMapping(value="/friends",method=RequestMethod.GET) 
    @ResponseBody
    public List<FriendsListVo> userFriends(String userId) {
    	return aservice.userFriends(userId);
    }
    /**
     * 获取好友申请列表
     * @param userId
     * @return
     */
    @RequestMapping(value="/applyFriends",method=RequestMethod.GET) 
    @ResponseBody
    public List<FriendsListVo> getApplyFriends(String userId) {
    	return aservice.getApplyFriends(userId);
    }
    /**
     * 根据条件查找用户
     * @param userId
     * @return
     */
    @RequestMapping(value="/searchFriends",method=RequestMethod.GET) 
    @ResponseBody
    public List<UserInfo> searchFriends(String userId,String searchKey) {
    	return aservice.searchFriends(userId,searchKey);
    }
}  