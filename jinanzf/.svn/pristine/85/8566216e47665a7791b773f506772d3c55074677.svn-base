package com.zt.jinanzf.monitor.ztlog.model;

import java.io.Serializable;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ZtLog implements Serializable {

	private static final long serialVersionUID = 1L;
	//日志id
	private int logId;
	
	private Integer cityId;
	//操作人
	private String operationUser;
	
	//操作时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date operationTime;
	
	//操作者IP
	private String operationIp;
	
	//执行的内容
	private String executeContent;
	
	//操作类型
	private String operationType;

}
