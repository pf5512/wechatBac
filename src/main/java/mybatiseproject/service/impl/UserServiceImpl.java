package mybatiseproject.service.impl;

import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import io.rong.RongCloud;
import io.rong.models.TokenReslut;
import mybatiseproject.dao.UserDao;
import mybatiseproject.service.UserService;
import vo.FriendsListVo;
import vo.LoginInfo;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserDao userDao;

	public ModelMap  login(String userName,String password) throws Exception{
		String appKey = "k51hidwq1ib0b";//替换成您的appkey
    	String appSecret = "0DBRzehWvzMV";//替换成匹配上面key的secret
		LoginInfo loginInfo=userDao.login(userName);
		ModelMap map=new ModelMap();
		if(!loginInfo.getPassword().equals(password))
			return null;
    	RongCloud  rongCloud = RongCloud.getInstance(appKey, appSecret);
    	TokenReslut userGetTokenResult = rongCloud.user.getToken(loginInfo.getOpenId(), loginInfo.getUserName(), "http://www.rongcloud.cn/images/logo.png");
    	map.put("token", userGetTokenResult.getToken());
    	map.put("loginInfo", loginInfo);
    	return map;
	}
	/**
	 * 查询好友列表
	 * @param userId
	 * @return
	 */
	public List<FriendsListVo> userFriends(String userId){
		return userDao.userFriends(userId);
	}
}
