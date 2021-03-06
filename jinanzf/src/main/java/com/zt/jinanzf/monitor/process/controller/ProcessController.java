package com.zt.jinanzf.monitor.process.controller;

import java.util.Map;

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
import com.zt.jinanzf.monitor.process.model.ZtFlowLogVo;
import com.zt.jinanzf.monitor.process.service.ProcessService;

/**
 * 
 * ClassName: ProcessController 
 * @Description: 审批流程
 * @author chenlijun
 * @date 2018年11月21日
 */
@Controller
@RequestMapping("/project/process")
public class ProcessController {

	@Resource
	private ProcessService processService;

	@Autowired
	private TokenUtil token;
	
	@Value("${jwt.token.header}")
	private String header;
	
	@Autowired
	private HttpServletRequest request;
	/**
	 * 获取我的代办件
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/getMyWorkingList" }, method = RequestMethod.POST)
	public ResponseEntity<Page<ZtFlowLogVo>> getMyWorkingList(@RequestBody Map<String ,Object> params){
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<ZtFlowLogVo> page = new Page<ZtFlowLogVo>(current,size);
		System.out.println(request.getHeader(this.header));
		String username = token.getUsercodeFromToken(request.getHeader(this.header));
		params.put("username", username);
		page = processService.getMyWorkingList(page ,params);
		return new ResponseEntity<Page<ZtFlowLogVo>>(page , HttpStatus.OK);
	}
	/**
	 * 获取我的已办件
	 */
	@ResponseBody
	@RequestMapping(value = { "/getMyEndWorkingList" }, method = RequestMethod.POST)
	public ResponseEntity<Page<ZtFlowLogVo>> getMyEndWorkingList(@RequestBody Map<String ,Object> params){
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<ZtFlowLogVo> page = new Page<ZtFlowLogVo>(current,size);
		String username = token.getUsercodeFromToken(request.getHeader(this.header));
		params.put("username", username);
		//params.put("cityId", cityId);
		//params.put("realName", session.getAttribute("realName").toString());
		//params.put("type", "end");
		//params.put("entityName", null == params.get("entityName")?"": params.get("entityName").toString());
		//params.put("upPreson", null == params.get("upPreson")?"": params.get("upPreson").toString());
		//params.put("currentName", null == params.get("currentName")?"": params.get("currentName").toString());
		page = processService.getMyEndWorkingList(page ,params);
		return new ResponseEntity<Page<ZtFlowLogVo>>(page , HttpStatus.OK);
	}
}
