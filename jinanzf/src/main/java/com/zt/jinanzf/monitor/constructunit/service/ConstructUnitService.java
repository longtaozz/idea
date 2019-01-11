/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月19日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.constructunit.service;

import com.zt.jinanzf.monitor.constructunit.model.ZtConstructUnit;

/**
 * ClassName: ConstructUnitService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月19日
 */

public interface ConstructUnitService {
	/**
	 * 
	 * @Description: 根据Id获取施工单位信息
	 * @param ztConstructUnitId
	 * @param cityId
	 * @return ZtConstructUnit  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	ZtConstructUnit getConstructUnit(String ztConstructUnitId,String cityId);
}
