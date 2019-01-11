package com.zt.jinanzf.monitor.carIllegal.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zt.jinanzf.monitor.carIllegal.model.ZtInfringeInfo;

public interface CarIllegalMapper {
	/**
	 * 
	 * @Description: 查询违法违规次数
	 * @return   
	 * @return Integer  
	 * @throws
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	Integer getAllCarIllegalCount();
	
	/**
	 * 
	 * @Description: 查询所有违法违规数据
	 * @param page
	 * @param params
	 * @return List<ZtInfringeInfo>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	List<ZtInfringeInfo> getNewCarIllegalListForPage(Pagination page,Map<? ,?> params);
	
	/**
	 * 
	 * @Description: 查询违法违规详细信息
	 * @param id
	 * @return ZtInfringeInfo  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	ZtInfringeInfo getCarIllegalInfo(String id);
}
