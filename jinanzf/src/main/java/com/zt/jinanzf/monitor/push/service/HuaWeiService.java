/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.push.service;

import java.util.Map;

/**
 * 华为推送
 */
public interface HuaWeiService {
	//推送消息
	int hwSendPush(Map<String,Object> params);

	//检测用户推送有效性，token是否过期或是没有
	boolean selectToken(Map<String,Object> params);

	//添加推送用户
	int addPushUser(Map<String,Object> params);

	//删除推送用户
	int deletPushUser(Map<String,Object> params);

}
