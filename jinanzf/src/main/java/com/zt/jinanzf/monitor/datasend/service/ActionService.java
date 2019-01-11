package com.zt.jinanzf.monitor.datasend.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.datasend.model.DataAction;

public interface ActionService {

	/**
	 * @Description: 添加指令列表
	 * @param dataActions
	 * @return boolean  
	 */
	boolean addDataAction(String username, String carPassphoneNumber, Integer actionType, Integer actionValue, String sendRemark);
	
	/**
	 * @Description: 查询指令列表
	 * @param page
	 * @param carNumber
	 * @return Page<DataAction>  
	 */
	Page<DataAction> findActionList(Page<DataAction> page, String carNumber);
}
