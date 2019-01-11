package com.zt.jinanzf.monitor.history.mapper;

import java.util.List;
import java.util.Map;

import com.zt.jinanzf.monitor.history.model.CarHistory;




/**
 * ClassName: ZtCarHistoryMapper 
 * @Description: 历史轨迹
 * @author chenlijun
 * @date 2018年9月7日
 */

public interface ZtCarHistoryMapper {
	/**
	 * @Description: 查询历史轨迹
	 * @param param
	 * @return List<CarHistory>  
	 * @author chenlijun
	 * @date 2018年9月7日
	 */
	 List<CarHistory> selectCarHistory(Map<String,?> param);
	 /**
	  * @Description: 查询某一时间段历史轨迹
	  * @return CarHistory  
	  * @author chenlijun
	  * @date 2018年10月16日
	  */
	 CarHistory selectCarHistoryByHour(Map<String,?> param);
	 /**
	  * @Description: 查询最近x个小时的历史轨迹
	  * @param param
	  * @return List<CarHistory>  
	  * @author chenlijun
	  * @date 2018年10月16日
	  */
	 List<CarHistory> selectCarHistoryListByHour(Map<String,?> param);
}
