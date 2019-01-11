/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月22日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 *//*    
package com.zt.jinanzf.common.conf;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.zt.jinanzf.common.util.CheckTokenUtil;
import com.zt.jinanzf.common.util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

*//**
 * ClassName: CheckTokenAspect 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年11月22日
 *//*
@Aspect
@Component
@Slf4j 
public class CheckTokenAspect {
	
	@Autowired
	private CheckTokenUtil checkTokenUtil;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Pointcut("execution(public * com.zt.jinanzf.monitor.*.*.*.*(..))")
	private void checkToken(){
		
	}
	@SuppressWarnings({ "unchecked", "static-access" })
	@Around("execution(public * com.zt.jinanzf.monitor.*.*.*.*(..))")
	public ResponseEntity<Object> check (ProceedingJoinPoint  joinPoint) throws Throwable {
		log.info(request.getHeader("x-token"));
		if(null == tokenUtil.getUsercodeFromToken(request.getHeader("x-token"))){
			String username = tokenUtil.getUsercodeFromToken(request.getHeader("x-token"));
			System.out.println(checkTokenUtil.cacheMap.containsKey(username));
			return new ResponseEntity<Object>("帐号在别的地方登录",HttpStatus.OK);
		}
		return (ResponseEntity<Object>) joinPoint.proceed();
    }
	@Before("@annotation(com.zt.jinanzf.common.conf.CheckToken)")//execution(* com.zt.jinanzf.common.monitor.*(..))
	public Boolean checkToken (JoinPoint joinPoint,String token,String name) {
    	log.info("token登录验证");
    	//setDataSource(joinPoint, DBTypeEnum.gateway);
    	//CheckTokenUtil.existByToken(name, token);and args(methodName)
    	return CheckTokenUtil.existByToken(name, token);
    }
}*/
