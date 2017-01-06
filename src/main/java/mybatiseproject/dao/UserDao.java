package mybatiseproject.dao;

import java.util.List;

import vo.FriendsListVo;
import vo.LoginInfo;
import vo.UserInfo;

public interface UserDao {
	/**
	 * 登录
	 * @param userName
	 * @return
	 */
	public LoginInfo login(String userName);
	/**
	 * 注册
	 * @param userName
	 * @param phone
	 * @param password
	 * @return
	 */
	public int regist(LoginInfo loginInfo);
	/**
	 * 申请为好友
	 * @param friendId
	 * @return
	 */
	public int addFriend(String userId,String friendId,String state);
	/**
	 * 改变申请状态
	 * @param 此处的friendId为被申请人，也就是userID，此处的userId为申请人，也就是friendId
	 * @return
	 */
	public int changeApplyState(String friendId,String userId);
	/**
	 * 查询好友列表
	 * @param userId
	 * @return
	 */
	public List<FriendsListVo> userFriends(String userId);
	/**
	 * 查询好友申请列表
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
	public List<UserInfo> searchFriends(String searchKey);
	/**
	 * 根据条件查找用户是否存在
	 * @param userId
	 * @param searchKey
	 * @return
	 */
	public List<UserInfo> isfriendsExit(String userId,String searchKey);
}
