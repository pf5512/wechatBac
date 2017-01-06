package mybatiseproject.dao;

import vo.UserInfo;

public interface UserInfoDao {
	public int updateUserInfo (UserInfo userInfo);
	/**
	 * 上传头像
	 * @param portrait
	 * @return
	 */
	public int upLoadUserPortrait (String portrait,String id);
	/**
	 * 获取用户资料
	 * @param id
	 * @return
	 */
	public UserInfo getUserInfo (String id);
}
