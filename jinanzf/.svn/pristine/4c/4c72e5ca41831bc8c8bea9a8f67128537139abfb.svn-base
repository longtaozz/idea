/** 
 *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年9月25日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.monitor.user.mapper.UserInfoMapper;
import com.zt.jinanzf.monitor.user.model.Role;
import com.zt.jinanzf.monitor.user.model.User;
import com.zt.jinanzf.monitor.user.service.UserInfoService;

/**
 * ClassName: UserInfoServiceImpl 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年9月25日
 */
@Service
public class UserInfoServiceImpl  implements UserInfoService{
	
	@Autowired
	private  UserInfoMapper userInfoMapper;//用户

	/**
	 * 通过map值查询user信息
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.user.service.UserInfoService#getUserInfo(java.util.Map)
	 */
	@Override
	public User getUserInfo(Map<String, Object> map) {
		return userInfoMapper.getUserInfo(map);
	}
	
	
	public User queryPwd(String userName){
		return userInfoMapper.queryPwd(userName);
	}
	
	public int modifyPwd(Map<String, String> userPwd){
		return userInfoMapper.modifyPwd(userPwd);
	}
	
	@Override
	public Role queryRole(Integer userId) {
		return userInfoMapper.queryRole(userId).get(0);
	}
	
	public User queryUserInfo(Map<String ,?> params){
		return userInfoMapper.queryUserInfo(params);
	}
	
}
