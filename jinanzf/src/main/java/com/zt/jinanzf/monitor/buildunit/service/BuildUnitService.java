/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月19日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.buildunit.service;

import com.zt.jinanzf.monitor.buildunit.model.ZtBuildunit;

/**
 * ClassName: BuildUnitService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月19日
 */

public interface BuildUnitService {
	/**
	 * @Description:根据ID查询建设单位信息
	 * @param buildId
	 * @return ZtBuildunit  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	ZtBuildunit getBuildById(Integer buildId);
}
