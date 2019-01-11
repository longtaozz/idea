/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月8日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.assess.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.monitor.assess.mapper.AssessMapper;
import com.zt.jinanzf.monitor.assess.model.ZtAssess;
import com.zt.jinanzf.monitor.assess.service.AssessService;


/**
 * ClassName: AssessServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月8日
 */

@Service
public class AssessServiceImpl implements AssessService {

	@Autowired
	private AssessMapper assessMapper;
	
	@Override
	public List<ZtAssess> queryAssessList() {
		return assessMapper.queryAssessList();
	}

	
}
