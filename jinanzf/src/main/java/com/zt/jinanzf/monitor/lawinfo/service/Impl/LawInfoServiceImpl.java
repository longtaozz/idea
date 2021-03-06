/** 
 *@Project: jinan-service 
 *@Author: chenlijun
 *@Date: 2018年10月8日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.lawinfo.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.lawinfo.mapper.LawInfoMapper;
import com.zt.jinanzf.monitor.lawinfo.model.ZtLawInfoCollect;
import com.zt.jinanzf.monitor.lawinfo.service.LawInfoService;


/**
 * ClassName: LawInfoServiceImpl 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年10月8日
 */
@Service
public class LawInfoServiceImpl implements LawInfoService {

	@Autowired
	private LawInfoMapper lawInfoMapper;
	
	@Override
	public void saveLawInfoCollect(ZtLawInfoCollect lawInfoCollect) {
		lawInfoMapper.insert(lawInfoCollect);
	}
	
	public Page<ZtLawInfoCollect> myLawInfo(Page<ZtLawInfoCollect> page ,Map<String, Object> params){
		
		return page.setRecords(lawInfoMapper.myLawInfo(page, params));
	}
}
