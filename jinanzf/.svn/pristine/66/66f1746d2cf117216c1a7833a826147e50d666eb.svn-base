package com.zt.jinanzf.monitor.lawinfo.model;

import java.io.Serializable;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/** 
* @ClassName: manageLaw 
* @Description: 管理与执法动态实体
*  
*/
@Data
public class ZtLawInfoCollect implements Serializable {

	private static final long serialVersionUID = 1L;
	//主键ID
	private Integer id;
	//案卷id
	private String lawinfoId;
	//城市ID
	private Integer cityId;
	//考核类型ID
	private Integer lawId;
	//区域ID
	private Integer districtId;
	//描述
	private String description;
	//图片地址
	private String imgAddress;
	//0：提交 1：暂存
	private Integer state;
	//具体位置
	private String specificLocation;
	//录入时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date dateTime;
	//GUID
	private String lawinfoGUID;
	//微信OpenID
	private String openId;
	//用户名
	private String personName;
	//0 代表内部上报 1：代表外部上报
	private int reportState;
}
