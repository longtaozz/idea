/** 
 *@Project: zwb-service 
 *@Author: chenlijun
 *@Date: 2018年5月22日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.version.model;

import lombok.Data;

/**
 * ClassName: AppUpdate 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年5月22日
 */
@Data
public class AppUpdate {
	/**主键ID*/
	private Integer appId;
	/**客户端设备id字符串，如：app.android.version.key*/
	private String appCode;
	/**客户端设备名字*/
	private String appName;
	/**是否是一个里程牌式的版本，默认为0，是则为1*/
	private String versionMilepost;
	/**版本号*/
	private String versionCode;
	/**上一个版本号*/
	private String versionCodeBefore;
	/**版本类型，0选择更新，1强制更新*/
	private String versionType;
	/**新版本大小*/
	private String versionBig;
	/**更新地址*/
	private String downloadUrl;
	/**升级信息简要*/
	private String updateTitle;
	/**升级信息详情*/
	private String updateMessage;
	/**版本状态  1:最新版本，0：之前老版本*/
	private String statusNumber;
	/**版本创建时间*/
	private String createTime;
	/**添加扩展*/
	private String updateParams;

}
