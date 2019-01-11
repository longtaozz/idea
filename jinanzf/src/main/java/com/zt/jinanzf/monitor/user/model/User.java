package com.zt.jinanzf.monitor.user.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
/**
 * ClassName: User
 * @Description: 用户信息
 * @author Administrator
 * @date 2018年5月7日
 */
@Data
@TableName("userinfo")
public class User implements Serializable{

	 private static final long serialVersionUID = 1L;
	 
		private Integer userId;

		private Integer districtId;

		private String realName;
		
		private Integer deptId;
		
		private String deptName;
		
		private Integer dutyId;

		private String dutyName;
		
		private String email;
		
		private String address;
		
		private String openId;
		
		private String signatureImg;
		
		private String carFactory;
		/**用户名*/
		private String username;
		/**用户密码*/
		private String password;
		/**用户手机号*/
		private String mobile;
		/**城市ID*/
		private Integer cityId;
		/**性别*/
		private Integer sex;
		/**企业Id*/
		private Integer enterpriseId;

	
}
