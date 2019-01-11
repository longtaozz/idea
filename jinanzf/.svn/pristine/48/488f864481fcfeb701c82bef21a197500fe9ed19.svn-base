package com.zt.jinanzf.monitor.assess.model;

import java.io.Serializable;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/** 
* @ClassName: Assess 
* @Description: 考核评估实体
*  
*/
@Data
public class ZtAssess implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer assessId;
	
	private Integer cityId;
	
	private Integer assessType;
	
	private String assessPoints;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date assessDatetime;
	
	private String assessGist;
	
	private String assessGistAbbreviation;
	
	private String assessRemark;
	
	private String state;
	
}
