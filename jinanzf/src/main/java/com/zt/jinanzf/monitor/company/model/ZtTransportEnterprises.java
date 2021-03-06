package com.zt.jinanzf.monitor.company.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zt.jinanzf.monitor.district.model.ZtDistrict;

import lombok.Data;

@Data
@TableName("zt_transport_enterprises")
public class ZtTransportEnterprises implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//主键id
	private int enterpriseId;
	//城市ID
	private Integer cityId;
	//联系人电话
	private String contactPhone;
	//联系人
	private String contacts;
	//企业简称
	private String enterpriseAbbreviation;
	//运输车辆总数量
	private String enterpriseCarCount;
	//企业管理人员数量
	private String enterpriseManagerNumber;
	//企业名称
	private String enterpriseName;
	//停车场围栏附件
	private String fenceEnclosure;
	//总吨位
	private String grossTonnage;
	//法人联系电话
	private String legalPersonPhone;
	//法人代表
	private String legalRepresentative;
	//新车数量
	private String newcarNumber;
	//办公场地面积
	private String officeSpace;
	//旧车数量
	private String oldcarNumber;
	//停车场面积
	private String parkingArea;
	//停车场电子围栏
	private String parkingLotFence;

	private String region;//区域名
	
	private String districtName;//区域ID
	//注册资金
	private String registeredCapital;
	//公司地址
	private String address;
	//业务描述
	private String performanceDescription;
	
	private String enterpriseState; //企业状态 0：以准入 1：已变更 2：已注销
	
	private String rpprovalNumber;//核准证编号
	
	private ZtDistrict ztDistrict;//区域
	
	private Integer CompanyCarCount;//运输公司车辆数
}
