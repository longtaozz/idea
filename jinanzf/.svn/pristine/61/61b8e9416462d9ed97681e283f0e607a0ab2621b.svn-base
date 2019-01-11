package com.zt.jinanzf.monitor.lawinfo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.util.TokenUtil;
import com.zt.jinanzf.common.util.UUIDGenerator;
import com.zt.jinanzf.common.util.UserUtil;
import com.zt.jinanzf.monitor.assess.service.AssessService;
import com.zt.jinanzf.monitor.company.service.CompanyService;
import com.zt.jinanzf.monitor.district.service.DistrictService;
import com.zt.jinanzf.monitor.lawinfo.model.ZtLawInfoCollect;
import com.zt.jinanzf.monitor.lawinfo.service.LawInfoService;
import com.zt.jinanzf.monitor.user.model.User;
import com.zt.jinanzf.monitor.ztlog.model.ZtLog;
import com.zt.jinanzf.monitor.ztlog.service.ZtLogServise;


/**
 * 
 * ClassName: LawInfoController 
 * @Description: 执法
 * @author chenlijun
 * @date 2018年11月16日
 */
@Controller
@RequestMapping("/project/lawInfo")
public class LawInfoController {
	
	@Autowired
	private TokenUtil tokenUtil;
	
	@Autowired
	private UserUtil userUtil;
	
	@Autowired
	private HttpServletRequest request;
	
	@Value("${jwt.token.header}")
	private String header;
	
	@Resource
	private LawInfoService lawInfoService;
	
	@Resource
	private AssessService assessService;
	
	@Resource
	private ZtLogServise logServise;
	
	@Resource
	private DistrictService districtService;
	
	@Resource
	private CompanyService companyService;
	
	
	/**
	 * 添加案卷信息(执法上报)
	 */
	@ResponseBody
	@RequestMapping(value="/saveLawInfo", method = RequestMethod.POST)
	public Integer saveLawInfo(@RequestBody Map<String, ?> params) {
		try {
		Integer cityId = Integer.parseInt(params.get("cityId").toString());
		//String openId = params.get("openId").toString();
		//获取token中的用户信息
		String [] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");//获得token数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid[0]);
		User userObj = userUtil.getYlUserInfo();
		String username = userObj.getUsername();
		UUIDGenerator uuid = new UUIDGenerator();
		String lawInfoGuid = uuid.getUUID2();
		String lawinfoId = getRandomFileName();
		ZtLawInfoCollect lawInfoCollect = new ZtLawInfoCollect();
		//districtId specificLocation description
		lawInfoCollect.setLawinfoGUID(lawInfoGuid);
		lawInfoCollect.setLawinfoId(lawinfoId);
		lawInfoCollect.setReportState(0);
		lawInfoCollect.setPersonName(username);
		//lawInfoCollect.setOpenId(openId);
		lawInfoCollect.setCityId(cityId);
		lawInfoCollect.setState(0);
		lawInfoCollect.setDateTime(new Date());
		lawInfoService.saveLawInfoCollect(lawInfoCollect);
		ZtLog log = new ZtLog();
		Date date = new Date();
		log.setOperationTime(date);
		log.setOperationUser(username);
		log.setCityId(cityId);
	    log.setExecuteContent("执法案卷上报(添加:ID:"+0+")");
		log.setOperationType("2");
		logServise.saveLogInfo(log);
		return 1;
		} catch (Exception e) {
			return 0;
		}
		
	}
	/**
	 * 我的执法
	 */
	@ResponseBody
	@RequestMapping(value="/myLawInfo", method = RequestMethod.POST)
	public ResponseEntity<Page<ZtLawInfoCollect>> myLawInfo(@RequestBody Map<String ,Object> params){
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<ZtLawInfoCollect> page = new Page<ZtLawInfoCollect>(current,size);
		Page<ZtLawInfoCollect> lawInfo = lawInfoService.myLawInfo(page, params);
		return new ResponseEntity<>(lawInfo,HttpStatus.OK);
	}
	/**
	 * 生成编号，年月日时分秒+3位随机数
	 * @return
	 */
	public static String getRandomFileName() {  
		  
        SimpleDateFormat simpleDateFormat;  
  
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
  
        Date date = new Date();  
  
        String str = simpleDateFormat.format(date);  
  
        Random random = new Random();  
  
        int rannum = (int) (random.nextDouble() * (999 - 100 + 1)) + 100;// 获取5位随机数  
  
        return str+rannum;// 当前时间  
    } 
	
}
