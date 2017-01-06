package mybatiseproject.util;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PicUtil {
	@Autowired
	private BufferUtil bufferUtil;
	@Autowired
	@Qualifier("configProperties")
	private Properties properties;
	//补充图片所属包文件名
	public String getPortraitImages(String fileName) {
		String bagPath = properties.getProperty(PicBagNameEnum.PORTRAIT_BAGS.getName());
		return bufferUtil.bufferString(bagPath, "/", fileName);
	}
	//补充图片baseURL前缀名
	public String getImageUrl(String imagePath){
		String basePath = properties.getProperty("pictureUrl");
		return bufferUtil.bufferString(basePath,imagePath).toString();
	}
}
