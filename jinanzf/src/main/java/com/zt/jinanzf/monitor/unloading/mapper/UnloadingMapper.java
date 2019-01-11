/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.unloading.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zt.jinanzf.monitor.unloading.model.Unloading;

/**
 * ClassName: UnloadingMapper 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

public interface UnloadingMapper extends BaseMapper<Unloading>{
	/**
	 * @Description: 获取消纳场数量
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年8月2日
	 */
	Integer getUnloadingAreaCount();
	
	/**
	 * 
	 * @Description: 查询所有消纳场信息
	 * @param page
	 * @param params
	 * @return List<Unloading>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<Unloading> getNewUnloadingListForPage(Pagination page,Map<? ,?> params);
	
	/**
	 * 
	 * @Description: 获取消纳场详细信息
	 * @param params
	 * @return List<Unloading>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<Unloading> getUnloadingInfo(Map<String ,Object> params);
}
