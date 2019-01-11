/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.notice.service;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.notice.model.Notice;

/**
 * ClassName: NoticeService 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

public interface NoticeService {
	/**
	 * @Description: 查询公告通知
	 * @param page
	 * @return Page<Notice>  
	 * @author chenlijun
	 * @date 2018年9月26日
	 */
	public Page<Notice> queryNoticeContent(Page<Notice> page,Map<String, ?> params);
}
