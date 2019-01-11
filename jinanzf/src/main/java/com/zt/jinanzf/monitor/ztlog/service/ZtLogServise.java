package com.zt.jinanzf.monitor.ztlog.service;

import com.zt.jinanzf.monitor.ztlog.model.ZtLog;

public interface  ZtLogServise {

	/**
	 * 添加日志信息
	 * @param log
	 */
	void saveLogInfo(ZtLog log);
	
}
