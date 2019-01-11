package com.zt.jinanzf.monitor.carIllegal.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class ZtInfringeInfo {
	//主键ID
	private Integer id;
	//被处罚人
	private String infringeUnit;
	//处理事由
	private String action;
	//处理决定文件
	private String liAnNumber;
	//处理决定编号
	private String punishNumber;
	
	//处理日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date punishTime;
	//处罚金额
	private String punishMoney;
	//执行日期
	private String executeMoney;
	//执行日期
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date executeTime;
	//结果
	private String result;
	//处理条款
	private String punishClause;
}
