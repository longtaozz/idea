package com.zt.jinanzf.monitor.car.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.car.mapper.CarMapper;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.car.service.CarService;


@Service
public class CarServiceImpl implements CarService{
	@Autowired
	protected CarMapper carMapper;

	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.car.service.CarService#selectNumberPlate(java.util.Map)
	 */
	@Override
	public List<Car> selectNumberPlate(Map<String, String> param) {
		return carMapper.selectNumberPlate(param);
	}

	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.car.service.CarService#selectCarAndAll(java.util.Map)
	 */
	@Override
	public Car selectCarAndAll(Map<String, String> param) {
		return carMapper.selectCarAndAll(param);
	}

	/**
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.car.service.CarService#getEnterpriseNumberPlate(com.baomidou.mybatisplus.plugins.Page, java.util.Map)
	 */
	@Override
	public Page<Car> getEnterpriseNumberPlate(Page<Car> page, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return page.setRecords(carMapper.getEnterpriseNumberPlate(page, param));
	}

	/**
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.car.service.CarService#getCarTotal(java.util.Map)
	 */
	@Override
	public Integer getCarTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return carMapper.getCarTotal(map);
	}


}