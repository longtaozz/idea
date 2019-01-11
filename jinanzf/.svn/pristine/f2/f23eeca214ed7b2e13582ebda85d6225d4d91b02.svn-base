/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.company.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.util.StringUtil;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.card.model.Card;
import com.zt.jinanzf.monitor.company.mapper.CompanyMapper;
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;
import com.zt.jinanzf.monitor.company.service.CompanyService;
import com.zt.jinanzf.monitor.consapp.model.ConsappVo;
import com.zt.jinanzf.monitor.district.mapper.DistrictMapper;
import com.zt.jinanzf.monitor.district.model.ZtDistrict;


/**
 * ClassName: CompanyServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private DistrictMapper districtMapper;
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.company.service.CompanyService#getAllCompanyCount()
	 */
	public Integer getAllCompanyCount(){
		return companyMapper.getAllCompanyCount();
	}
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.company.service.CompanyService#queryCompany(java.lang.String, java.lang.String)
	 */
	@Override
	public ZtTransportEnterprises queryCompany(String id, String cityId) {
		Map<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("enterpriseId", id);
		if (null != cityId && !cityId.equals("")) {
			hashMap.put("cityId", cityId);
		}
		List<ZtTransportEnterprises> ztTransportEnterprisesList = companyMapper.queryCompany(hashMap);
		if(ztTransportEnterprisesList.size()>0){
			ZtTransportEnterprises ztTransportEnterprises = ztTransportEnterprisesList.get(0);
			return ztTransportEnterprises;
		}
		return null;
	}
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.company.service.CompanyService#getNewCompanyListForPage(com.baomidou.mybatisplus.plugins.Page, java.util.Map)
	 */
	public Page<ZtTransportEnterprises> getNewCompanyListForPage(Page<ZtTransportEnterprises> page,Map<?,?> params){
		List<ZtTransportEnterprises> companyList = companyMapper.getNewCompanyListForPage(page,params);
		for (int i = 0; i < companyList.size(); i++) {
			/*if(StringUtil.isNotEmpty(companyList.get(i).getRegion())){
				ZtDistrict district = districtMapper.getDistrict(companyList.get(i).getRegion());//.get(Integer.valueOf(companyList.get(i).getRegion()));
				companyList.get(i).setRegion(district.getDistrictName());
				companyList.get(i).setDistrictId(String.valueOf(district.getDistrictId()));
			}*/
			//查询该公司车辆总数
			Integer count = companyMapper.getCompanyCarCount(String.valueOf(companyList.get(i).getEnterpriseId()));
			companyList.get(i).setEnterpriseCarCount(count.toString());
		}
		return page.setRecords(companyList);
	}
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.company.service.CompanyService#getCompanyCarCount(java.lang.String)
	 */
	public Integer getCompanyCarCount(String enterpriseId){
		
		return companyMapper.getCompanyCarCount(enterpriseId);
	}
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.company.service.CompanyService#getCompanyCarInfo(com.baomidou.mybatisplus.plugins.Page, java.util.Map)
	 */
	public Page<Car> getCompanyCarInfo(Page<Car> page,Map<String ,Object> params){
		
		return page.setRecords(companyMapper.getCompanyCarInfo(page, params));
	}
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.company.service.CompanyService#getCompanyCardInfo(com.baomidou.mybatisplus.plugins.Page, java.util.Map)
	 */
	public Page<Card> getCompanyCardInfo(Page<Card> page,Map<String ,Object> params){
		
		return page.setRecords(companyMapper.getCompanyCardInfo(page, params));
	}

	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.company.service.CompanyService#getCompanyConsappInfo(com.baomidou.mybatisplus.plugins.Page, java.util.Map)
	 */
	public Page<ConsappVo> getCompanyConsappInfo(Page<ConsappVo> page,Map<String ,Object> params){
		return page.setRecords(companyMapper.getCompanyConsappInfo(page, params));
	}
}
