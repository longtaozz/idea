/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.carIllegal.service;

import java.util.List;
import java.util.Map;


import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.carIllegal.model.ZtInfringeInfo;
import com.zt.jinanzf.monitor.carruntime.model.CarRuntime;

/**
 * ClassName: CarIllegalService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

public interface CarIllegalService {
	/**
	 * @Description: 查询违法违规次数
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Integer getAllCarIllegalCount();
	
	/**
	 * @Description: 查询所有违法违规数据
	 * @param page
	 * @param params
	 * @return Page<ZtInfringeInfo>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Page<ZtInfringeInfo> getNewCarIllegalListForPage(Page<ZtInfringeInfo> page,Map<?,?> params);
	
	/**
	 * @Description: 查询违法违规详细信息
	 * @param id
	 * @return ZtInfringeInfo  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	ZtInfringeInfo getCarIllegalInfo(String id);
	/**
	 * 
	 * @Description: 查询周边违规信息
	 * @param params
	 * @return ZtInfringeInfo  
	 * @author chenlijun
	 * @date 2018年11月16日
	 */
	List<CarRuntime> getAroundCarIllegalInfo( Map<?,?> params);
}
