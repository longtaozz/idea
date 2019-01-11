package com.zt.jinanzf.monitor.car.model;  

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

/**
 * 车辆信息
 * ClassName: Car 
 * @Description: TODO
 * @author Administrator
 * @date 2018年5月7日
 */
@Data
@TableName(value="zt_car")
public class Car implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//车辆主键
	private Integer carId;
	//联系电话
	private String carOwnersContact;
	//驾驶员
	private String carOwnersName;
	//车辆类型
	private String carType;
	//车架号
	private String chassisNumber;
	//发动机号
	private String engineNumber;
	//车牌号
	private String numberPlate;
	//sim卡号
	private String simNumber;
	//车辆品牌类
	private String carFactory;
	//城建号
	private String admitNumber;
	//设备提供商id
	private String equipmentProviders;
	//设备提供商
	private String equipmentName;
	//所属公司
	private Integer enterpriseId;
	//所属公司名称
	private String enterpriseName;
	//所属公司简称
	private String enterpriseAbbreviation;
	
	private String drivername;//驾驶员姓名
	
	private String drivertel;//联系电话
	
	private String drivingLicenseNumber;//驾驶证号

	private String register;//注册日期(行驶证)0： 未注册 1：已注册  2:已注销  3: 临时注销       车辆状态

	private String identification;//车辆识别代号
	
	private String carRegister;//0： 未注册 1：已注册  2:已注销  3: 临时注销       车辆状态

	private String color;//车辆颜色

	private String certificate;//道路运输从业资格证书

	private String quality;//核定载质量(㎏)

	private String airtightype;//密闭类型
	
	private Date createTime;//车辆创建时间

	private String carNote;//备注
	
	@TableField(value="parkGUID")
	private String parkGUID;
}
