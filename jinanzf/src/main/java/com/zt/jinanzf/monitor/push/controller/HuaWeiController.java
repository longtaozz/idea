package com.zt.jinanzf.monitor.push.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zt.jinanzf.monitor.push.service.impl.HuaWeiServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * 华为推送
 */
@RestController
@RequestMapping(value = "/project/push")
public class HuaWeiController {


    @Autowired
    private HuaWeiServiceImpl hwService;

    
    
    @ResponseBody
    @ApiOperation(value = "发送消息")
    @RequestMapping(value = "/sendHWPush", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> putHWPush(@RequestBody Map<String, Object> params) {
        int state = hwService.hwSendPush(params);
        Map<String, Object> map = new HashMap<>();

        System.out.println(state+"");
        if (state == 0) {
            map.put("error_code", 0);
            map.put("message", "发送成功");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } else {
            map.put("error_code", 1);
            map.put("message", "发送失败");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        }
    }


    @ResponseBody
    @ApiOperation(value = "检查用户token可用状态")
    @RequestMapping(value = "/hwTokenCheck", method = RequestMethod.POST)
    public ResponseEntity<Boolean> hwTokenCheck(@RequestBody Map<String, Object> params) {
        boolean state = hwService.selectToken(params);
        return new ResponseEntity<Boolean>(state, HttpStatus.OK);
    }

    @ResponseBody
    @ApiOperation(value = "添加推送用户")
    @RequestMapping(value = "/addPushUser", method = RequestMethod.POST)
    public ResponseEntity<Integer> addPushUser(@RequestBody Map<String, Object> params) {
        int state = hwService.addPushUser(params);
        if (state == 0) {//添加成功
            return new ResponseEntity<Integer>(0, HttpStatus.OK);
        } else {
            return new ResponseEntity<Integer>(1, HttpStatus.OK);
        }
    }

    @ResponseBody
    @ApiOperation(value = "删除推送用户")
    @RequestMapping(value = "/deletPushUser", method = RequestMethod.POST)
    public ResponseEntity<Integer> deletPushUser(@RequestBody Map<String, Object> params) {
        int state = hwService.deletPushUser(params);
        if (state == 0) {//添加成功
            return new ResponseEntity<Integer>(0, HttpStatus.OK);
        } else {
            return new ResponseEntity<Integer>(1, HttpStatus.OK);
        }
    }

}
