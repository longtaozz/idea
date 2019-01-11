/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月21日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.version.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zt.jinanzf.common.conf.OpResult;
import com.zt.jinanzf.monitor.version.model.AppUpdate;
import com.zt.jinanzf.monitor.version.service.VersionService;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName: VersionController 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月21日
 */

@RestController
@RequestMapping(value="/project/version")
public class VersionController {

	@Autowired
	private VersionService versionService;
	
	@Value("${jinan.file.saveDisk}")
	protected String fileDisk;
	
	@Value("${jwt.token.header}")
	protected String header;
	
	@Value("${jinan.file.url}")
	protected String fileUrl;
	
	/**
	 * @Description: 查询app信息
	 * @return ResponseEntity<AppUpdate>  
	 * @date 2018年9月21日
	 */
	@ApiOperation(value="查询app版本")
    @RequestMapping(value="/queryAppUpdateInfo",method=RequestMethod.POST)
    public ResponseEntity<AppUpdate> queryAppUpdateInfo(){
        	return new ResponseEntity<AppUpdate>(versionService.queryAppUpdateInfo(),HttpStatus.OK);
        }
	/**
	 * @Description: 添加app更新信息
	 * @param param
	 * @return ResponseEntity<OpResult>  
	 * @date 2018年9月21日
	 */
	@ApiOperation(value="添加app更新信息")
    @RequestMapping(value="/insertAppUpdateInfo",method=RequestMethod.POST)
    public ResponseEntity<OpResult> insertAppUpdateInfo(@RequestBody Map<String ,?> param){
		if(null != param.get("downloadUrl")){
			int isSuccess = versionService.insertAppUpdateInfo(param);
	        	if(isSuccess == 1){
	        		return new ResponseEntity<OpResult>(OpResult.INSERT_SUCESS,HttpStatus.OK);}
	        	return new ResponseEntity<OpResult>(OpResult.INSERT_FAIL,HttpStatus.OK);
	        }
		else
			return new ResponseEntity<OpResult>(OpResult.INSERT_FAIL,HttpStatus.OK);
	}
	/**
	 * @Description: apk文件上传
	 * @param file
	 * @throws Exception   
	 * @return ResponseEntity<AppUpdate>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	@ApiOperation(value="apk文件上传")
    @RequestMapping(value="apkUpload",method=RequestMethod.POST)
    public ResponseEntity<AppUpdate> apkUpload(@RequestParam(value = "file",required=false) MultipartFile file) throws Exception{    	 
		 	String oldFileName = file.getOriginalFilename();
			String oldFileSuff = oldFileName.lastIndexOf(".") > 0 ? oldFileName.substring(oldFileName.lastIndexOf(".")) : "";
			String newFilePath = "/attachment/app/apk" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
			String newFilePrev = oldFileName.lastIndexOf(".") > 0 ? oldFileName.substring(0, oldFileName.lastIndexOf(".")) : oldFileName;
			String newFileName = newFilePrev + LocalDateTime.now().format(DateTimeFormatter.ofPattern("_ddHHmmss")) + oldFileSuff;
			File newFile = new File(fileDisk+newFilePath, newFileName);
			File fileDirect = new File(fileDisk+newFilePath);
			if (!fileDirect.exists()) {
				fileDirect.mkdirs();
			}
		try {
				file.transferTo(newFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String url = (fileUrl+newFilePath + "/" + newFileName);
		AppUpdate appUpdate = new AppUpdate();
		appUpdate.setDownloadUrl(url);
   	return new ResponseEntity<AppUpdate>(appUpdate, HttpStatus.OK);
       }
}
