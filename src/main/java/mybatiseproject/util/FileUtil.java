package mybatiseproject.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	/**
	 * 文件上传
	 * @param file 源文件
	 * @param fileDir 文件上传后存储的路径
	 * @param request request
	 * @return
	 */
	public static String uploadFile(MultipartFile file,String fileDir,HttpServletRequest request){
		if(file==null||file.isEmpty())
			return "";
		String path = request.getSession().getServletContext().getRealPath(fileDir);
		String fileName = file.getOriginalFilename();
		String newFileName = UUID.randomUUID().toString().replace("-", "") + fileName.substring(fileName.lastIndexOf("."));
		File targetFile = new File(path, newFileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return newFileName;
	}
}
