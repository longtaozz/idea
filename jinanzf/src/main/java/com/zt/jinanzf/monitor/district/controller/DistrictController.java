/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月8日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.district.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zt.jinanzf.monitor.district.model.ZtDistrict;
import com.zt.jinanzf.monitor.district.service.DistrictService;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName: DistrictController 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月8日
 */

@RestController
@RequestMapping(value="/project/district")
public class DistrictController {
	
	@Autowired
	private DistrictService districtService;
	
	/**
	 * @Description: 根据城市Id获取所有区域信息
	 * @param params
	 * @return ResponseEntity<List<ZtDistrict>>  
	 * @author chenlijun
	 * @date 2018年10月8日
	 */
	@RequestMapping(value="getDistrictByCityId")
	@ApiOperation(value="根据城市Id获取所有区域信息")
	@ResponseBody
	public ResponseEntity<List<ZtDistrict>> getDistrictByCityId(@RequestBody Map<String, ?> params){
		//Integer cityId = Integer.parseInt(params.get("cityId").toString());
		Integer cityId = 250000;
		List<ZtDistrict> district = districtService.getDistrictByCityId(cityId);
		return new ResponseEntity<List<ZtDistrict>>(district,HttpStatus.OK);
	}
}
