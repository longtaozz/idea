package com.zt.jinanzf.monitor.consapp.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zt.jinanzf.monitor.consapp.model.Consapp;
import com.zt.jinanzf.monitor.consapp.model.ConsappVo;

public interface ConsappMapper extends BaseMapper<Consapp>{
	
	/**
	 * @Description: 获取大证数量
	 * @return Integer  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Integer getAllConsappCount(Map<String , Object> map);
	
	/**
	 * @Description: 获取所有大证信息
	 * @param page
	 * @param params
	 * @return List<ConsappVo>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<ConsappVo> getNewConsappListForPage(Pagination page,Map<? ,?> params);
	
	/**
	 * @Description: 获取大证详细信息
	 * @param params
	 * @return   
	 * @return List<ConsappVo>  
	 * @throws
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<ConsappVo> getConsappInfo(Map<? ,?> params);
	
	/**
	 * 
	 * @Description:获取当前位置周边工地信息
	 * @param consappId
	 * @return ConsappVo  
	 * @author chenlijun
	 * @date 2018年11月1日
	 */
	ConsappVo getConsappInfoByPos(String consappId);
	/**
	 * 
	 * @Description: 获取工地信息
	 * @param params
	 * @return Consapp  
	 * @author chenlijun
	 * @date 2018年11月2日
	 */
	Consapp getConsappInfos(Map<String ,Object> params);
}
