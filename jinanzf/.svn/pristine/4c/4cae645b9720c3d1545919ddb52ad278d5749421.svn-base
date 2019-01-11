/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月17日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.consapp.model;

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
 * ClassName: Consapp 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月17日
 */

@Data
@TableName("zt_consapp")
public class Consapp implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@TableId(value="consapp_id",type = IdType.AUTO)
	private int consappId;

	private String barrier;

	private String bulidGarbage;

	private String carwash;

	private Integer cityId;

	@TableField(value="consGUID")
	private String consGUID;

	private Integer constrId;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date endtime;

	private String fence;

	private String gongGuidFence;

	private String hydropower;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date insertTime;

	private String licNumber;

	private String luGuidFence;

	private String monitor;

	private String monitorBasis;
	
	private String person;

	private String proAddress;

	private int proBelong;

	private String proName;

	private String proType;

	private String progress;

	private String prospecting;

	private String reduction;

	private String remark;

	private Integer responsId;

	private String road;

	private String spotManagePerson;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date starttime;

	private Integer transId;

	private Integer washNumber;

	private String xiaoGuidFence;
	
	private String type;
	
	private int gdState;

	private String standardPublic;
	
	private String licType; //核准类型
	
	private String acceptObject;//受理对象
	
	private Integer emissionLoad;//排放量
	
	private String gpsAddress;//大门位置
	
	private String preventionstate ;
	private String blockstate      ;
	private String gatestate      ;
	private String washstate       ;
	private String  spraystate     ; 
	private String coverstate	    ;
	private String hoursestate	    ;
	private String controllerstate ;
	private String videostate	    ;
	private String configstate	    ;
	private String feestate	    ;
}
