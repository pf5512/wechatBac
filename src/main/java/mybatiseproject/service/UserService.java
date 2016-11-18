package mybatiseproject.service;


import java.util.List;

import org.springframework.ui.ModelMap;

import vo.FriendsListVo;

public interface UserService {
	/**
	 * 登录
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	public ModelMap login(String userName,String password) throws Exception;
	/**
	 * 查询好友列表
	 * @param userId
	 * @return
	 */
	public List<FriendsListVo> userFriends(String userId);
}
