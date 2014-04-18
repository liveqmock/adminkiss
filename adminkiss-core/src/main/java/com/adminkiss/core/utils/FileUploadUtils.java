package com.adminkiss.core.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传工具类
 * 
 */
public class FileUploadUtils {
	
	public final static String FILE_IMG_REGEX = "(.*).(jpg|jpeg|bmp|png)"; // 图片文件后缀名正则

	public final static String FILE_RESUME_REGEX = "(.*).(txt|htm|html|mht|pdf|doc|docx|xls|xlsx|wps|rtf)"; // 简历文件后缀名正则
	
	public final static long FILE_RESUME_SIZE = 1024 * 1024 * 2; // 简介文件大小限制2M


	/**
	 * 文件上传(单个)
	 * 
	 * @param request
	 * @param myFile
	 * @param type
	 * @param id
	 * @return
	 */
	public static String uploadFile(MultipartFile myFile,String uploadPath) {
		String filePath = null;
		File uploadPathFile = new File(uploadPath);
		if (!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		if (null != myFile && !myFile.isEmpty()) {
			try {
				String fileName = myFile.getOriginalFilename();
				String saveFileName = fileName.subSequence(0,
						fileName.lastIndexOf("."))
						+ "_"
						+ DateUtils.dateToString(new Date(), 3)
						+ new Random().nextInt(100)
						+ fileName.substring(fileName.lastIndexOf("."));
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
				FileUtils.copyInputStreamToFile(myFile.getInputStream(), new File(uploadPath, saveFileName));
				filePath = uploadPath + "/" + saveFileName;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 * @param type
	 */
	public static void deleteFileByRealPath(String realPath) {
		if (StringUtils.isBlank(realPath)) {
			return;
		}
		File file = new File(realPath);
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

	/**
	 * 文件后缀名校验
	 * 
	 * @param fileName
	 * @param regex
	 * @return
	 */
	public static boolean validateFileType(String fileName, String regex) {
		Pattern p = Pattern.compile(regex);
		return p.matcher(fileName.toLowerCase()).matches();
	}

	/**
	 * 文件大小校验
	 * 
	 * @param fileSize
	 * @param limitSize
	 * @return
	 */
	public static boolean validateFileSize(long fileSize, long limitSize) {
		if (fileSize <= limitSize) {
			return true;
		}
		return false;
	}

}
