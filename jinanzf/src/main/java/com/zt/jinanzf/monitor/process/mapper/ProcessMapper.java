/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月20日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.process.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zt.jinanzf.monitor.process.model.ZtFlowLogVo;

/**
 * ClassName: ProcessMapper 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年11月20日
 */

public interface ProcessMapper {
	//查询我的代办件
	List<ZtFlowLogVo> getMyWorkingList(Pagination page,Map<String,Object> params);
	//查询我的已办件
	List<ZtFlowLogVo> getMyEndWorkingList(Pagination page, Map<String ,Object> params);
}
