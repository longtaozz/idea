package com.zt.jinanzf.monitor.consapp.service.impl;


import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.util.CoordinateConversion;
import com.zt.jinanzf.common.util.GeoUtils;
import com.zt.jinanzf.common.util.Point;
import com.zt.jinanzf.common.util.StringUtil;
import com.zt.jinanzf.monitor.consapp.mapper.ConsappMapper;
import com.zt.jinanzf.monitor.consapp.model.Consapp;
import com.zt.jinanzf.monitor.consapp.model.ConsappVo;
import com.zt.jinanzf.monitor.consapp.service.ConsappService;
import com.zt.jinanzf.monitor.gpsfence.mapper.GpsfenceMapper;
import com.zt.jinanzf.monitor.gpsfence.model.Gpsfence;
import com.zt.jinanzf.monitor.gpsfence.service.GpsfenceService;


@Service
public class ConsappServiceImpl implements ConsappService {
	
	@Autowired
	protected ConsappMapper consappMapper;
	
	@Autowired
	protected GpsfenceService gpsfenceService;
	
	@Autowired 
	protected GpsfenceMapper gpsfenceMapper;
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.consapp.service.ConsappService#getAllConsappCount()
	 */
	@Override
	public Integer getAllConsappCount(Map<String , Object> map){
		return consappMapper.getAllConsappCount(map);
	}
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.consapp.service.ConsappService#getNewConsappListForPage(com.baomidou.mybatisplus.plugins.Page, java.util.Map)
	 */
	@Override
	public Page<ConsappVo> getNewConsappListForPage(Page<ConsappVo> page, Map<?, ?> params) {
		
		return page.setRecords(consappMapper.getNewConsappListForPage(page, params));
	}
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.consapp.service.ConsappService#getConsappInfo(java.util.Map)
	 */
	public ConsappVo getConsappInfo(Map<?,?> params){
		ConsappVo consapp = null;
		List<ConsappVo> consappList = consappMapper.getConsappInfo(params);
		if(null != consappList && consappList.size() > 0){
			consapp = consappList.get(0);
		}
		return consapp;
	}
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.consapp.service.ConsappService#getConsappByPosition(com.baomidou.mybatisplus.plugins.Page, java.util.Map)
	 */
	public Page<ConsappVo> getConsappByPosition(Page<ConsappVo> page,Map<String,Object> params){
		//获取所有工地电子围栏信息
		List<Gpsfence> consappList = gpsfenceService.getConsappGpsfence(params);
		List<ConsappVo> consappInfoList = new ArrayList<ConsappVo>();
		List<Point> geoCoordinateList = new ArrayList<Point>();
		Point g = new Point();
		String[] b = null;
		for(int i = 0;i<consappList.size();i++){
			
			if(null != consappList.get(i).getFencePos() && !consappList.get(i).getFencePos().equals("")){
				//获取单个工地电子围栏坐标
				Gpsfence gps = consappList.get(i);
				String [] consappPos = consappList.get(i).getFencePos().split(";");
				for(int j = 0;j<consappPos.length;j++){
					b = consappPos[j].split(",");
					g.setLng(Double.parseDouble(b[0]));//精度
					g.setLat(Double.parseDouble(b[1]));
					
					geoCoordinateList.add(g);
				}
				//获取工地中心点坐标
				Point  re = GeoUtils.getCenterPoint400(geoCoordinateList);
				
				//lat 伟度  获取两个坐标点之间的距离
				double redius = Double.parseDouble(params.get("redius").toString());
				double distance = GeoUtils.getDistance(re, new Point(Double.parseDouble(params.get("lng").toString()),Double.parseDouble(params.get("lat").toString())));
				if(redius>distance){
					//获取区域内工地信息
					ConsappVo consappInfo =consappMapper.getConsappInfoByPos(gps.getConsappId());
					consappInfo.setGpsPos(gps);
					if(null != consappInfo){
						consappInfoList.add(consappInfo);
						
					}
				}
			}
			
		}
		
		return page.setRecords(consappInfoList);
	}
	
	/**
	 * 手机大门定位
	 * @param ztConsapp  工地对象
	 * @return  doorPos  手机定位数据
	 */
	@Override
	public void moveDoorLocation(Consapp ztConsapp,Integer cityId,String doorPos) {
		
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
		//如果工地大门围栏GUID不等于空，说明该工地还未设置电子围栏信息，直接添加围栏信息。
		if(StringUtil.isNotEmpty(ztConsapp.getGpsAddress())){
			
			List<Gpsfence> gpsfenceList= gpsfenceMapper.getFenceByGuid(ztConsapp.getGpsAddress());
			if(gpsfenceList.size() > 0){
				Gpsfence gpsfence = gpsfenceList.get(0);//找到工地对应的大门围栏对象
					gpsfence.setFencePos(resdoorPos.toString());
					gpsfenceMapper.updateById(gpsfence);
				}else{
					//如果没有直接创建一个大门围栏对象，并添加
					Gpsfence doorGpsfence = new Gpsfence();
					Date date = new Date();// 获取当前时间
			        SimpleDateFormat sdfFileName = new SimpleDateFormat("yyyyMMddHHmmssS");
			        int  number=(int)(Math.random() * 100);
			        String guidFence = sdfFileName.format(date) + Integer.toString(number);
			        doorGpsfence.setGuidFence(guidFence);
			        doorGpsfence.setInsertTime(new Date());
			        doorGpsfence.setFenceName(ztConsapp.getProName());
			        doorGpsfence.setFenceType(12);//设置为大门
			        doorGpsfence.setFencePos(resdoorPos.toString());//设置大门位置数据
			        doorGpsfence.setUnloadingGUID(ztConsapp.getConsGUID());
			        doorGpsfence.setCityId(cityId);
			        gpsfenceMapper.insert(doorGpsfence);  
			        //修改工地的gpsAdress，对应上创建的大门围栏对象
			        ztConsapp.setGpsAddress(guidFence);
			        consappMapper.updateById(ztConsapp);
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
		        doorGpsfence.setFenceName(ztConsapp.getProName());
		        doorGpsfence.setFenceType(12);//设置为大门
		        doorGpsfence.setFencePos(resdoorPos.toString());//设置大门位置数据
		        doorGpsfence.setUnloadingGUID(ztConsapp.getConsGUID());
		        doorGpsfence.setCityId(cityId);
		        gpsfenceMapper.insert(doorGpsfence);  
		        //修改工地的gpsAdress，对应上创建的大门围栏对象
		        ztConsapp.setGpsAddress(guidFence);
		        int x = consappMapper.updateById(ztConsapp);
		        System.out.println(x);
			}
		}
	
	public Consapp getConsappInfos(Map<String ,Object> params){
		return consappMapper.getConsappInfos(params);
	}
}
