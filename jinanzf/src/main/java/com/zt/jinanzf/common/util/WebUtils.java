package com.zt.jinanzf.common.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.zt.jinanzf.common.conf.OpResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebUtils {

	public static void SendJson(OpResult result) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletResponse response = requestAttributes.getResponse();
		response.setCharacterEncoding("UTF-8");    
		response.setContentType("application/json; charset=utf-8");  
		try {
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(result));
		}catch(Exception e) {
			log.error("SendJson:", e);
		}
	}
}
