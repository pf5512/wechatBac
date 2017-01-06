package mybatiseproject.service;

import java.util.List;

import org.springframework.ui.ModelMap;

import vo.FriendsListVo;
import vo.UserInfo;

public interface UserService {
	/**
	 * 登录
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public ModelMap login(String userName, String password) throws Exception;

	/**
	 * 注册
	 * 
	 * @param userName
	 * @param phone
	 * @param password
	 * @return
	 */
	public String regist(String userName, String phone, String password);

	/**
	 * 发送好友申请
	 * 
	 * @param searchStr
	 * @return
	 */
	public String addFriend(String userId,String friendId);

	/**
	 * 同意好友申请
	 * 
	 * @param friendId
	 * @return
	 */
	public String agreeFriendsApply(String userId,String friendId);

	/**
	 * 查询好友列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<FriendsListVo> userFriends(String userId);

	/**
	 * 查询好友申请列表
	 * 
	 * @param userId
	 * @return
	 */
	public List<FriendsListVo> getApplyFriends(String userId);
	/**
	 * 根据条件查找用户
	 * @param userId
	 * @param searchKey
	 * @return
	 */
	public List<UserInfo> searchFriends(String userId,String searchKey);
}
