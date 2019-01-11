package com.zt.jinanzf.monitor.version.service;

import java.util.Map;

import com.zt.jinanzf.monitor.version.model.AppUpdate;


public interface VersionService {
	AppUpdate queryAppUpdateInfo();
	
	int insertAppUpdateInfo(Map<String ,?> param);
}
