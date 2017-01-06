package mybatiseproject.service.impl;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mybatiseproject.dao.UserInfoDao;
import mybatiseproject.service.UserInfoService;
import mybatiseproject.util.FileUtil;
import mybatiseproject.util.PicBagNameEnum;
import mybatiseproject.util.PicUtil;
import mybatiseproject.web.ServletUtil;
import vo.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private ServletUtil servletUtil;
	@Autowired
	@Qualifier("configProperties")
	private Properties properties;
	@Autowired
	private PicUtil picUtil;

	public String updateUserInfo(UserInfo userInfo) {
		if (userInfo == null)
			return "error";
		if (userInfoDao.updateUserInfo(userInfo) > 0)
			return "success";
		return "error";

	}

	/**
	 * 上传头像
	 * 
	 * @param portrait
	 * @return
	 */
	public String upLoadUserPortrait(MultipartFile portrait,String id,String nickName,String sex) {
		String fileName = FileUtil.uploadFile(portrait, properties.getProperty(PicBagNameEnum.PORTRAIT_BAGS.getName()),
				servletUtil.getRequest());
		if (userInfoDao.upLoadUserPortrait(picUtil.getPortraitImages(fileName), id) <= 0)
			return "error";
		UserInfo userInfo=new UserInfo();
		userInfo.setId(id);
		userInfo.setNickName(nickName);
		userInfo.setSex(sex);
		if (userInfoDao.updateUserInfo(userInfo) <= 0)
			return "error";
		return "success";
	}
	/**
	 * 获取用户资料
	 * @param id
	 * @return
	 */
	public UserInfo getUserInfo ( String id){
		UserInfo userInfo=userInfoDao.getUserInfo(id);
		if(userInfo==null)
			return null;
		userInfo.setSex(userInfo.getSex().equals("0")?"女":"男");
		userInfo.setPortrait(picUtil.getImageUrl(userInfo.getPortrait()));
		return userInfo;
	}
}
