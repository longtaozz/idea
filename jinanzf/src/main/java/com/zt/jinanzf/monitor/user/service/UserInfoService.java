/** 
 *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年9月25日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.user.service;

import java.util.Map;

import com.zt.jinanzf.monitor.user.model.Role;
import com.zt.jinanzf.monitor.user.model.User;

/**
 * ClassName: UserInfoService 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年9月25日
 */

public interface UserInfoService {
	
		/**
		 * 通过map值查询user信息
		 * @Description: TODO
		 * @return   
		 * @return User  
		 * @throws
		 * @author YangXiao
		 * @date 2018年9月25日
		 */
	   User getUserInfo(Map<String, Object> map);
	   
	   /** 查询原密码*/
		User queryPwd(String userName);
		/** 修改密码*/
		int modifyPwd(Map<String, String> userPwd);
		/** 获取权限信息 */
		Role queryRole(Integer userId);
		/**获取用户信息*/
		User queryUserInfo(Map<String ,?> params);
}
