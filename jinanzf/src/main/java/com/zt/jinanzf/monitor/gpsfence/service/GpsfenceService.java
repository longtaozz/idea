/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月16日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.gpsfence.service;

import java.util.List;
import java.util.Map;

import com.zt.jinanzf.monitor.gpsfence.model.Gpsfence;

/**
 * ClassName: GpsfenceService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月16日
 */

public interface GpsfenceService {
	
	List<Gpsfence> getUnloadingGpsfence(Map<String, Object> params);
	
	List<Gpsfence> getConsappGpsfence(Map<String, Object> params);
	
	List<Gpsfence> getFenceByGuid(String guidFence);
}
