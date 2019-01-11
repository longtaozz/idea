package com.zt.jinanzf.monitor.constructunit.model;

import java.io.Serializable;


import lombok.Data;

/**
 * 
 * ClassName: ZtConstructUnit 
 * @Description: 建设单位实体类
 * @author chenlijun
 * @date 2018年9月19日
 */
@Data
public class ZtConstructUnit implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer constructUnitId;
	
	private Integer cityId;
	
	private Integer districtId;
	
	private String unitName;
	
	private String legalPerson;
	
	private String contactPhone;
	
	private String registCapital;
	
	private String address;
	
	private String contactPerson;
	
	private String constructCommit;
	
	private String GUID;
}
