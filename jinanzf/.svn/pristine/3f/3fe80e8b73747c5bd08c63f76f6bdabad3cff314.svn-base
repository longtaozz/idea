/** 
 *@Project: jinanzf 
 *@Author: YangXiao
 *@Date: 2018年11月23日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.record.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.record.mapper.PushRecordMapper;
import com.zt.jinanzf.monitor.record.model.PushRecordVo;
import com.zt.jinanzf.monitor.record.model.ZtTelChart;
import com.zt.jinanzf.monitor.record.service.PushRecordService;

/**
 * ClassName: PushRecordServiceImpl 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年11月23日
 */

@Service
public class PushRecordServiceImpl   implements  PushRecordService{

	@Autowired
	protected PushRecordMapper pushRecordMapper;
	
	/**
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.record.service.PushRecordService#setPushRecord(java.util.Map)
	 */
	public int setPushRecord(Map<String, Object> map) {
		//PushRecord  pushRecord =(PushRecord) map.get("pushRecord");
		return pushRecordMapper.setPushRecord(map);
	}

	/**
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.record.service.PushRecordService#upPushRecord(java.util.Map)
	 */
	public int upPushRecord(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pushRecordMapper.upPushRecord(map);
	}

	/**
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.record.service.PushRecordService#getPushRecordVo(java.util.Map)
	 */
	public Page<PushRecordVo> getPushRecordVo(Page<PushRecordVo> page,Map<String, Object> map) {
		// TODO Auto-generated method stub
		return page.setRecords(pushRecordMapper.getPushRecordVo(page,map));
	}
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.record.service.PushRecordService#getZtTelChartInfo(java.util.Map)
	 */
	public ZtTelChart getZtTelChartInfo(Map<String, Object> map){
		return pushRecordMapper.getZtTelChartInfo(map);
	}

	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.record.service.PushRecordService#getPushRecordCount(java.util.Map)
	 */
	@Override
	public int getPushRecordCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pushRecordMapper.getPushRecordCount(map);
	}

}
