package mybatiseproject.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import io.rong.RongCloud;
import io.rong.models.TokenReslut;
import mybatiseproject.dao.UserDao;
import mybatiseproject.service.UserService;
import mybatiseproject.util.PicUtil;
import vo.FriendsListVo;
import vo.LoginInfo;
import vo.UserInfo;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	UserDao userDao;
	@Autowired
	private PicUtil picUtil;
	public ModelMap  login(String userName,String password) throws Exception{
		String appKey = "k51hidwq1ib0b";//替换成您的appkey
    	String appSecret = "0DBRzehWvzMV";//替换成匹配上面key的secret
		LoginInfo loginInfo=userDao.login(userName);
		ModelMap map=new ModelMap();
		if(!loginInfo.getPassword().equals(password))
			return null;
    	RongCloud  rongCloud = RongCloud.getInstance(appKey, appSecret);
    	TokenReslut userGetTokenResult = rongCloud.user.getToken(loginInfo.getId(), loginInfo.getUserName(), "http://www.rongcloud.cn/images/logo.png");
    	//补充头像前缀
    	loginInfo.setPortrait(picUtil.getImageUrl(loginInfo.getPortrait()));
    	map.put("token", userGetTokenResult.getToken());
    	map.put("loginInfo", loginInfo);
    	return map;
	}
	/**
	 * 注册
	 * @param userName
	 * @param phone
	 * @param password
	 * @return
	 */
	public String regist(String userName,String phone,String password){
		if(userDao.login(userName)!=null)
			return "user exist";
		LoginInfo userInfo=new LoginInfo();
		userInfo.setId(UUID.randomUUID().toString());
		userInfo.setUserName(userName);
		userInfo.setPhone(phone);
		userInfo.setPassword(password);
		userInfo.setSex("1");
		userInfo.setNickName("新用户");
		int i=userDao.regist(userInfo);
		if(i<=0)
			return "error";
		return "success";
	}
	/**
	 * 发送好友申请
	 * @param searchStr
	 * @return
	 */
	public String addFriend(String userId,String friendId){
		int i= userDao.addFriend(userId, friendId,"0");
		if(i<=0)
			return "error";
		return "success";
	}
	/**
	 * 同意好友申请
	 * @param friendId
	 * @return
	 */
	@Transactional(noRollbackFor = {
			RuntimeException.class }, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public String agreeFriendsApply(String userId,String friendId){
		 int i=0;
		 int j=0;//改变状态返回结果
		 try {
			//此处的userId代表被申请人 也就是表中的friendId,此处的friendId为申请人 也就是表中的userId
			 j=userDao.changeApplyState(userId,friendId);
			 if(j<=0)
				 return "error";
			 i= userDao.addFriend(userId, friendId,"1");
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		 
		if(i<=0)
			return "error";
		return "success";
	}
	/**
	 * 查询好友列表 
	 *  
	 * @param userId
	 * @return
	 */
	public List<FriendsListVo> userFriends(String userId){
		List<FriendsListVo> list=userDao.userFriends(userId);
		for(FriendsListVo i:list){
			i.setPortrait(picUtil.getImageUrl(i.getPortrait()));
		}
		return list;
	}
	/**
	 * 查询好友申请列表 
	 */
	public List<FriendsListVo> getApplyFriends(String userId){
		return userDao.getApplyFriends(userId);
	}
	/**
	 * 根据条件查找用户
	 * @param userId
	 * @param searchKey
	 * @return
	 */
	public List<UserInfo> searchFriends(String userId,String searchKey){
		if(userDao.isfriendsExit(userId, searchKey).size()==0)
			return userDao.searchFriends(searchKey);
		return null;
	}
}
