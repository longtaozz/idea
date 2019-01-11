package com.zt.jinanzf.monitor.car.service;


import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.car.model.Car;

public interface CarService {

	/**
	 * @Description: 查询所有车牌
	 * @param param
	 * @return List<Car>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<Car> selectNumberPlate(Map<String,String> param);

	/**
	 * @Description: 车牌查车辆信息（带公司名称的那种）
	 * @param param
	 * @return Car  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Car selectCarAndAll(Map<String,String> param);
	
	/**
	 * 查询指定运输公司车辆信息
	 * @Description: TODO
	 * @param param
	 * @return   
	 * @return List<Car>  
	 * @throws
	 * @author YangXiao
	 * @date 2018年9月28日
	 */
	Page<Car> getEnterpriseNumberPlate(Page<Car> page,Map<String,Object> param);
	
	/**
	 * 根据map值统计车辆数
	 * @Description: TODO
	 * @return    
	 * @return Integer  
	 * @throws
	 * @author YangXiao
	 * @date 2018年10月16日
	 */
	Integer   getCarTotal(Map<String, Object> map);
	
}