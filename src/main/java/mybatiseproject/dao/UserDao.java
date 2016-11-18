package mybatiseproject.dao;

import java.util.List;

import vo.FriendsListVo;
import vo.LoginInfo;

public interface UserDao {
	public LoginInfo login(String userName);
	public List<FriendsListVo> userFriends(String userId);
}
