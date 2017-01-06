package mybatiseproject.service;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vo.UserInfo;

public interface UserInfoService {
	/**
	  * 更新用户个人信息
	  * @param userInfo
	  * @return
	  */
	public String updateUserInfo (UserInfo portrait);
	/**
	 * 上传头像
	 * @param portrait
	 * @return
	 */
	public String upLoadUserPortrait (MultipartFile portrait,String id,String nickName,String sex);
	/**
	 * 获取用户资料
	 * @param id
	 * @return
	 */
	public UserInfo getUserInfo ( String id);
}
