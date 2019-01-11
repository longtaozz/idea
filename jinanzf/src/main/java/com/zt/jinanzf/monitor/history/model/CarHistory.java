package com.zt.jinanzf.monitor.history.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



import lombok.Data;

@Data
public class CarHistory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	/**车辆历史ID*/
	private Integer historyId;
	/**车厢关闭状态 1关闭 0 开箱*/
	private byte boxClose;
	/**空车状态 1 空车 0 重车*/
	private byte boxEmpty;
	/**举升状态  1举升 0不举升*/
	private byte boxUp;
	/**司机ID*/
	private String driverId;
	/**车牌号*/
	private String carNumber;
	/**车辆状态*/
	private String carState;
	/**违规*/
	private byte carWeigui;
	/**Sim卡号*/
	private String devPhone;
	/**方向*/
	private float gpsDirect;
	/**海拔*/
	private float gpsHeight;
	/**经度*/
	private BigDecimal gpsPosX;
	/**纬度*/
	private BigDecimal gpsPosY;
	/**速度*/
	private float gpsSpeed;
	/**gps是否有效*/
	private byte gpsValid;
	/**网关接收时间*/
	private Date reviceDatetime;
	/**终端发送时间*/
	private Date sendDatetime;
}
