/** 
 *@Project: jinanzf 
 *@Author: YangXiao
 *@Date: 2018年11月23日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.record.service;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.record.model.PushRecordVo;
import com.zt.jinanzf.monitor.record.model.ZtTelChart;

/**
 * ClassName: PushRecordService 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年11月23日
 */

public interface PushRecordService {
	
	/**
	 * 保存推送消息记录
	 * @Description: TODO
	 * @param map
	 * @return   
	 * @return boolean  
	 * @throws
	 * @author YangXiao
	 * @date 2018年11月23日
	 */
	int setPushRecord(Map<String, Object> map);
	
	
	/**
	 * 更新消息状态
	 * @Description: TODO
	 * @param map
	 * @return   
	 * @return int  
	 * @throws
	 * @author YangXiao
	 * @date 2018年11月23日
	 */
	int  upPushRecord(Map<String, Object> map);
	
	
	/**
	 * 通过用户id查询消息列表
	 * @Description: TODO
	 * @param map
	 * @return   
	 * @return List<PushRecordVo>  
	 * @throws
	 * @author YangXiao
	 * @date 2018年11月23日
	 */
	Page<PushRecordVo>  getPushRecordVo(Page<PushRecordVo> page,Map<String, Object> map);
	
	/**
     * 
     * @Description: 根据条件获取12345详细历史记录信息
     * @return ResponseEntity<ZtTelChart>  
     * @author chenlijun
     * @date 2018年11月26日
     */
	ZtTelChart getZtTelChartInfo(Map<String, Object> map);
	 /**
     * @Description: 获取未读消息数量
     * @param params
     * @return ResponseEntity<ZtTelChart>  
     * @author chenlijun
     * @date 2018年11月28日
     */
	int getPushRecordCount(Map<String, Object> map);
}
