package com.zt.jinanzf.monitor.carruntime.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zt.jinanzf.monitor.carruntime.model.CarRuntime;


public interface CarRuntimeMapper {
	
	/**
	 * @Description: 查询车辆实时位置
	 * @param page
	 * @param str
	 * @return List<CarRuntime>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<CarRuntime> selectCarRuntime(Pagination page,Map<String, Object> params);
	
	/**
	 * 根据map统计车辆
	 * @Description: TODO
	 * @param map
	 * @return   
	 * @return Integer  
	 * @throws
	 * @author YangXiao
	 * @date 2018年10月16日
	 */
	Integer  getCarRuntimeTotal(Map<String, Object> map);
	
	
	/**
	 * 查询车辆实时位置
	 * @Description: TODO
	 * @param map
	 * @return   
	 * @return List<CarRuntime>  
	 * @throws 
	 * @author YangXiao
	 * @date 2018年10月16日
	 */
	List<CarRuntime>  getCarRuntime(Map<String, Object> map);
	
	/**
	 * @Description: 查询所有实时信息
	 * @return List<CarRuntime>  
	 * @author chenlijun
	 * @date 2018年11月16日
	 */
	List<CarRuntime> selectAllCarRuntime();
}
