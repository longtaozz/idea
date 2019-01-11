package com.zt.jinanzf.monitor.carruntime.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.conf.DBTypeEnum;
import com.zt.jinanzf.common.conf.DataSourceSwitch;
import com.zt.jinanzf.monitor.car.mapper.CarMapper;
import com.zt.jinanzf.monitor.carruntime.mapper.CarRuntimeMapper;
import com.zt.jinanzf.monitor.carruntime.model.CarRuntime;
import com.zt.jinanzf.monitor.carruntime.service.CarRuntimeService;


@Service
public class CarRuntimeServiceImpl implements CarRuntimeService{
	
	@Autowired
	protected CarRuntimeMapper carRuntimeMapper;
	
	@Autowired
	protected CarMapper carMapper;
	
	//@Autowired
	//protected UserMapper userMapper;
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.carruntime.service.CarRuntimeService#selectCarRuntime(com.baomidou.mybatisplus.plugins.Page, java.util.List)
	 */
	@DataSourceSwitch(DBTypeEnum.gateway)
	public Page<CarRuntime> selectCarRuntime(Page<CarRuntime> page, Map<String, Object> params){
		List<CarRuntime> carIllegal=carRuntimeMapper.selectCarRuntime(page,params);
	
			return page.setRecords(carIllegal);	
	}

	/**
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.carruntime.service.CarRuntimeService#getCarRuntimeTotal(java.util.Map)
	 */
	@Override
	@DataSourceSwitch(DBTypeEnum.gateway)
	public Integer getCarRuntimeTotal(Map<String, Object> map) {
		
		return carRuntimeMapper.getCarRuntimeTotal(map);
	}

	/**
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.carruntime.service.CarRuntimeService#getCarRuntime(java.util.Map)
	 */
	@Override
	@DataSourceSwitch(DBTypeEnum.gateway)
	public List<CarRuntime> getCarRuntime(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return carRuntimeMapper.getCarRuntime(map);
	}
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.carruntime.service.CarRuntimeService#selectAllCarRuntime()
	 */
	@DataSourceSwitch(DBTypeEnum.gateway)
	@Override
	public List<CarRuntime> selectAllCarRuntime() {
		// TODO Auto-generated method stub
		return carRuntimeMapper.selectAllCarRuntime();
	}

	
	

	
}
