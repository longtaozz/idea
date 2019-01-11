/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月20日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.process.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.process.mapper.ProcessMapper;
import com.zt.jinanzf.monitor.process.model.ZtFlowLogVo;
import com.zt.jinanzf.monitor.process.service.ProcessService;


/**
 * ClassName: ProcessServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年11月20日
 */

@Service
public class ProcessServiceImpl implements ProcessService {
	
	@Autowired
	private ProcessMapper processMapper;
	
	public Page<ZtFlowLogVo> getMyWorkingList(Page<ZtFlowLogVo> page,Map<String ,Object> params){
		List<ZtFlowLogVo> ztflowLog =processMapper.getMyWorkingList(page,params);
		
		return page.setRecords(ztflowLog);
	}

	@Override
	public Page<ZtFlowLogVo> getMyEndWorkingList(Page<ZtFlowLogVo> page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<ZtFlowLogVo> ztflowLog =processMapper.getMyEndWorkingList(page, params);
		return page.setRecords(ztflowLog);
	}
}
