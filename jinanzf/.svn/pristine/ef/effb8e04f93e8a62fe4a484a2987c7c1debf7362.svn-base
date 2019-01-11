/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.unloading.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.buildunit.model.ZtBuildunit;
import com.zt.jinanzf.monitor.buildunit.service.BuildUnitService;
import com.zt.jinanzf.monitor.consapp.model.Consapp;
import com.zt.jinanzf.monitor.district.model.ZtDistrict;
import com.zt.jinanzf.monitor.district.service.DistrictService;
import com.zt.jinanzf.monitor.unloading.model.Unloading;
import com.zt.jinanzf.monitor.unloading.service.UnloadingService;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName: UnloadingController 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

@RestController
@RequestMapping(value="/project/unloading")
public class UnloadingController {
	
	@Autowired 
	private UnloadingService unloadingService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private BuildUnitService buildUnitService;
	
	
	@ApiOperation(value="查询所有消纳场总数")
    @RequestMapping(value="getUnloadingAreaCount")
    public Integer getUnloadingAreaCount(){
    	
    	return unloadingService.getUnloadingAreaCount();
    }
	
	@ResponseBody
	@ApiOperation(value="查询所有消纳场信息")
	@RequestMapping(value = "/getNewUnloadingListForPage", method = RequestMethod.POST)
	public ResponseEntity<Page<Unloading>> getNewUnloadingListForPage(@RequestBody Map<?,?> params) {
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<Unloading> page = new Page<Unloading>(current,size);
		Page<Unloading> consappInfo = unloadingService.getNewUnloadingListForPage(page, params);
		if(null != consappInfo)
			return new ResponseEntity<Page<Unloading>>(consappInfo,HttpStatus.OK);
		return new ResponseEntity<Page<Unloading>>(HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings("unused")
	@ResponseBody
	@ApiOperation(value = "获取消纳场详细信息")
	@RequestMapping(value = "/getUnloadingInfo", method = RequestMethod.POST)
	public ResponseEntity<Unloading> getUnloadingInfo(@RequestBody Map<String,Object> params) {
		Unloading unloading = unloadingService.getUnloadingInfo(params);//unloadingId
		String proBelong = null == params.get("proBelong")?"":params.get("proBelong").toString();
		ZtDistrict districtList = districtService.getDistrict(proBelong);//districtId
		ZtBuildunit buildunit = buildUnitService.getBuildById((Integer)params.get("buildunitId"));//buildunitId buildId
		unloading.setDistrictList(districtList);
		unloading.setZtBuildunit(buildunit);
		if(null != unloading)
			return new ResponseEntity<Unloading>(unloading,HttpStatus.OK);
		return new ResponseEntity<Unloading>(unloading,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @Description:  储存采集的消纳场位置信息
	 * @param params
	 * @return ResponseEntity<Page<GpsfenceVo>>  
	 * @author chenlijun
	 * @date 2018年11月1日
	 */
	@ResponseBody
	@RequestMapping(value="saveUnloadByPosition", method = RequestMethod.POST)
	public ResponseEntity<String> saveUnloadByPosition(@RequestBody Map<String,Object> params){
		try {
			Integer cityId =  Integer.parseInt(params.get("cityId").toString());
			Unloading unloading = unloadingService.getUnloadingInfo(params);
			//大门围栏处理
			unloadingService.moveDoorLocation(unloading, cityId, params.get("centerPos").toString());
			return new ResponseEntity<String>("0", HttpStatus.OK);//成功
		} catch (Exception e) {
			return new ResponseEntity<String>("1",HttpStatus.OK);//失败
		}
	}
}
