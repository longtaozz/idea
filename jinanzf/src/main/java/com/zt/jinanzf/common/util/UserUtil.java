/** 
 *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年9月28日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zt.jinanzf.monitor.user.model.User;
import com.zt.jinanzf.monitor.user.service.UserInfoService;


/**
 * ClassName: UserUtil 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年9月28日
 */
@Component
public class UserUtil {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private HttpServletRequest request;
	
	@Value("${jwt.token.header}")
	protected String header;
	
	/**
	 * 根据toke内信息查询用户信息
	 * @Description: TODO
	 * @return   
	 * @return User  
	 * @throws
	 * @author YangXiao
	 * @date 2018年9月28日
	 */
	public User getYlUserInfo(){
		String [] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");//获得token数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid[0]);
		return userInfoService.getUserInfo(map);
	}

}
