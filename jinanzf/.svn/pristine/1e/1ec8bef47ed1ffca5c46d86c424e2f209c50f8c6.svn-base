package com.zt.jinanzf.common.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传类
 * */
public class UploadUtil {

	// 保存文件
	private static String saveFile(HttpServletRequest request, String savePath,
			String saveName, boolean isDefault, boolean isZIP)throws Exception{

		// 获取上传的file
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		java.util.Map<String, MultipartFile> fileMap = multipartRequest
				.getFileMap();
		MultipartFile file = null;

		for (Entry<String, MultipartFile> set : fileMap.entrySet()) {
			set.getKey();// Filedata
			file = set.getValue();// 文件名
		}

		if (file == null) {
			throw new RuntimeException(new Exception("没有查找到文件"));
		}
		String pathName = "";// 文件全路径
		String fileName = "";// 文件名
		if (file.isEmpty()) {
			throw new RuntimeException(new Exception("文件未上传"));
			 
		} else {
			Date date = new Date();// 获取当前时间
	        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmss");
	        int  number=(int)(Math.random() * 100);
	        String fileNameTail = "_" + sdfFileName.format(date) + Integer.toString(number);// 文件名加后加区分
	        
			String _fileName = file.getOriginalFilename();// 文件名
			String suffix = _fileName.substring(_fileName.lastIndexOf("."));// 文件名后缀
			if(".mov".equalsIgnoreCase(suffix)){
				suffix=".mp4";
			}
			String proxy = _fileName.substring(0,_fileName.lastIndexOf("."));
			if (!saveName.equals("")){
				fileName = saveName + fileNameTail + suffix;
			}
			else if (!isDefault){
				// /**使用UUID生成文件名称**/
				fileName = UUID.randomUUID().toString() + fileNameTail  + suffix;
			}else{
				fileName = proxy + fileNameTail +suffix;
			}

			pathName = savePath + File.separator + fileName;

			try {
				/*
				 * CommonsMultipartFile cf= (CommonsMultipartFile)file;
				 * DiskFileItem fi = (DiskFileItem)cf.getFileItem();
				 * 
				 * File f = fi.getStoreLocation(); f.renameTo(restore);
				 */
				if (isZIP) {
					File restore = new File(file.getOriginalFilename());
					file.transferTo(restore);
					pathName = pathName + ".zip";
					// 压缩后的文件
					if (!suffix.equals(".zip")) {
						File zipfile = new File(pathName);
						FileUtil.zipFiles(new File[] { restore }, zipfile);
						restore.delete();

					}
 
					
					// 成功返回路径
					return pathName;
				} else  {
					File restore = new File(pathName);
					file.transferTo(restore);
					// 成功返回路径
					return pathName;
				}  

			} catch (Exception e) {
				throw new RuntimeException(e);

			}
		}

	}

	
	/**
	 * 返回上传的文件名
	 * */
	public static String getUploadFileName(HttpServletRequest request)throws Exception
	{
		// 获取上传的file
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		java.util.Map<String, MultipartFile> fileMap = multipartRequest
				.getFileMap();
		MultipartFile file = null;

		for (Entry<String, MultipartFile> set : fileMap.entrySet()) {
			set.getKey();// Filedata
			file = set.getValue();// 文件名
		}

		if (file == null) {
			throw new RuntimeException(new Exception("没有查找到文件"));
		}
		return  file.getOriginalFilename();
		
	}
	
	
	/**
	 * 保存文件
	 * 
	 * @param request
	 *            前台请求的request
	 * @param savePath
	 *            文件保存到服务器的路径，通过UUID随机生成保存的文件名。
	 * @param isZIP
	 *            是否ZIP格式压缩
	 * @return 成功返回保存路径  ， 失败抛出异常
	 * */
	public static String saveFile(HttpServletRequest request, String savePath,
			boolean isZIP) throws Exception{
		return saveFile(request, savePath, "", false, isZIP);

	}

	/**
	 * 保存文件
	 * 
	 * @param request
	 *            前台请求的request
	 * @param savePath
	 *            文件保存到服务器的路径。
	 * @param saveName
	 *            指定保存的文件名 <b>如果保存路径存在相同命名则覆盖以前的文件，建议在文件名后面加随机值</b>
	 * @param isZIP
	 *            是否ZIP格式压缩
	 * @return 成功返回保存路径 ， 失败抛出异常
	 * */
	public static String saveFile(HttpServletRequest request, String savePath,
			String saveName, boolean isZIP)throws Exception {

		return saveFile(request, savePath, saveName, false, isZIP);

	}

	/**
	 * 保存文件
	 * 
	 * @param request
	 *            前台请求的request
	 * @param savePath
	 *            文件保存到服务器的路径。
	 * @param isDefault
	 *            true使用文件自身的文件名，false随机生成UUID字符串作为文件名
	 * @param isZIP
	 *            是否ZIP格式压缩
	 * @return 成功返回保存路径 ， 失败抛出异常
	 * */
	public static String saveFile(HttpServletRequest request, String savePath,
			boolean isDefault, boolean isZIP)throws Exception {

		return saveFile(request, savePath, "", isDefault, isZIP);

	}
	
}
