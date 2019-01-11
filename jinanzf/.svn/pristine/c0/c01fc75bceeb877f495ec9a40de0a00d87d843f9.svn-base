package com.zt.jinanzf.monitor.consapp.service;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.consapp.model.Consapp;

import com.zt.jinanzf.monitor.consapp.model.ConsappVo;


public interface ConsappService {
	
	/**
	 * @Description: 查询工地总数
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年7月31日
	 */
	Integer getAllConsappCount(Map<String , Object> map);
	
	/**
	 * @Description:获取垃圾处置核准数据
	 * @param page
	 * @param para
	 * @return Page<ConsappVo>  
	 * @author chenlijun
	 * @date 2018年9月18日
	 */
	Page<ConsappVo> getNewConsappListForPage(Page<ConsappVo> page,Map<?,?> params);
	
	/**
	 * @Description:获取垃圾处置核准详细信息
	 * @param page
	 * @param para
	 * @return Page<ConsappVo>  
	 * @author chenlijun
	 * @date 2018年9月19日
	 */
	ConsappVo getConsappInfo(Map<?,?> params);
	
	/**
	 * @Description: 获取当前位置周边工地信息
	 * @param page
	 * @param params
	 * @return   
	 * @return Page<ConsappVo>  
	 * @throws
	 * @author chenlijun
	 * @date 2018年11月1日
	 */
	Page<ConsappVo> getConsappByPosition(Page<ConsappVo> page,Map<String,Object> params);
	
	/**
	 * 位置采集信息
	 * @param ztConsapp 工地对象
	 * @param  doorPos 手机定位数据
	 * @return  
	 */
	void moveDoorLocation(Consapp ztConsapp,Integer cityId,String doorPos);
	
	/**
	 * 获取大证信息
	 */
	Consapp getConsappInfos(Map<String,Object> params);
}
