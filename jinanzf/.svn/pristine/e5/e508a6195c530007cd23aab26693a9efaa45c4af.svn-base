/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月16日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.gpsfence.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zt.jinanzf.monitor.gpsfence.model.Gpsfence;

import java.util.List;
import java.util.Map;

/**
 * ClassName: GpsfenceMapper 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月16日
 */
public interface GpsfenceMapper extends BaseMapper<Gpsfence>{
	/**
	 * @Description: 查询所有消纳场电子围栏
	 * @param params
	 * @return List<Gpsfence>  
	 * @author chenlijun
	 * @date 2018年10月16日
	 */
	List<Gpsfence> getUnloadingGpsfence(Map<String, Object> params);
	
	/**
	 * @Description: 查询所有工地电子围栏
	 * @param params
	 * @return List<Gpsfence>  
	 * @author chenlijun
	 * @date 2018年10月16日
	 */
	List<Gpsfence> getConsappGpsfence(Map<String, Object> params);
	
	List<Gpsfence> getFenceByGuid(String guidFence);
}
