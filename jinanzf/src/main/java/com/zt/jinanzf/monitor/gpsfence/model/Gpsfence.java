package com.zt.jinanzf.monitor.gpsfence.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 电子围栏
 * ClassName: Gpsfence 
 * @Description: TODO
 * @author Administrator
 * @date 2018年5月7日
 */
@Data
@TableName("zt_gpsfence")
public class Gpsfence implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@TableId(value="fence_id",type=IdType.AUTO)
	private Integer fenceId;//主键ID

	private Integer cityId;//城市ID

	private String fenceName;//围栏名称

	private String fencePos;//围栏坐标

	private int fenceType;//围栏类型

	private String guidFence;//围栏guid
	
	private String unloadingId; //消纳场ID
	
	@TableField(value="unloadingGUID")
	private String unloadingGUID;
	
	private String proBelong;//区域ID
	
	private String buildunitId;//建设单位ID 
	
	private String consappId;//工地ID
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date InsertTime;//添加时间
}