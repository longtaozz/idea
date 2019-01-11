/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月19日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.buildunit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.monitor.buildunit.mapper.BuildUnitMapper;
import com.zt.jinanzf.monitor.buildunit.model.ZtBuildunit;
import com.zt.jinanzf.monitor.buildunit.service.BuildUnitService;


/**
 * ClassName: BuildUnitServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月19日
 */

@Service
public class BuildUnitServiceImpl implements BuildUnitService {
	
	@Autowired
	private BuildUnitMapper buildUnitMapper;
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.buildunit.service.BuildUnitService#getBuildById(java.lang.Integer)
	 */
	public ZtBuildunit getBuildById(Integer buildId){
		return buildUnitMapper.getBuildById(buildId);
	}
}
