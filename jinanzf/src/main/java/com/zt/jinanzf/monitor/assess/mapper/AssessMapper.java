/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月8日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.assess.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zt.jinanzf.monitor.assess.model.ZtAssess;

/**
 * ClassName: AssessMapper 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月8日
 */

public interface AssessMapper extends BaseMapper<ZtAssess>{
	List<ZtAssess> queryAssessList();
}
