package com.zt.jinanzf.monitor.push.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zt.jinanzf.common.util.DateUtil;
import com.zt.jinanzf.monitor.push.mapper.HWPushMapper;
import com.zt.jinanzf.monitor.push.model.PushUser;
import com.zt.jinanzf.monitor.push.service.HuaWeiService;
import com.zt.jinanzf.monitor.push.tool.HWPush;
import com.zt.jinanzf.monitor.push.tool.JGPushHandler;
import com.zt.jinanzf.monitor.record.service.PushRecordService;

import cn.jpush.api.push.model.audience.AudienceTarget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * 华为推送
 */
@Service
public class HuaWeiServiceImpl implements HuaWeiService {
	
	
	public static void main(String[] args) {
		JGPushHandler.getInitPush().all_alert("dajjaajaj");
		List<String> ls=new ArrayList<>();
		ls.add("10466");
		ls.add("10721");
		ls.add("10722");
		ls.add("10723");
		ls.add("10716");
		JGPushHandler.getInitPush().all_alias_alert("推过来1111111111",ls);
		JGPushHandler.getInitPush().android_addition(AudienceTarget.alias("10466","10721","10722","10723","10716"),"dqwfwfqwqwf",2013);
	}

	@Autowired
	HWPushMapper hwPushMapper;

	@Autowired
	PushRecordService pushRecordService;

	@Override
	public int hwSendPush(Map<String, Object> params) {
		try {
			// 推送用户处理
			JSONArray deviceTokens = new JSONArray();// token储存
			int x = 0;
			// 判断是否有用户id
			List<String> pushUsersx = new ArrayList<>();
			if (params.get("pushUserIds") != null && !"".equals(params.get("pushUserIds"))) {
				String pushUserIds = params.get("pushUserIds").toString();
				String[] strs = pushUserIds.split(",");
				for (int i = 0; i < strs.length; i++) {
					Map<String, Object> map = new HashMap<>();
					map.put("user_id", strs[i]);
					pushUsersx.add(strs[i]);
//					List<PushUser> pushUsers = hwPushMapper.selectByMap(map);
//					if (pushUsers.size() > 0)
//						deviceTokens.add(pushUsers.get(0).getPushToken());
				}
				x++;
			}
			// 判断是否有角色
//			if (params.get("deptIds") != null && !"".equals(params.get("deptIds"))) {
//				String deptIds = params.get("deptIds").toString();
//				String[] strs = deptIds.split(",");
//				for (int i = 0; i < strs.length; i++) {
//					// 通过角色查华为token信息
//					List<String> hwTokens = hwPushMapper.getTokenByRole(Integer.parseInt(strs[i]));
//					if (hwTokens.size() > 0) {
//						for (int j = 0; j < hwTokens.size(); j++) {
//							deviceTokens.add(hwTokens.get(j));
//						}
//					}
//				}
//				x++;
//			}
//			// 没有传来用户和角色信息为全部发送
//			if (x == 0) {
//				List<PushUser> pushUsers = hwPushMapper.selectList(null);
//				if (pushUsers.size() > 0) {
//					for (int i = 0; i < pushUsers.size(); i++) {
//						pushUsersx.add(pushUsers.get(i).getUserId() + "");
//						deviceTokens.add(pushUsers.get(i).getPushToken());
//					}
//				}
//			}
//
//			// 推送点击动作
//			JSONObject param = new JSONObject();
//			if ("2".equals(params.get("msgTypeId").toString())) {
//				param.put("appPkgName", "com.zt.capacity.jinan_zwt");
//			} else {// 默认为通知类消息
//				param.put("appPkgName", "com.zt.capacity.jinan_zwt");
//				// param.put("intent",
//				// "#Intent;compo=com.rvr/.Activity;S.W=U;end");
//			}
//			// 自定义扩展消息
//			JSONObject ext = new JSONObject();
//			if (params.get("pushImg") != null && !"".equals(params.get("pushImg"))) {
//				ext.put("icon", params.get("pushImg").toString());
//			}
//
//			// 推送成功保存推送记录
			System.out.println("保存数量" + pushUsersx.size());
			if (pushUsersx.size() > 0) {
				params.put("pushState", 0);
				params.put("pushDataId", params.get("dataId"));
				params.put("pushRecordTime", DateUtil.showDate(DateUtil.DATE_FORMAT_YMDHMS, new Date()));
				params.put("pushRecordContent", params.get("pushContent"));
				params.put("pushRecordTitle", params.get("pushTitle"));
				params.put("pushGenreId", params.get("msgTypeId"));
				for (int i = 0; i < pushUsersx.size(); i++) {
					params.put("quiltUserId", pushUsersx.get(i));
					pushRecordService.setPushRecord(params);
				}
			}else{
				//所有用户都发
			}
			
			if(pushUsersx.size()>0){
				JGPushHandler.getInitPush().all_alias_alert(params.get("pushContent") + "",pushUsersx);
			}else{

				JGPushHandler.getInitPush().all_alert(params.get("pushContent") + "");
			}

			return 0;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return 1;
		}

	}

	@Override
	public boolean selectToken(Map<String, Object> params) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", params.get("userId"));
		map.put("push_identify", params.get("pushIdentify"));// 标识
		List<PushUser> pushUsers = hwPushMapper.selectByMap(map);
		if (pushUsers.size() > 0) {
			PushUser pushUser = pushUsers.get(0);
			Date date = DateUtil.addAndSubtractDaysByGetTime(pushUser.getPushTime(), 6);
			int res = date.compareTo(new Date());
			if (res == 1) {// 有且没过期
				return true;
			}
		}
		return false;
	}

	@Override
	public int addPushUser(Map<String, Object> params) {
		// try {
		String token = params.get("hwToken").toString();
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", params.get("userId"));
		List<PushUser> pushUsers = hwPushMapper.selectByMap(map);
		if (pushUsers.size() > 0) {// 判断
			PushUser pushUser = pushUsers.get(0);
			if (!pushUser.getPushIdentify().equals(params.get("pushIdentify").toString())) {
				pushUser.setPushIdentify(params.get("pushIdentify").toString());
			}
			pushUser.setPushToken(token);
			hwPushMapper.updateById(pushUser);
		} else {
			hwPushMapper.insert(PushUser.builder().pushIdentify(params.get("pushIdentify").toString())
					.pushBrand(params.get("pushBrand").toString()).pushToken(token).pushTime(new Date())
					.userId(Integer.parseInt(params.get("userId").toString())).build());
		}
		return 0;
		// } catch (Exception e) {
		// return 1;
		// }
	}

	@Override
	public int deletPushUser(Map<String, Object> params) {
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("push_hw_token", params.get("pushToken"));
			hwPushMapper.deleteByMap(map);
			return 0;
		} catch (Exception e) {
			return 1;
		}
	}

}
