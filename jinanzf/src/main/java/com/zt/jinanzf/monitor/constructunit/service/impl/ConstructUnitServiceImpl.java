/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月19日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.constructunit.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.monitor.constructunit.mapper.ConstructUnitMapper;
import com.zt.jinanzf.monitor.constructunit.model.ZtConstructUnit;
import com.zt.jinanzf.monitor.constructunit.service.ConstructUnitService;


/**
 * ClassName: ConstructUnitServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月19日
 */
@Service
public class ConstructUnitServiceImpl implements ConstructUnitService {

	@Autowired
	private ConstructUnitMapper constructUnitMapper;
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.constructunit.service.ConstructUnitService#getConstructUnit(java.lang.String, java.lang.String)
	 */
	@Override
	public ZtConstructUnit getConstructUnit(String ztConstructUnitId, String cityId) {
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("constructUnitId", ztConstructUnitId);
		if (null != cityId && !cityId.equals("")) {
			hashMap.put("cityId", cityId);
		}
		List<ZtConstructUnit> ztConstructUnitList = constructUnitMapper.getConstructUnit(hashMap);
		if(ztConstructUnitList.size()>0){
			ZtConstructUnit ztConstructUnit = ztConstructUnitList.get(0);
			return ztConstructUnit;
		}
		return null;
	}

}
