package mybatiseproject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mybatiseproject.dao.FriendCircleDao;
import mybatiseproject.service.FriendCircleService;
import mybatiseproject.util.FileUtil;
import mybatiseproject.util.FormatUtils;
import mybatiseproject.util.PicBagNameEnum;
import mybatiseproject.util.PicUtil;
import mybatiseproject.web.ServletUtil;
import vo.CircleImageVo;
import vo.CircleListVo;
import vo.CircleVo;
@Service
public class FriendCircleServiceImpl implements FriendCircleService{
	@Autowired
	private FriendCircleDao circleDao;
	@Autowired
	private ServletUtil servletUtil;
	@Autowired
	@Qualifier("configProperties")
	private Properties properties;
	@Autowired
	private PicUtil picUtil;
	@Autowired
	private FormatUtils dateUtil;
	@SuppressWarnings("unchecked")
	public String publishCircle(MultipartFile[] imgList, String userId, String dynamicContent){
		List filesName=new ArrayList<>();
		List circleImageVo=new ArrayList<>();
		//圈子主键
		String circleId=UUID.randomUUID().toString();
		//上传图片到服务器
		for(MultipartFile i:imgList){
			String fileName=FileUtil.uploadFile(i, properties.getProperty(PicBagNameEnum.CIRCLE_BAGS.getName()),
					servletUtil.getRequest());
			//如果上传失败返回error
			if(fileName==null)
				return "error";
			//将图片路径补充完整
			String img=picUtil.getTheWholeImageUrl(fileName, PicBagNameEnum.CIRCLE_BAGS.getName());
			filesName.add(img);
			//实例化圈子实体List
			CircleImageVo civ=new CircleImageVo();
			civ.setCircleId(circleId);
			civ.setCircleImg(img);
			circleImageVo.add(civ);
		}
		//判断上传服务器是否成功
		if(filesName.size()!=imgList.length)
		return "error";
		//上传图片地址到数据库并判断是否成功
		if(circleDao.uploadCircleImgList(circleImageVo)<0)
			return "error";
		//发布圈子
		CircleVo circleVo = generateCircleVo(userId, dynamicContent, circleId);
		if(circleDao.publishCircle(circleVo)<=0)
			return "error";
		return "success";
	}
	/**
	 * 查询朋友圈列表
	 * @param friendIds
	 * @return
	 */
	public List<CircleListVo> getCircleList(String userId){
		List<CircleListVo> list=circleDao.getCircleList(userId);
		if(list!=null&&!list.isEmpty())
		{
			//根据circleId查询图片列表
			for(CircleListVo vo:list){
				List<String> imgList=circleDao.getCircleImageList(vo.getId());
				List<String> newList=new ArrayList<>();
				//补充图片路径
				for(String img:imgList){
					newList.add(picUtil.getTheBaseUrl(img));
				}
				vo.setPortrait(picUtil.getTheBaseUrl(vo.getPortrait()));
				vo.setCircleImg(newList);
			}
		}
		return list;
	}
	private CircleVo generateCircleVo(String userId, String dynamicContent, String circleId) {
		CircleVo circleVo=new CircleVo();
		circleVo.setId(circleId);
		circleVo.setUserId(userId);
		circleVo.setDynamicContent(dynamicContent);
		String data =dateUtil.dateToStringFormatToTime();
		circleVo.setReleaseTime(data);
		circleVo.setGoodCount(0);
		return circleVo;
	}
}
