/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月17日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.consapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;
import com.zt.jinanzf.monitor.company.service.CompanyService;
import com.zt.jinanzf.monitor.consapp.model.Consapp;
import com.zt.jinanzf.monitor.consapp.model.ConsappVo;
import com.zt.jinanzf.monitor.consapp.service.ConsappService;
import com.zt.jinanzf.monitor.constructunit.model.ZtConstructUnit;
import com.zt.jinanzf.monitor.constructunit.service.ConstructUnitService;
import com.zt.jinanzf.monitor.district.model.ZtDistrict;
import com.zt.jinanzf.monitor.district.service.DistrictService;

import io.swagger.annotations.ApiOperation;


/**
 * ClassName: ConsappController 
 * @Description: 处置证api接口服务
 * @author chenlijun
 * @date 2018年9月17日
 */

@RestController
@RequestMapping(value = "/project/consapp")
public class ConsappController {
	
	@Autowired
	private ConsappService consappService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private BuildUnitService buildUnitService;
	
	@Autowired
	private ConstructUnitService constructUnitService;
	
	@Autowired
	private CompanyService companyService;
	
	@Value("${jwt.token.header}")
	protected String header;
	
	//@Autowired
	//private  UserUtil   userUtil;
	/**
	 * @Description: 获取大证数量
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年7月31日
	 */
	@ApiOperation(value = "获取大证数量")
	@RequestMapping(value="/getAllConsappCount",method = RequestMethod.GET)
	public Integer getAllConsappCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		//User userObj = userUtil.getYlUserInfo();
		//String enterpriseId = (null == userObj.getEnterpriseId() || userObj.getEnterpriseId().equals("")?"":userObj.getEnterpriseId().toString());
		//map.put("enterpriseId", enterpriseId);
		return consappService.getAllConsappCount(map);
	}
	
	/**
	 * 根据当前登陆运输公司ID 查询运输公司主签工地数
	 * @Description: TODO
	 * @return   
	 * @return Integer  
	 * @throwsgetEnterpriseConsappCount
	 * @author YangXiao
	 * @date 2018年9月27日
	 */
	@ApiOperation(value = "获取大证数量")
	@RequestMapping(value="/getEnterpriseConsappCount",method = RequestMethod.GET)
	public Integer getEnterpriseConsappCount() {
		Map<String, Object> map = new HashMap<String, Object>();
		//User userObj = userUtil.getYlUserInfo();
		//String enterpriseId = userObj.getEnterpriseId().toString();
		//map.put("enterpriseId", enterpriseId);
		return consappService.getAllConsappCount(map);
	}
	
	/**
	 * @Description: 获取垃圾处置核准数据
	 * @param session
	 * @param dataTable
	 * @param page
	 * @param rows
	 * @param pagination
	 * @return ResponseObject  
	 * @author chenlijun
	 * @date 2018年9月18日
	 */
	@ResponseBody
	@ApiOperation(value = "获取所有大证信息")
	@RequestMapping(value = "/getNewConsappListForPage", method = RequestMethod.POST)
	public ResponseEntity<Page<ConsappVo>> getNewConsappListForPage(@RequestBody Map<?,?> params) {
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<ConsappVo> page = new Page<ConsappVo>(current,size);
		Page<ConsappVo> consappInfo = consappService.getNewConsappListForPage(page, params);
		if(null != consappInfo)
			return new ResponseEntity<Page<ConsappVo>>(consappInfo,HttpStatus.OK);
		return new ResponseEntity<Page<ConsappVo>>(HttpStatus.NOT_FOUND);
	}
	
	
	/**
	 * @Description: 获取大证详细信息
	 * @param params
	 * @return ResponseEntity<Page<ConsappVo>>  
	 * @author chenlijun
	 * @date 2018年9月19日
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@ApiOperation(value = "获取大证详细信息")
	@RequestMapping(value = "/getConsappInfo", method = RequestMethod.POST)
	public ResponseEntity<ConsappVo> getConsappInfo(@RequestBody Map<?,?> params) {
		ConsappVo consappInfo = consappService.getConsappInfo(params);
		String cityId = null == params.get("cityId")? "":params.get("cityId").toString();
		String proBelong = null == params.get("proBelong")? "":params.get("proBelong").toString();
		ZtDistrict districtList = districtService.getDistrict(proBelong);
		ZtBuildunit buildunit=buildUnitService.getBuildById(consappInfo.getConstrId());
		ZtConstructUnit ztConstructUnit = null;
		if(null != consappInfo.getResponsId() && !consappInfo.getResponsId().equals("")){
			ztConstructUnit=constructUnitService.getConstructUnit(consappInfo.getResponsId().toString(), cityId);
		}
		ZtTransportEnterprises ztTransportEnterprises = null;
		if(null != consappInfo.getTransId() && !consappInfo.getTransId().equals("")){
			ztTransportEnterprises =companyService.queryCompany(consappInfo.getTransId().toString(),cityId);
		}
		consappInfo.setDistrictList(districtList);
		consappInfo.setZtBuildunit(buildunit);
		consappInfo.setZtConstructUnit(ztConstructUnit);
		consappInfo.setZtTransportEnterprises(ztTransportEnterprises);
		if(null != consappInfo)
			return new ResponseEntity<ConsappVo>(consappInfo,HttpStatus.OK);
		return new ResponseEntity<ConsappVo>(consappInfo,HttpStatus.NOT_FOUND);
	}
	/**
	 * @Description:  获取当前位置周边工地信息
	 * @param params
	 * @return ResponseEntity<Page<GpsfenceVo>>  
	 * @author chenlijun
	 * @date 2018年11月1日
	 */
	@ResponseBody
	@RequestMapping(value="getConsappByPosition", method = RequestMethod.POST)
	public ResponseEntity<Page<ConsappVo>> getConsappByPosition(@RequestBody Map<String,Object> params){
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<ConsappVo> page = new Page<ConsappVo>(current, size);
	
		Page<ConsappVo> consappInfo = consappService.getConsappByPosition(page ,params);
		if(null != consappInfo)
		return new ResponseEntity<Page<ConsappVo>>(consappInfo, HttpStatus.OK);
		
		return new ResponseEntity<Page<ConsappVo>>(HttpStatus.NOT_FOUND);
	}
	/**
	 * @Description:  储存采集的工地位置信息
	 * @param params
	 * @return ResponseEntity<Page<GpsfenceVo>>  
	 * @author chenlijun
	 * @date 2018年11月1日
	 */
	@ResponseBody
	@RequestMapping(value="saveConsappByPosition", method = RequestMethod.POST)
	public ResponseEntity<String> saveConsappByPosition(@RequestBody Map<String,Object> params){
		try {
			Integer cityId =  Integer.parseInt(params.get("cityId").toString());
			Consapp consapp = consappService.getConsappInfos(params);
			//大门围栏处理
			consappService.moveDoorLocation(consapp, cityId, params.get("centerPos").toString());
			return new ResponseEntity<String>("0", HttpStatus.OK);//成功
		} catch (Exception e) {
			return new ResponseEntity<String>("1",HttpStatus.OK);//失败
		}
		
		
		
	}
	
}
