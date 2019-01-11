/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月8日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.lawinfo.service;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.lawinfo.model.ZtLawInfoCollect;

/**
 * ClassName: LawInfoService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月8日
 */

public interface LawInfoService {
	//执法上报
	void saveLawInfoCollect(ZtLawInfoCollect lawInfoCollect);
	//查询我的执法信息
	Page<ZtLawInfoCollect> myLawInfo( Page<ZtLawInfoCollect> page,Map<String, Object> params);
}
