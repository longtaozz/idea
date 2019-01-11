/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月19日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.card.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * ClassName: SaoCard 
 * @Description: 扫二维码获取的车辆核准证信息实体类
 * @author chenlijun
 * @date 2018年11月19日
 */
@Data
public class SaoCard {
		private Integer cardId;
		//工程名称
		private String proName;
		//运输单位id
		private int tranId;
		//运输单位企业名称
		private String enterpriseName;
		//工程地址
		private String proAddress;
		//车辆主键
		private Integer carId;
		//车牌号
		private String numberPlate;
		//城建号
		private String admitNumber;
		//证件有效期起
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
		private Date tranStarttime;
		//证件有效期止
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
		private Date tranEndtime;
		//与交警同步过来的路线信息
		@TableField(value="loadInfo")
		private String loadInfo;
		//0代表位同步，1代表已同步
		@TableField(value="loadState")
		private Integer loadState;
		//消纳场名
		private String xiaonaFencename;
		//工地名
		private String gongFencename;
		private String abbreviation;
}
