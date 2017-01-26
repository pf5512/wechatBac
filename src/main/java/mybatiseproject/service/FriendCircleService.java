package mybatiseproject.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vo.CircleListVo;

public interface FriendCircleService {
	/**
	 * 发布朋友圈
	 * @param imgList
	 * @param userId
	 * @param dynamicContent
	 * @return
	 */
	public String publishCircle(MultipartFile[] imgList, String userId, String dynamicContent);
	/**
	 * 查询朋友圈列表
	 * @param friendIds
	 * @return
	 */
	public List<CircleListVo> getCircleList(String userId);
}
