package com.zt.jinanzf.monitor.unloading.model;

import java.io.Serializable;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zt.jinanzf.monitor.buildunit.model.ZtBuildunit;
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;
import com.zt.jinanzf.monitor.constructunit.model.ZtConstructUnit;
import com.zt.jinanzf.monitor.district.model.ZtDistrict;

import lombok.Data;

@Data
public class Unloading implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer unloadingId;

	private String buildunitId;

	private Integer cityId;

	private String districtId;
	
	private String unloadingGUID;

	private String enclosureId;

	private String unloadingType;
	
	private String unloadingAddpeople;

	private String unloadingAddress;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date unloadingAddtime;

	private String unloadingBackfill;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date unloadingBegintime;

	private String unloadingCelaningcar;

	private String unloadingCertificate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date unloadingEndtime;

	private String unloadingFile;

	private String unloadingHydropower;

	private String unloadingName;

	private String unloadingRailing;

	private String unloadingRoad;

	private String unloadingSize;

	private String unloadingSquirtnumber;

	private String unloadingStatus;
	
	private String gpsAddress;
	
	/*新加字段：
	1.消纳场编号：X+年+月+区号+001，如：X170901001* unloading_num
	2.公示时间* publicity_time
	//3.启用时间（相当于开始时间）* “按原来字段”
	//4.封场时间（相当于结束时间） “按原来字段”
	5.设计容量（数字，单位：m3）* design_capacity
	6.运距（数字，单位：km）* distance
	7.占地面积（数字，单位：亩）* area_covered
	8.远程喷淋设备（数字，单位：台）* sprinkler_equipment
	9.视频监测设备（数字，单位：台）* video_equipment
	10.扬尘监测设备（数字，单位：台）* dust_equipment
	11.裸土覆盖（绿化）（数字，单位：亩）bare_cover
	12.可用消纳量（数字，单位m3）able_capacity
	 */
	
	public String unloadingNum;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	public Date publicityTime;
	
	public String designCapacity;
	
	public String distance;
	
	public String areaCovered;
	
	public String sprinklerEquipment;
	
	public String videoEquipment;
	
	public String dustEquipment;
	
	public String bareCover;
	
	public String ableCapacity;
	
	//负责人
	private String buildRepresentative;
		
	//联系电话
	private String buildPhone;
	
	private ZtDistrict districtList;
	
	private ZtBuildunit ztBuildunit;
	
	private ZtConstructUnit ztConstructUnit;
	
	private ZtTransportEnterprises ztTransportEnterprises;
	
}