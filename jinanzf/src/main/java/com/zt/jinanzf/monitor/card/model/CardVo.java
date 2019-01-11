/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月12日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.card.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zt.jinanzf.monitor.buildunit.model.ZtBuildunit;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;

import lombok.Data;

/**
 * ClassName: CardVo 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年11月12日
 */

@Data
public class CardVo implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer cardId;

	private Integer cityId;

	private int conId;

	private String constructionAddress; 

	private String gpsroadid;

	private String licEndtime;

	private String licStarttime;

	private String proName;

	private String tranCarids;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date tranEndtime;

	private int tranId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date tranStarttime;
	
	private String cardType;
	
	private String combinedCarids;
	
	private String consappId;
	
	private String gpsroadName;
	
	private String xiaonaFenceId;
	
	private String certificateGUID;
	
	private Date createTime;
	
	private Integer checkstatus;
	
	private String uplicNumber;
	
	private Integer isprint;
	
	private Integer modeltype;
	
	private String licNumber;

	private String loadInfo;
	
	private Integer loadState;
	
	private String xiaonaFencename;
	
	private String gongFenceid;
	
	private String gongFencename;
	
	private ZtBuildunit ztBuildunit;
	
	private Car ztcar;
	
	private ZtTransportEnterprises ztTransportEnterprises;
}
