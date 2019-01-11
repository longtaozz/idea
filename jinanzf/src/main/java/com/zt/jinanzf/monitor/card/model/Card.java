package com.zt.jinanzf.monitor.card.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zt.jinanzf.monitor.buildunit.model.ZtBuildunit;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the zt_card database table.
 * 
 */
@Data
@TableName(value="zt_card")
public class Card implements Serializable {
	private static final long serialVersionUID = 1L;

	@TableId(type=IdType.AUTO)
	private Integer cardId;

	private Integer cityId;
	//施工单位id

	private int conId; 
	//施工地址
	private String constructionAddress; 
	//车辆行驶路线id
	private String gpsroadid;
	//运输结束时间
	private String licEndtime;
	//运输开始时间
	private String licStarttime;
	//工程名称
	private String proName;
	//运输车辆id
	private String tranCarids;
	//证件有效期止
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date tranEndtime;
	//运输单位id
	private int tranId;
	//证件有效期起
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date tranStarttime;
	//许可证类型
	private String cardType;
	//联运车辆id
	private String combinedCarids;
	//关联大证id
	private String consappId;
	//路线名称
	private String gpsroadName;
	//消纳场围栏Id
	@TableField(value="xiaona_fenceid")
	private String xiaonaFenceId;
	//Guid
	@TableField(value="certificate_GUID")
	private String certificateGUID;
	//添加时间
	private Date createTime;
	//核实状态
	private Integer checkstatus;
	//核准证后面的编号
	private String uplicNumber;
	//是否打印
	private Integer isprint;
	//是否显示
	private Integer modeltype;
	//核准证编号
	private String licNumber;
	//与交警同步过来的路线信息
	@TableField(value="loadInfo")
	private String loadInfo;
	//0代表位同步，1代表已同步
	@TableField(value="loadState")
	private Integer loadState;
	//消纳场名
	private String xiaonaFencename;
	//工地围栏Id
	private String gongFenceid;
	//工地名
	private String gongFencename;
	//工程地址
	private String proAddress;
	//车牌号
	private String carNumber;
	
	private String abbreviation;
	//建设单位
	@TableField(exist=false)
	private ZtBuildunit ztBuildunit;
	//车辆信息
	@TableField(exist=false)
	private Car ztcar;
	//运输企业
	@TableField(exist=false)
	private ZtTransportEnterprises ztTransportEnterprises;
}