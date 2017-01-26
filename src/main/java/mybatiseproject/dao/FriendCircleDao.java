package mybatiseproject.dao;

import java.util.List;

import vo.CircleImageVo;
import vo.CircleListVo;
import vo.CircleVo;

public interface FriendCircleDao {
	//发表圈子
	public int publishCircle(CircleVo circleVo);
	//上传圈子地址图片
	public int uploadCircleImgList(List<CircleImageVo> circleImageVo);
	//获取圈子列表
	public List<CircleListVo> getCircleList(String userId);
	//获取圈子列表
	public List<String> getCircleImageList(String circleId);
}
