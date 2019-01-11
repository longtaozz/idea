/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.unloading.service.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.util.CoordinateConversion;
import com.zt.jinanzf.common.util.Point;
import com.zt.jinanzf.common.util.StringUtil;
import com.zt.jinanzf.monitor.gpsfence.mapper.GpsfenceMapper;
import com.zt.jinanzf.monitor.gpsfence.model.Gpsfence;
import com.zt.jinanzf.monitor.unloading.mapper.UnloadingMapper;
import com.zt.jinanzf.monitor.unloading.model.Unloading;
import com.zt.jinanzf.monitor.unloading.service.UnloadingService;


/**
 * ClassName: UnloadingServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

@Service
public class UnloadingServiceImpl implements UnloadingService {
	
	@Autowired
	UnloadingMapper unloadingMapper;
	
	@Autowired 
	protected GpsfenceMapper gpsfenceMapper;
	
	public Integer getUnloadingAreaCount(){
		return unloadingMapper.getUnloadingAreaCount();
	}

	public Page<Unloading> getNewUnloadingListForPage(Page<Unloading> page, Map<?, ?> params) {
		
		return page.setRecords(unloadingMapper.getNewUnloadingListForPage(page, params));
	}
	
	public Unloading getUnloadingInfo(Map<String,Object> params){
		Unloading unloading = null;
		List<Unloading> unloadingList = unloadingMapper.getUnloadingInfo(params);
		if(null != unloadingList && unloadingList.size() > 0){
			unloading = unloadingList.get(0);
		}
		return unloading;
	}
	
	/**
	 * 手机大门定位
	 * @param ztUnloadingArea  消纳场对象
	 * @return  doorPos  手机定位数据
	 */
	@Override
	public void moveDoorLocation(Unloading ztUnloadingArea,Integer cityId,String doorPos) {
		
		StringBuffer resdoorPos = new StringBuffer();//定义存入数据中的GPS位置信息
		
		/**---将百度点转化成GPS点----**/
		NumberFormat Park=NumberFormat.getInstance();   
		Park.setMinimumFractionDigits(6);
		if(StringUtil.isNotEmpty(doorPos)){
				double baiduX = Double.valueOf(doorPos.split(",")[0]);
				double baiduY = Double.valueOf(doorPos.split(",")[1]);
				Point point = CoordinateConversion.bd_wgs_encrypts(baiduY, baiduX);
				double gpsX = Double.valueOf(point.getLng());
				double gpsY = Double.valueOf(point.getLat());
				resdoorPos.append(Park.format(gpsX) + ","+Park.format(gpsY));
			}
		/**---将百度点转化成GPS点----**/
		
		//如果消纳场大门围栏GUID不等于空，说明该消纳场还未设置电子围栏信息，直接添加围栏信息。
		if(StringUtil.isNotEmpty(ztUnloadingArea.getGpsAddress())){
			List<Gpsfence> gpsfenceList= gpsfenceMapper.getFenceByGuid(ztUnloadingArea.getGpsAddress());
			if(gpsfenceList.size() > 0){
				Gpsfence gpsfence1 = gpsfenceList.get(0);//找到消纳场对应的大门围栏对象
					gpsfence1.setFencePos(resdoorPos.toString());
					gpsfenceMapper.updateById(gpsfence1);
				}else{
					//如果没有直接创建一个大门围栏对象，并添加
					Gpsfence doorGpsfence = new Gpsfence();
					Date date = new Date();// 获取当前时间
			        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssS");
			        int  number=(int)(Math.random() * 100);
			        String guidFence = sdfFileName.format(date) + Integer.toString(number);
			        doorGpsfence.setGuidFence(guidFence);
			        doorGpsfence.setInsertTime(new Date());
			        doorGpsfence.setFenceName(ztUnloadingArea.getUnloadingName());
			        doorGpsfence.setFenceType(12);//设置为大门
			        doorGpsfence.setFencePos(resdoorPos.toString());//设置大门位置数据
			        doorGpsfence.setUnloadingGUID(ztUnloadingArea.getUnloadingGUID());
			        doorGpsfence.setCityId(cityId);
			        gpsfenceMapper.insert(doorGpsfence);  
			        //修改消纳场的gpsAdress，对应上创建的大门围栏对象
			        ztUnloadingArea.setGpsAddress(guidFence);
			        unloadingMapper.updateById(ztUnloadingArea);	
				}
			}else{
				//如果没有直接创建一个大门围栏对象，并添加
				Gpsfence doorGpsfence = new Gpsfence();
				Date date = new Date();// 获取当前时间
		        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssS");
		        int  number=(int)(Math.random() * 100);
		        String guidFence = sdfFileName.format(date) + Integer.toString(number);
		        doorGpsfence.setGuidFence(guidFence);
		        doorGpsfence.setInsertTime(new Date());
		        doorGpsfence.setFenceName(ztUnloadingArea.getUnloadingName());
		        doorGpsfence.setFenceType(12);//设置为大门
		        doorGpsfence.setFencePos(resdoorPos.toString());//设置大门位置数据
		        doorGpsfence.setUnloadingGUID(ztUnloadingArea.getUnloadingGUID());
		        doorGpsfence.setCityId(cityId);
		        gpsfenceMapper.insert(doorGpsfence);  
		        //修改消纳场的gpsAdress，对应上创建的大门围栏对象
		        ztUnloadingArea.setGpsAddress(guidFence);
		        unloadingMapper.updateById(ztUnloadingArea);
			}
		}
}
