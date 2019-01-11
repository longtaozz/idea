/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月20日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.process.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * ClassName: ZtFlowLogVo 
 * @Description: 我的代办日志流程表
 * @author chenlijun
 * @date 2018年11月20日
 */
@Data
public class ZtFlowLogVo implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	
	private String caseGUID;
	//业务名称
	private String entityName;
//	当前环节名
	private String currentTaskName;
//	当前环节用户
	private String currentTaskUser;
//	目标环节接收时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private String targetTime;
//	目标环节名称
	private String targetTaskName;
	//url
	private String taskUrl;
//	主键ID
	private String logId;
	
	private String flowStatue;
	
	private String memo;
	
	private String region;
	
	private String enterpriseName;
}
