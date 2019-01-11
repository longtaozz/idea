package com.zt.jinanzf.common.conf;




import com.zt.jinanzf.monitor.user.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OpResult {

	
	
	private String message;
	private int code;
	private User user;
	//通用操作码
	public static OpResult OPERATE_SUCESS = new OpResult("操作成功", 0 ,null);
	public static OpResult OPERATE_FAIL = new OpResult("操作失败", 1 ,null);
	public static OpResult ACCESS_DENIED = new OpResult("没有操作权限",2 ,null);
	public static OpResult INSERT_SUCESS = new OpResult("提交成功",3 ,null);
	public static OpResult INSERT_FAIL = new OpResult("提交成功",4 ,null);
	
	//帐号类操作码，1000开始
	public static OpResult ACCOUNT_LOGIN_SUCESS = new OpResult("登录成功", 0 ,null);
	public static OpResult ACCOUNT_LOGIN_FAIL = new OpResult("登录失败", 1 ,null);
	public static OpResult ACCOUNT_LOGIN_TIMEOUT = new OpResult("登录超时", 1000 ,null);
	public static OpResult ACCOUNT_NOT_EXISTS = new OpResult("帐号不存在", 1001 ,null);
	public static OpResult ACCOUNT_CREDENTIALS_ERROR = new OpResult("用户名或密码不正确", 1002 ,null);
	public static OpResult ACCOUNT_LOCKED = new OpResult("帐号已锁定", 1003 ,null);
	
	public static OpResult JWT_NO_TOKEN = new OpResult("没有提供token", 1010 ,null);
	public static OpResult JWT_FORMAT_ERRORL = new OpResult("错误的token格式", 1011 ,null);
	public static OpResult JWT_TOKEN_TIMEOUT = new OpResult("token超时",1012 ,null);
	
	//工地类操作码，1100开始,以后每一个业务模块间隔100开始编码
}
