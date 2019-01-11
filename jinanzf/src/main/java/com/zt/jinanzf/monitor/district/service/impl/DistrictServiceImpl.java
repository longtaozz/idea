/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月19日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.district.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.monitor.district.mapper.DistrictMapper;
import com.zt.jinanzf.monitor.district.model.ZtDistrict;
import com.zt.jinanzf.monitor.district.service.DistrictService;


/**
 * ClassName: DistrictServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月19日
 */
@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictMapper districtMapper;
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.district.service.DistrictService#getDistrict(java.lang.String)
	 */
	@Override
	public ZtDistrict getDistrict(String proBelong) {
		return districtMapper.getDistrict(proBelong);
	}

	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.district.service.DistrictService#getDistrict(java.lang.Integer)
	 */
	@Override
	public List<ZtDistrict> getDistrictByCityId(Integer cityId) {
		return districtMapper.getDistrictByCityId(cityId);
	}

}
