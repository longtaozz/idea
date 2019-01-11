/** 
 *@Project: zwb-service-jn 
 *@Author: chenlijun
 *@Date: 2018年8月3日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.history.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.geo.Point;

import com.zt.jinanzf.monitor.history.model.CarHistory;

/**
 * ClassName: ZtCarHistoryService 
 * @Description: 历史轨迹
 * @author chenlijun
 * @date 2018年9月6日
 */

public interface ZtCarHistoryService {
	/**
	 * 
	 * @Description: 根据车牌号和时间查询历史轨迹
	 * @param param
	 * @return   
	 * @return List<CarHistory>  
	 * @throws
	 * @author chenlijun
	 * @date 2018年9月7日
	 */
	List<CarHistory> selectCarHistory(Map<String,Object> param);
	
	
	/**
	 * 根据开始、结束时间，圆形坐标、半径查询车辆
	 * @param startTime
	 * @param endTime
	 * @param point
	 * @param raidus
	 * @return
	 */
	List<CarHistory> getCircularHistoryDatas(Date startTime, Date endTime, Point point,Double raidus);


}
