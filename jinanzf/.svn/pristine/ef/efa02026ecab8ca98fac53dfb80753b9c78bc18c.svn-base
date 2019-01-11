/** 
 *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年9月25日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.user.mapper;

import java.util.List;
import java.util.Map;

import com.zt.jinanzf.monitor.user.model.Role;
import com.zt.jinanzf.monitor.user.model.User;

/**
 * ClassName: UserInfoMapper 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年9月25日
 */

public interface UserInfoMapper {

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
   
    //根据用户名查询用户信息
 	User queryPwd(String userName);
 	
 	//修改密码
 	int modifyPwd(Map<String, String> userPwd);
 	
 	//查询账号角色信息
 	List<Role> queryRole(Integer userId);
 	
 	//查询用户信息
 	User queryUserInfo(Map<String ,?> params);
}
