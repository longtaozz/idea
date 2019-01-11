package com.zt.jinanzf.monitor.buildunit.model;

import java.io.Serializable;

import lombok.Data;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;


/**
 * The persistent class for the zt_buildunit database table.
 * 
 */
@Data
public class ZtBuildunit implements Serializable {
	private static final long serialVersionUID = 1L;
	//主键ID
	private int buildId;
	//添加人
	@TableField(value="build_updatePeople")
	private String buildAddPeople;
	//GUID
	@TableField(value="buildGUID")
	private String buildGUID;
	//地址
	private String buildAddress;
	//添加时间
	private Date buildAddTime;
	//区域ID
	@TableField(value="build_districtId")
	private int build_districtId;
	//文件地址
	private String buildFile;
	//名称
	private String buildName;
	//联系方式
	private String buildPhone;
	//法人代表
	private String buildRepresentative;
	//状态
	private String buildStatus;
	//修改人
	@TableField(value="build_updatePeople")
	private String buildUpdatePeople;
	//修改时间
	@TableField(value="build_updateTime")
	private Date buildUpdateTime;
	//城市id，用来标识所属地区
	private Integer cityId;
	//备注
	private String remark;
	
	private String contacts;
	
	private String contactsPhone;
}