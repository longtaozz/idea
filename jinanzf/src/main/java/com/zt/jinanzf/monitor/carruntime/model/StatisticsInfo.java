/** 
 *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年10月15日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.carruntime.model;  


/**
 * ClassName: StatisticsInfo 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年10月15日
 */

public class StatisticsInfo {
		
	  private  Integer   carTotal;  //车辆总数
	  
	  private  Integer   normalCarTotal; //正常车辆总数
	  
	  private  Integer  unloadingotal;  //消纳场总数
	  
	  private  Integer  consappTotal; //工地总数

	
	public Integer getCarTotal() {
		return carTotal;
	}

	
	public void setCarTotal(Integer carTotal) {
		this.carTotal = carTotal;
	}

	
	public Integer getNormalCarTotal() {
		return normalCarTotal;
	}

	
	public void setNormalCarTotal(Integer normalCarTotal) {
		this.normalCarTotal = normalCarTotal;
	}

	
	public Integer getUnloadingotal() {
		return unloadingotal;
	}

	
	public void setUnloadingotal(Integer unloadingotal) {
		this.unloadingotal = unloadingotal;
	}

	
	public Integer getConsappTotal() {
		return consappTotal;
	}

	
	public void setConsappTotal(Integer consappTotal) {
		this.consappTotal = consappTotal;
	}
	  
	  
	  
}
