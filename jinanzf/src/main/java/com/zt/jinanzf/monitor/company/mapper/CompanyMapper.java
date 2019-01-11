/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.company.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.card.model.Card;
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;
import com.zt.jinanzf.monitor.consapp.model.ConsappVo;

/**
 * ClassName: CompanyMapper 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

public interface CompanyMapper {
	/**
	 * 
	 * @Description: 获取公司数量
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Integer getAllCompanyCount();
	
	/**
	 * @Description: 查询运输公司详细信息
	 * @param params
	 * @return List<ZtTransportEnterprises>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<ZtTransportEnterprises> queryCompany(Map<?,?> params);
	
	/**
	 * 
	 * @Description: 主页运输企业数据
	 * @param page
	 * @param params
	 * @return List<ZtTransportEnterprises>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<ZtTransportEnterprises> getNewCompanyListForPage(Pagination page,Map<?,?> params);
	
	/**
	 * @Description: 获取公司车辆总数
	 * @param enterpriseId
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Integer getCompanyCarCount(String enterpriseId);
	
	/**
	 * @Description:查询指定运输公司车辆
	 * @param page
	 * @param params
	 * @return List<Car>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<Car> getCompanyCarInfo( Pagination page ,Map<String ,Object> params);
	
	/**
	 * @Description: 查询指定运输公司核准证信息
	 * @param page
	 * @param params
	 * @return List<Card>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<Card> getCompanyCardInfo( Pagination page ,Map<String ,Object> params);
	
	/**
	 * @Description:查询指定运输公司相关工地信息
	 * @param page
	 * @param params
	 * @return List<ConsappVo>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<ConsappVo> getCompanyConsappInfo( Pagination page ,Map<String ,Object> params); 
}
