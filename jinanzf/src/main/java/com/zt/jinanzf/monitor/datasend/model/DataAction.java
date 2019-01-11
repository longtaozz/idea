package com.zt.jinanzf.monitor.datasend.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

@Data
@TableName("zt_data_action")
public class DataAction {

	@TableId(type = IdType.AUTO)
	private Integer actionId;

	private Integer actionType;

	private Integer actionValue;

	private String carPass;

	private byte dealResult;

	private Date dealTime;

	private String imgPath;

	private String phoneNumber;

	private byte receiveResult;

	private int resendCount;

	private String sendPerson;

	private String sendRemark;

	private Date storeTime;
	
}
