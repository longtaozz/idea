/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.company.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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
import com.zt.jinanzf.common.util.TokenUtil;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.card.model.Card;
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;
import com.zt.jinanzf.monitor.company.service.CompanyService;
import com.zt.jinanzf.monitor.consapp.model.ConsappVo;
import com.zt.jinanzf.monitor.district.service.DistrictService;
import com.zt.jinanzf.monitor.user.model.User;
import com.zt.jinanzf.monitor.user.service.UserInfoService;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName: CompanyController 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

@RestController
@RequestMapping(value="/project/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private HttpServletRequest request;
	
 	@Value("${jwt.token.header}")
	protected String header;
	
	/**
	 * @Description: 主页运输企业数量
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年7月31日
	 */
	@ApiOperation(value = "获取公司数量")
	@RequestMapping(value="/getAllCompanyCount",method = RequestMethod.GET)
	public Integer getAllCompanyCount() {
		return companyService.getAllCompanyCount();
	}
	
	/**
	 * 主页运输企业数据
	 */
	@ResponseBody
	@ApiOperation(value = "主页运输企业数据")
	@RequestMapping(value = "/getNewCompanyListForPage", method = RequestMethod.POST)
	public ResponseEntity<Page<ZtTransportEnterprises>> getNewCompanyListForPage(@RequestBody Map<?,?> params) {
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<ZtTransportEnterprises> page = new Page<ZtTransportEnterprises>(current, size);
		Page<ZtTransportEnterprises> company = companyService.getNewCompanyListForPage(page,params);
		return new ResponseEntity<Page<ZtTransportEnterprises>>(company,HttpStatus.OK);
	}
	/**
	 * 查询运输公司详细信息
	 */
	@ResponseBody
	@ApiOperation(value = "查询运输公司详细信息")
	@RequestMapping(value = "/getCompanyInfo", method = RequestMethod.POST)
	public ResponseEntity<ZtTransportEnterprises> getCompanyInfo(@RequestBody Map<?,?> params) {
		String id = null == params.get("enterpriseId")?null:params.get("enterpriseId").toString();
		String cityId = null == params.get("cityId")?null:params.get("cityId").toString();
		String proBelong = null == params.get("proBelong")?null:params.get("proBelong").toString();
		Integer companyCarCount = companyService.getCompanyCarCount(id);
		ZtTransportEnterprises company = null;
		company = companyService.queryCompany(id, cityId);
		if(null != company){
		company.setZtDistrict(districtService.getDistrict(proBelong));
		company.setCompanyCarCount(companyCarCount);
		return new ResponseEntity<ZtTransportEnterprises>(company,HttpStatus.OK);
	
		}
	return new ResponseEntity<ZtTransportEnterprises>(company,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * 查询指定运输公司车辆(及运输公司首页车辆数量)
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompanyCarInfo", method = RequestMethod.POST)
	public ResponseEntity<Page<Car>> getCompanyCarInfo(@RequestBody Map<String,Object> params) {
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<Car> page = new Page<Car>(current,size);
		//String [] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("uid", uid[0]);
		//User userObj = userInfoService.getUserInfo(params);
		//String enterpriseId = userObj.getEnterpriseId().toString();
		//params.put("enterpriseId", enterpriseId);
		Page<Car> carInfo = companyService.getCompanyCarInfo(page, params);
	return new ResponseEntity<Page<Car>>(carInfo,HttpStatus.OK);
	}
	/**
	 * 查询指定运输公司准运核准证
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompanyCardInfo", method = RequestMethod.POST)
	public ResponseEntity<Page<Card>> getCompanyCardInfo(@RequestBody Map<String,Object> params) {
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<Card> page = new Page<Card>(current,size);
		//String [] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("uid", uid[0]);
		//User userObj = userInfoService.getUserInfo(map);
		//String enterpriseId = userObj.getEnterpriseId().toString();
		//params.put("enterpriseId", enterpriseId);
		Page<Card> cardInfo = companyService.getCompanyCardInfo(page, params);
	return new ResponseEntity<Page<Card>>(cardInfo,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @Description: 查询指定运输公司相关公司信息
	 * @param params
	 * @return ResponseEntity<Page<Card>>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompanyConsappInfo", method = RequestMethod.POST)
	public ResponseEntity<Page<ConsappVo>> getCompanyConsappInfo(@RequestBody Map<String,Object> params) {
		//String id = null == params.get("enterpriseId")?null:params.get("enterpriseId").toString();
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<ConsappVo> page = new Page<ConsappVo>(current,size);
		String [] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid[0]);
		User userObj = userInfoService.getUserInfo(map);
		String enterpriseId = userObj.getEnterpriseId().toString();
		params.put("enterpriseId", enterpriseId);
		Page<ConsappVo> consappInfo = companyService.getCompanyConsappInfo(page, params);
	return new ResponseEntity<Page<ConsappVo>>(consappInfo,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @Description: 获取指定公司车辆总数
	 * @param params
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年9月27日
	 */
	@ResponseBody
	@RequestMapping(value = "/getCompanyCarCount", method = RequestMethod.POST)
	public Integer getCompanyCarCount(@RequestBody Map<String,Object> params) {
		String [] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid[0]);
		User userObj = userInfoService.getUserInfo(map);
		String enterpriseId = userObj.getEnterpriseId().toString();
		params.put("enterpriseId", enterpriseId);
	return companyService.getCompanyCarCount(enterpriseId);
	}
	
}
