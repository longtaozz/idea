package com.zt.jinanzf.monitor.datasend.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.conf.DBTypeEnum;
import com.zt.jinanzf.common.conf.DataSourceSwitch;
import com.zt.jinanzf.monitor.datasend.mapper.DataActionMapper;
import com.zt.jinanzf.monitor.datasend.model.DataAction;
import com.zt.jinanzf.monitor.datasend.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {

	@Autowired
	private DataActionMapper dataActionMapper;
	
	@Override
	@DataSourceSwitch(DBTypeEnum.gateway)
	public boolean addDataAction(String username, String carPassphoneNumber, Integer actionType, Integer actionValue, String sendRemark) {
		String[] carPassphoneNumberArray = carPassphoneNumber.split(";");
		for(int i = 0; i < carPassphoneNumberArray.length; i++){
			DataAction dataAction = new DataAction();
			dataAction.setCarPass(carPassphoneNumberArray[i].split(",")[0]);
			dataAction.setPhoneNumber(carPassphoneNumberArray[i].split(",")[1]);
			dataAction.setActionType(actionType);
			dataAction.setActionValue(actionValue);
			dataAction.setSendRemark(sendRemark);
			dataAction.setSendPerson(username);
			dataAction.setStoreTime(new Date());
			dataActionMapper.insert(dataAction);
		}
		return true;
	}

	@Override
	@DataSourceSwitch(DBTypeEnum.gateway)
	public Page<DataAction> findActionList(Page<DataAction> page, String carNumber) {
		Wrapper<DataAction> wrapper = new EntityWrapper<DataAction>();
		wrapper.eq("car_pass", carNumber);
		wrapper.orderBy("store_time", false);
		page.setRecords(dataActionMapper.selectPage(page, wrapper));
		return page;
	}

}
