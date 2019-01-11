/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月26日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.record.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * ClassName: ZtTelChart 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年11月26日
 */
@Data
@TableName(value="zt_tel_chart")
public class ZtTelChart implements Serializable{
	
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@TableId(type=IdType.AUTO)
	private String id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private String time;
	
	private String person;
	
	private String tel;
	
	private String content;
	
	private String num;
	
	private String type;
	
	private String source;
	
	private String receiver;
	
	private String result;
	
	private String ssqy;
	
	private String creator;

}
