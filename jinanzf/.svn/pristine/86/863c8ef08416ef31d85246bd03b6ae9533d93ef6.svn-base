/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月16日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.gpsfence.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zt.jinanzf.monitor.gpsfence.model.Gpsfence;
import com.zt.jinanzf.monitor.gpsfence.service.GpsfenceService;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName: GpsfenceController 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月16日
 */

@RestController
@RequestMapping(value = "/project/gpsfence")
public class GpsfenceController {

	@Autowired
	private GpsfenceService gpsfenceService;
	
	@ResponseBody
	@ApiOperation(value="查询所有消纳场电子围栏")
	@RequestMapping(value = "/getUnloadingGpsfence", method = RequestMethod.POST)
	public ResponseEntity<List<Gpsfence>> getUnloadingGpsfence(@RequestBody Map<String,Object> params) {
		//Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		//Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		//Page<Gpsfence> page = new Page<Gpsfence>(current,size);
		List<Gpsfence> unloadingGpsInfo = gpsfenceService.getUnloadingGpsfence(params);
		if(null != unloadingGpsInfo)
			return new ResponseEntity<List<Gpsfence>>(unloadingGpsInfo,HttpStatus.OK);
		return new ResponseEntity<List<Gpsfence>>(HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ApiOperation(value="查询所有工地电子围栏")
	@RequestMapping(value = "/getConsappGpsfence", method = RequestMethod.POST)
	public ResponseEntity<List<Gpsfence>> getConsappGpsfence(@RequestBody Map<String,Object> params) {
		List<Gpsfence> unloadingGpsInfo = gpsfenceService.getConsappGpsfence( params);
		if(null != unloadingGpsInfo)
			return new ResponseEntity<List<Gpsfence>>(unloadingGpsInfo,HttpStatus.OK);
		return new ResponseEntity<List<Gpsfence>>(HttpStatus.NOT_FOUND);
	}
}
