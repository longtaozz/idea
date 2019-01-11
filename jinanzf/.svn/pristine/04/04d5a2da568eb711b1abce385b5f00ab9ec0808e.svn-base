/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.company.service;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.card.model.Card;
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;
import com.zt.jinanzf.monitor.consapp.model.ConsappVo;

/**
 * ClassName: CompanyService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

public interface CompanyService {
	//获取公司总数 PS:政府用户
	Integer getAllCompanyCount();
	//查询运输公司详细信息
	ZtTransportEnterprises queryCompany(String id,String cityId);
	//主页运输企业数据 PS:政府用户
	Page<ZtTransportEnterprises> getNewCompanyListForPage(Page<ZtTransportEnterprises> page,Map<?,?> params);
	//获取公司车辆总数
	Integer getCompanyCarCount(String enterpriseId);
	//查询指定运输公司车辆
	Page<Car> getCompanyCarInfo(Page<Car> page,Map<String ,Object> params);
	//查询指定运输公司准运核准证
	Page<Card> getCompanyCardInfo(Page<Card> page,Map<String ,Object> params);
	//查询制定运输公司相关工地信息
	Page<ConsappVo> getCompanyConsappInfo(Page<ConsappVo> page,Map<String ,Object> params);
}
