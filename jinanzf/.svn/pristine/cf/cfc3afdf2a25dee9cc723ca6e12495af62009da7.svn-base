/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.unloading.service;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.unloading.model.Unloading;

/**
 * ClassName: UnloadingService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

public interface UnloadingService {
	
	/**
	 * 
	 * @Description: 获取消纳场数量
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Integer getUnloadingAreaCount();
	
	/**
	 * @Description: 查询所有消纳场信息
	 * @param page
	 * @param params
	 * @return Page<Unloading>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Page<Unloading> getNewUnloadingListForPage(Page<Unloading> page,Map<?,?> params);
	
	/**
	 * @Description: 获取消纳场详细信息
	 * @param params
	 * @return Unloading  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Unloading getUnloadingInfo(Map<String,Object> params);
	
	/**
	 * 手机大门定位
	 * @param ztConsapp 工地对象
	 * @param  doorPos 手机定位数据
	 * @return  
	 */
	void moveDoorLocation(Unloading ztUnloadingArea,Integer cityId,String doorPos);
	
}
