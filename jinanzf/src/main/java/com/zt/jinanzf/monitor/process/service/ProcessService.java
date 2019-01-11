/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月20日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.process.service;

import java.util.Map;


import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.process.model.ZtFlowLogVo;

/**
 * ClassName: ProcessService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年11月20日
 */

public interface ProcessService {
	//查询我的待办件
	Page<ZtFlowLogVo> getMyWorkingList(Page<ZtFlowLogVo> page,Map<String ,Object>params);
	//查询我的已办件
	Page<ZtFlowLogVo> getMyEndWorkingList(Page<ZtFlowLogVo> page, Map<String ,Object> params);
}
