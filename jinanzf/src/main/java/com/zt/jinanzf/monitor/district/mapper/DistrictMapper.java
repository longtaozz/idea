/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月19日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.district.mapper;


import java.util.List;

import com.zt.jinanzf.monitor.district.model.ZtDistrict;

/**
 * ClassName: DistrictMapper 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月19日
 */

public interface DistrictMapper {
	/**
	 * @Description: 获取区域信息
	 * @param proBelong
	 * @return ZtDistrict  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	ZtDistrict getDistrict(String proBelong);
	
	/**
	 * 
	 * @Description: 查找全部区域信息
	 * @param cityId
	 * @return List<ZtDistrict>  
	 * @author chenlijun
	 * @date 2018年10月8日
	 */
	List<ZtDistrict> getDistrictByCityId(Integer cityId);
}
