package com.zt.jinanzf.monitor.datasend.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.util.TokenUtil;
import com.zt.jinanzf.monitor.datasend.model.DataAction;
import com.zt.jinanzf.monitor.datasend.service.ActionService;
import com.zt.jinanzf.monitor.user.model.User;
import com.zt.jinanzf.monitor.user.service.UserInfoService;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName: ActionController 
 * @Description: 指令相关
 */
 
@RestController
@RequestMapping(value = "/project/action/")
public class ActionController {

	@Value("${jwt.token.header}")
	protected String header;
	
	@Autowired
	protected TokenUtil tokenUtil;
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected UserInfoService userInfoService;
	
	@Autowired
	protected ActionService actionService;
	
	@ApiOperation(value = "下发指令")
	@RequestMapping(value = "/sendAction",method = RequestMethod.POST)
	public Integer sendAction(@RequestBody Map<String, Object> param) {
	    try {
			String [] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("uid", uid[0]);
			User user = userInfoService.getUserInfo(map);
			String carPassPhoneNumber = (String) param.get("carPassPhoneNumber");
			Integer actionType = (Integer) param.get("actionType");
			Integer actionValue = (Integer) param.get("actionValue");
			String sendRemark = (String) param.get("sendRemark");
			actionService.addDataAction(user.getUsername(), carPassPhoneNumber, actionType, actionValue, sendRemark);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	@ApiOperation(value = "查询指令列表")
	@RequestMapping(value = "/findActionList", method = RequestMethod.POST)
	public ResponseEntity<Page<DataAction>> findActionList(@RequestBody Map<String, Object> param) {
		Integer current = null == param.get("current") || param.get("current").equals("") ? 1 : (Integer) param.get("current");
		Integer size =  null == param.get("size") || param.get("size").equals("")? 10 : (Integer) param.get("size");
		Page<DataAction> page = new Page<DataAction>(current, size);
		page = actionService.findActionList(page, (String) param.get("carNumber"));
		return new ResponseEntity<Page<DataAction>>(page, HttpStatus.OK);
	}
}
