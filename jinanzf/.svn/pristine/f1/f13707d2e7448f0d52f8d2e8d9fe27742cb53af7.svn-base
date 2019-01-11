/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年9月18日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.notice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.notice.model.Notice;
import com.zt.jinanzf.monitor.notice.service.NoticeService;

/**
 * ClassName: NoticeController 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月18日
 */

@RestController
@RequestMapping("/project/notice")
public class NoticeController {
	
	@Value("${jwt.token.header}")
	protected String header;
	
	@Autowired
	private NoticeService noticeService;
	
	/**
	 * @Description: 查询公告通知
	 * @param param
	 * @return ResponseEntity<Page<ZtNotice>>  
	 * @author chenlijun
	 * @date 2018年8月2日
	 */
	@ResponseBody 
	@RequestMapping(value="getNoticeContent", method = RequestMethod.POST)
	public ResponseEntity<Page<Notice>> getNoticeContent(@RequestBody Map<String, ?> params){
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<Notice> page = new Page<Notice>(current,size);
		Page<Notice> ztNoticeList =  noticeService.queryNoticeContent(page,params);
		return new ResponseEntity<Page<Notice>>(ztNoticeList,HttpStatus.OK); 
	}
}
