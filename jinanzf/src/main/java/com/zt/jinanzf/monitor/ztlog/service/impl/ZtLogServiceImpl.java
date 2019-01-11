package com.zt.jinanzf.monitor.ztlog.service.impl;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zt.jinanzf.monitor.ztlog.mapper.ZtLogMapper;
import com.zt.jinanzf.monitor.ztlog.model.ZtLog;
import com.zt.jinanzf.monitor.ztlog.service.ZtLogServise;


@Service
public class ZtLogServiceImpl implements ZtLogServise{

	@Autowired
	private ZtLogMapper ztLogMapper;

	@Override
	public void saveLogInfo(ZtLog log) {

		Date date = new Date();
		log.setOperationTime(date);
		log.setOperationIp(getIpAddr());
		ztLogMapper.insert(log);
		
	}

	protected String getIpAddr() {  
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
			       .getRequestAttributes()).getRequest();	
		String ip = request.getHeader("x-forwarded-for");  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getHeader("WL-Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
			ip = request.getRemoteAddr();  
		}  
		return ip;  
	}
	
}
