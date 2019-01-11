package com.zt.jinanzf.monitor.push.tool;

import java.util.List;

import org.apache.log4j.BasicConfigurator;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.Notification;

public class JGPushHandler {
	private static JGPushHandler pushHandler;
	private static JPushClient jpushClient;

	private PushPayload payload;

	public static JGPushHandler getInitPush() {
		if (pushHandler == null) {
			BasicConfigurator.configure(); //自动快速地使用缺省Log4j环境。
			pushHandler = new JGPushHandler();
		}
		jpushClient = new JPushClient("2facb919fd3db5aaa1d5dcbd", "04f49bc76f845581898633f5", null,
				ClientConfig.getInstance());
		return pushHandler;
	}

	/**
	 * 所有平台，所有设备，内容为 ALERT的通知
	 * 
	 * @param ALERT
	 *            内容
	 */
	public void all_alert(String ALERT) {
		payload = PushPayload.alertAll(ALERT);
		try {
			PushResult result = jpushClient.sendPush(payload);

		} catch (APIConnectionException e) {
			// Connection error, should retry later
			System.out.println(e);

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			System.out.println("Should review the error, and fix the request" + e);
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}
	}

	/**
	 * 所有平台，推送目标是别名为 "alias"，通知内容为 ALERT
	 * 
	 * @param ALERT
	 * @param alias
	 */
	public void all_alias_alert(String ALERT, List<String> aliases) {
		payload = PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(aliases))
				.setNotification(Notification.alert(ALERT)).build();
		
		try {
			PushResult result = jpushClient.sendPush(payload);

		} catch (APIConnectionException e) {
			// Connection error, should retry later
			System.out.println(e);

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			System.out.println("Should review the error, and fix the request" + e);
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}
	}

	/**
	 * 平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE
	 * @param tag
	 * @param ALERT
	 * @param TITLE
	 */
	public void android_tag_alertWithTitle(String tag, String ALERT, String TITLE) {
		payload = PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag(tag))
				.setNotification(Notification.android(ALERT, TITLE, null)).build();
		try {
			PushResult result = jpushClient.sendPush(payload);

		} catch (APIConnectionException e) {
			// Connection error, should retry later
			System.out.println(e);

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			System.out.println("Should review the error, and fix the request" + e);
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}
	}
	
	public void android_addition(AudienceTarget alias,String MSG_CONTENT,Integer id){
		payload = PushPayload.newBuilder()
        .setPlatform(Platform.android_ios())
        .setAudience(Audience.newBuilder()
                .addAudienceTarget(AudienceTarget.tag("唐江", "tag2"))
                .addAudienceTarget(alias)
                .build())
        .setMessage(Message.newBuilder()
                .setMsgContent(MSG_CONTENT)
                .addExtra("id", id+"")
                .build())
        .build();
		try {
			PushResult result = jpushClient.sendPush(payload);

		} catch (APIConnectionException e) {
			// Connection error, should retry later
			System.out.println(e);

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			System.out.println("Should review the error, and fix the request" + e);
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}
		
	}

}
