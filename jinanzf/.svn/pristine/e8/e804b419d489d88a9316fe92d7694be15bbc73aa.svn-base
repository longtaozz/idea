/** 
 *@Project: common-service 
 *@Author: chenlijun
 *@Date: 2018年9月21日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.version.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.monitor.version.mapper.VersionMapper;
import com.zt.jinanzf.monitor.version.model.AppUpdate;
import com.zt.jinanzf.monitor.version.service.VersionService;


/**
 * ClassName: VersionServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月21日
 */

@Service
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionMapper versionMapper;
	
	public AppUpdate queryAppUpdateInfo(){
		return versionMapper.queryAppUpdateInfo();
	}
	
	public int insertAppUpdateInfo(Map<String ,?> param){
		try {
			 versionMapper.insertAppUpdateInfo(param);
			 return 1;
		} catch (Exception e) {
			// TODO: handle exception
			 return 0;
		}
	}
}
