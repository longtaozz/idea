package com.zt.jinanzf.monitor.carruntime.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class CarRuntime implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**开关厢状态*/
	private byte boxClose;
	/**空重状态*/
	private byte boxEmpty;
	/**举升状态*/
	private byte boxUp;
	/**车牌号码*/
	private String carNumber;
	//违规状态
	private String carState;
	//司机id
	private String driverId;
	//是否处于管控
	private Integer isControl;
	/**方向*/
	private float gpsDirect;
	/**经度*/
	private BigDecimal gpsPosX;
	/**纬度*/
	private BigDecimal gpsPosY;
	/**速度*/
	private float gpsSpeed;
	/**举升状态 1平放，2举升*/
	private String boxUpStatus;
	/**载货状态 1空车，2重车*/
	private String boxEmptyStatus;
	/** 开关厢状态 1关闭，2开厢*/
	private String boxCloseStatus;
	/**手机号*/
	private String devPhone;
	/**最后上报时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date sendDatetime;
	/**状态*/
	private String onlineState;
}
