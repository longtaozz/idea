/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.notice.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.notice.mapper.NoticeMapper;
import com.zt.jinanzf.monitor.notice.model.Notice;
import com.zt.jinanzf.monitor.notice.service.NoticeService;


/**
 * ClassName: NoticeServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.notice.service.NoticeService#queryNoticeContent(com.baomidou.mybatisplus.plugins.Page)
	 */
	public Page<Notice> queryNoticeContent(Page<Notice> page,Map<String, ?> params){
		return page.setRecords(noticeMapper.queryNoticeContent(page,params));
	}
}
