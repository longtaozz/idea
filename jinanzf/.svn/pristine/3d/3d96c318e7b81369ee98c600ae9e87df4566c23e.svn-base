/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月8日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zt.jinanzf.common.conf.JwtToken;
import com.zt.jinanzf.common.conf.OpResult;
import com.zt.jinanzf.common.util.CheckTokenUtil;
import com.zt.jinanzf.common.util.MD5Util;
import com.zt.jinanzf.common.util.TokenUtil;
import com.zt.jinanzf.monitor.user.model.User;
import com.zt.jinanzf.monitor.user.service.UserInfoService;

import io.swagger.annotations.ApiOperation;


/**
 * ClassName: UserController 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年11月8日
 */

@Controller
@RequestMapping("/project/user")
public class UserController {
	@Autowired
	private TokenUtil tokenUtil;

	@Value("${jwt.token.header}")
	protected String header;

	/*@Value("${jwt.token.header}")
	private String header;*/
	@Autowired 
	protected UserInfoService userService;

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private static CheckTokenUtil checkTokenUtil;
	/**
	 * @Description: 济南政府用户登录API
	 * @param user
	 * @return ResponseEntity<OpResult>
	 * @author chenlijun
	 * @date 2018年7月31日
	 */
	//@SuppressWarnings("static-access")
	@RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<OpResult> login(@RequestBody Map<String, String> user) {
		String username = user.get("username");
		String password = user.get("password");
		//String devicename = user.get("device");
		User userObj = userService.queryPwd(username);
		if(userObj != null && userObj.getEnterpriseId() == 0){
		//User userPwd = (User)userList.get(0);
		String passwords = userObj.getPassword();
		if(null != user && MD5Util.strToMD5(password).equals(passwords)){
		// 验证用户名密码成功后生成token
		String token = tokenUtil.generateToken(username);
		// 构建JwtToken
		JwtToken jwtToken = JwtToken.builder().token(token).principal(username).build();
		Subject subject = SecurityUtils.getSubject();
		// 该方法会调用Realm中的doGetAuthenticationInfo方法
		try {
			subject.login(jwtToken);//用户将请求参数封装 交给shiro处理
		} catch (UnknownAccountException exception) {
			return new ResponseEntity<OpResult>(OpResult.ACCOUNT_NOT_EXISTS, HttpStatus.OK);
		} catch (IncorrectCredentialsException exception) {
			return new ResponseEntity<OpResult>(OpResult.ACCOUNT_CREDENTIALS_ERROR, HttpStatus.OK);
		} catch (LockedAccountException exception) {
			return new ResponseEntity<OpResult>(OpResult.ACCOUNT_LOCKED, HttpStatus.OK);
		} catch (AuthenticationException exception) {
			return new ResponseEntity<OpResult>(OpResult.ACCOUNT_LOGIN_FAIL, HttpStatus.OK);
		}
		 
		if (subject.isAuthenticated()) {
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletResponse response = requestAttributes.getResponse();
			response.addHeader(header, token);
			//储存用户登录信息
			OpResult.ACCOUNT_LOGIN_SUCESS.setUser(userObj);
			//根据最新的token通过用户名相同删除之前的token
			/*if(!checkTokenUtil.hasCache(username)){
				//储存用户token信息
				checkTokenUtil.setSimpleFlag(username, token,devicename);
				//设置用户设备信息
			}else {
				//删除token信息
				checkTokenUtil.existByUserName(username,token);
				checkTokenUtil.existByDeviceName(username,devicename);
				checkTokenUtil.setSimpleFlag(username, token,devicename);
			}
			System.out.println(checkTokenUtil.cacheMap);*/
			return new ResponseEntity<OpResult>(OpResult.ACCOUNT_LOGIN_SUCESS, HttpStatus.OK);
		}
		throw new UnknownAccountException();}
		
		return new ResponseEntity<OpResult>(OpResult.ACCOUNT_CREDENTIALS_ERROR, HttpStatus.OK);
	}return new ResponseEntity<OpResult>(OpResult.ACCOUNT_CREDENTIALS_ERROR, HttpStatus.OK);
	}
	/**
	 * 
	 * @Description: 修改密码API
	 * @param user
	 * @return ResponseEntity<String>  
	 * @date 2018年11月8日 
	 */
	@ApiOperation(value = "修改用户密码", response = String.class)
	@RequestMapping(value="modifyUserPwd",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> modifyUserPwd(@RequestBody Map<String, String> user) {
		/*token中获取的用户名*/
		String userName = tokenUtil.getUsercodeFromToken(request.getHeader(this.header));
		/*用户输入的密码*/
		String password = MD5Util.strToMD5(user.get("password"));
		/*用户需要修改的密码*/
		String pwd = MD5Util.strToMD5(user.get("passwords"));
		/*用户的原始密码*/
		String passwords = userService.queryPwd(userName).getPassword();
		int isSuccess = 0;
		/*判断用户输入密码是否正确*/
		if(password.equals(passwords)){
			Map<String, String> userPwd = new HashMap<>();
			userPwd.put("userName", userName);
			/*获取用户要修改的密码*/
			userPwd.put("passwords", pwd);
			isSuccess = userService.modifyPwd(userPwd);
		}
		if (isSuccess == 1)
			return new ResponseEntity<String>("修改成功", HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("密码错误,修改失败!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// 权限信息查询
		/*@ApiOperation(value = "权限信息查询", response = String.class)
		@RequestMapping(value = "role", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
		public ResponseEntity<Role> role(@RequestBody Map<String, Object> param) {

			//获取用户公司id
			String userId = null == param.get("userId")?"":param.get("userId").toString();
			Role role=userService.queryRole(Integer.parseInt(userId));
			if (role == null)
				return new ResponseEntity<Role>(role,HttpStatus.NOT_FOUND);
			return new ResponseEntity<Role>(role,HttpStatus.OK);
		}*/
}
