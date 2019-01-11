/**
 * @Project: jinanzf
 * @Author: YangXiao
 * @Date: 2018年11月23日
 * @Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved.
 */
package com.zt.jinanzf.monitor.record.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.util.TokenUtil;
import com.zt.jinanzf.monitor.record.model.PushRecordVo;
import com.zt.jinanzf.monitor.record.model.ZtTelChart;
import com.zt.jinanzf.monitor.record.service.PushRecordService;
import com.zt.jinanzf.monitor.user.model.User;
import com.zt.jinanzf.monitor.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * ClassName: PushRecordController 
 * @Description: 推送记录Api
 * @author YangXiao
 * @date 2018年11月23日
 */
@RestController
@RequestMapping(value = "project/pushrecord")
public class PushRecordController {

    @Autowired
    private PushRecordService pushRecordService;


    @Value("${jwt.token.header}")
    protected String header;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserInfoService userService;

    /**
     * 
     * @Description: 推送消息保存
     * @param map
     * @author YangXiao
     * @date 2018年11月23日
     */

    @RequestMapping(value = "setPushRecord", method = RequestMethod.POST)
    public Object setPushRecord(@RequestBody Map<String, Object> map) {
        
        return pushRecordService.setPushRecord(map);
    }

    /**
     * 
     * @Description: 更新推送历史记录表
     * @param map
     * @return ResponseEntity<Integer>  
     * @author chenlijun
     * @date 2018年11月28日
     */
    @RequestMapping(value = "upPushRecord")
    public ResponseEntity<Integer> upPushRecord(@RequestBody Map<String, Object> map) {
        pushRecordService.upPushRecord(map);
        return new ResponseEntity<Integer>(0, HttpStatus.OK);
    }

    /**
     * 
     * @Description: 获取推送消息
     * @param params
     * @return ResponseEntity<Page<PushRecordVo>>  
     * @author chenlijun
     * @date 2018年11月28日
     */
    @RequestMapping(value = "getPushRecordVo")
    public ResponseEntity<Page<PushRecordVo>> getPushRecordVo(@RequestBody Map<String, Object> params) {
        Integer current = null == params.get("current") || params.get("current").equals("") ? 1 : (Integer) params.get("current");
        Integer size = null == params.get("size") || params.get("size").equals("") ? 10 : (Integer) params.get("size");

        String[] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");//获得token数据
        User userObj = userService.queryPwd(uid[0]);
        params.put("quiltUserId", userObj.getUserId());

        Page<PushRecordVo> page = new Page<>(current, size);
        Page<PushRecordVo> pushInfo = pushRecordService.getPushRecordVo(page, params);

        return new ResponseEntity<Page<PushRecordVo>>(pushInfo, HttpStatus.OK);
    }
    
    /**
     * @Description: 获取未读消息数量
     * @param params
     * @return ResponseEntity<ZtTelChart>  
     * @author chenlijun
     * @date 2018年11月28日
     */
    @ResponseBody
    @RequestMapping(value="getPushRecordCount")
    public int getPushRecordCount(@RequestBody Map<String, Object> params){
    	String[] uid = tokenUtil.getUsercodeFromToken(request.getHeader(this.header)).split(",");//获得token数据
        User userObj = userService.queryPwd(uid[0]);
        params.put("quiltUserId", userObj.getUserId());
    	int count = pushRecordService.getPushRecordCount(params);
    	return count;
    }
    
    /**
     * 
     * @Description: 获取12345推送记录详情
     * @param params
     * @return ResponseEntity<ZtTelChart>  
     * @author chenlijun
     * @date 2018年11月28日
     */
    @ResponseBody
    @RequestMapping(value="getZtTelChartInfo")
    public ResponseEntity<ZtTelChart> getZtTelChartInfo(@RequestBody Map<String, Object> params){
    	
    	ZtTelChart ztTelChartInfo = pushRecordService.getZtTelChartInfo(params);
    	return new ResponseEntity<ZtTelChart>(ztTelChartInfo,HttpStatus.OK);
    }
}
