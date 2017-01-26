package vo;

import java.util.List;

public class CircleListVo {
	public String id;
	public String userId;
	public String portrait;// 头像uri
	public String nickName;// 昵称
	public int goodCount;// 赞数
	public String releaseTime;// 发布时间
	public String dynamicContent;// 动态详情
	public List<String> circleImg;// 图片集合
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getDynamicContent() {
		return dynamicContent;
	}
	public void setDynamicContent(String dynamicContent) {
		this.dynamicContent = dynamicContent;
	}
	public List<String> getCircleImg() {
		return circleImg;
	}
	public void setCircleImg(List<String> circleImg) {
		this.circleImg = circleImg;
	}
}
