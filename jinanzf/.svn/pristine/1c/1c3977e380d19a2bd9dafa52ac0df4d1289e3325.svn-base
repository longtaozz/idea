/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.carIllegal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.util.GeoUtils;
import com.zt.jinanzf.common.util.Point;
import com.zt.jinanzf.monitor.carIllegal.mapper.CarIllegalMapper;
import com.zt.jinanzf.monitor.carIllegal.model.ZtInfringeInfo;
import com.zt.jinanzf.monitor.carIllegal.service.CarIllegalService;
import com.zt.jinanzf.monitor.carruntime.model.CarRuntime;
import com.zt.jinanzf.monitor.carruntime.service.CarRuntimeService;


/**
 * ClassName: CarIllegalServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

@Service
public class CarIllegalServiceImpl implements CarIllegalService {
	
	@Autowired
	CarIllegalMapper carIllegalMapper;
	@Autowired
	CarRuntimeService carRuntimeService;
	
	public Integer getAllCarIllegalCount(){
		return carIllegalMapper.getAllCarIllegalCount();
	}
	
	public Page<ZtInfringeInfo> getNewCarIllegalListForPage(Page<ZtInfringeInfo> page,Map<?,?> params){
		
		return page.setRecords(carIllegalMapper.getNewCarIllegalListForPage(page, params));
	}
	
	public ZtInfringeInfo getCarIllegalInfo(String id){
		return carIllegalMapper.getCarIllegalInfo(id);
	}

	@Override
	public List<CarRuntime> getAroundCarIllegalInfo(Map<?, ?> params) {
		// TODO Auto-generated method stub
		List<CarRuntime> car =carRuntimeService.selectAllCarRuntime();
		List<CarRuntime> carInfo = new ArrayList<CarRuntime>();
		Point g = new Point();
		//lat 伟度  获取两个坐标点之间的距离
		double redius = Double.parseDouble(params.get("redius").toString());
		double distance = 0;
		for(int i = 0;i<car.size();i++){
			if(null != car.get(i).getGpsPosX() && null != car.get(i).getGpsPosY()){
				String gpsX = car.get(i).getGpsPosX().toString();//经度
				String gpsY = car.get(i).getGpsPosY().toString();//纬度
				Point a = new Point(Double.parseDouble(params.get("lng").toString()),Double.parseDouble(params.get("lat").toString()));
				g.setLng(Double.parseDouble(gpsX));//经度
				g.setLat(Double.parseDouble(gpsY));//纬度
				distance = GeoUtils.getDistance(g, a);
			}
			if(redius>distance){
				carInfo.add(car.get(i));
			}
		}
		return carInfo;
	}
}
