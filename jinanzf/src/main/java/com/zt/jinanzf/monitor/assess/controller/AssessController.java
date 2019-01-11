/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月8日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.assess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zt.jinanzf.monitor.assess.model.ZtAssess;
import com.zt.jinanzf.monitor.assess.service.AssessService;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName: AssessController 
 * @Description: 考核评估
 * @author chenlijun
 * @date 2018年10月8日
 */

@RestController
@RequestMapping(value="/project/assess")
public class AssessController {
	@Autowired
	private AssessService assessService;
	
	/**
	 * @Description: 根据城市Id获取所有区域信息
	 * @param params
	 * @return ResponseEntity<List<ZtDistrict>>  
	 * @author chenlijun
	 * @date 2018年10月8日
	 */
	
	@RequestMapping(value="queryAssessList",method=RequestMethod.GET)
	@ApiOperation(value="获取考核评估表信息")
	@ResponseBody
	public ResponseEntity<List<ZtAssess>> getDistrictByCityId(){
		//查询上报执法违规案卷分类 信息
		List<ZtAssess> ztAssess = assessService.queryAssessList();;
		return new ResponseEntity<List<ZtAssess>>(ztAssess,HttpStatus.OK);
	}
}
