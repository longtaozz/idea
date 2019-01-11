/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月16日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.gpsfence.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.monitor.gpsfence.mapper.GpsfenceMapper;
import com.zt.jinanzf.monitor.gpsfence.model.Gpsfence;
import com.zt.jinanzf.monitor.gpsfence.service.GpsfenceService;


/**
 * ClassName: GpsfenceServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月16日
 */

@Service
public class GpsfenceServiceImpl implements GpsfenceService {
	
	@Autowired
	private GpsfenceMapper gpsfenceMapper;
	
	public List<Gpsfence> getUnloadingGpsfence(Map<String, Object> params) {
		
		return gpsfenceMapper.getUnloadingGpsfence( params);
	}
	
	public List<Gpsfence> getConsappGpsfence(Map<String, Object> params) {
		
		return gpsfenceMapper.getConsappGpsfence(params);
	}
	public List<Gpsfence> getFenceByGuid(String guidFence){
		return gpsfenceMapper.getFenceByGuid(guidFence);
	}
}
