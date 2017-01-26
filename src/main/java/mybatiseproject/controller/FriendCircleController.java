package mybatiseproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import mybatiseproject.service.FriendCircleService;
import vo.CircleListVo;

@Controller
@RequestMapping(value = "/circle")
public class FriendCircleController {
	@Autowired
	FriendCircleService friendCircleService;

	/**
	 * 发表朋友圈
	 * @param imgUrl
	 * @param userId
	 * @param dynamicContent
	 * @return
	 */
	@RequestMapping(value = "/publishCircle", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap publishCircle(@RequestParam("imgList") MultipartFile[] imgList, @RequestParam String userId,
			@RequestParam String dynamicContent) {
		ModelMap map = new ModelMap();
		map.put("result", friendCircleService.publishCircle(imgList, userId, dynamicContent));
		return map;
	}
	/**
	 * 获取朋友圈列表
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getCircleList", method = RequestMethod.GET)
	@ResponseBody
	public List<CircleListVo> getCircleList(@RequestParam String userId) {
		return friendCircleService.getCircleList(userId);
	}

}