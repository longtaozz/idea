/** 
 *@Project: jinanzf 
 *@Author: YangXiao
 *@Date: 2018年11月23日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.record.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zt.jinanzf.monitor.record.model.PushRecord;
import com.zt.jinanzf.monitor.record.model.PushRecordVo;
import com.zt.jinanzf.monitor.record.model.ZtTelChart;

/**
 * ClassName: PushRecordMapper 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年11月23日
 */

public interface PushRecordMapper extends BaseMapper<PushRecord> {
	
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
	 * 通过用户id查询消息列表
	 * @Description: TODO
	 * @param map
	 * @return   
	 * @return List<PushRecordVo>  
	 * @throws
	 * @author YangXiao
	 * @date 2018年11月23日
	 */
	List<PushRecordVo>  getPushRecordVo(Pagination page ,Map<String, Object> map);
	/**
	 * 
	 * @Description: 修改消息列表信息
	 * @param map
	 * @return   
	 * @return int  
	 * @throws
	 * @author chenlijun
	 * @date 2018年11月26日
	 */
	int  upPushRecord(Map<String, Object> map);
	
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
