package com.zt.jinanzf.monitor.push.tool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

/**
 * 华为推送工具
 */
public class HWPush {
    private static HWPush hwPush;

    private static String appSecret = "b3314b111721c28736caedddd71c05b5";
    private static String appId = "100494305";//用户在华为开发者联盟申请的appId和appSecret（会员中心->应用管理，点击应用名称的链接）
    private static String tokenUrl = "https://login.vmall.com/oauth2/token"; //获取认证Token的URL
    private String apiUrl = "https://api.push.hicloud.com/pushsend.do"; //应用级消息下发API
    private static String accessToken = null;//下发通知消息的认证Token
    private Date tokenCreatTime;//下发通知消息的认证Token
    private static long tokenExpiredTime = 0;  //accessToken的过期时间

    public static HWPush getInstance() {
        if (hwPush == null) {
            hwPush = new HWPush();
        }
        if (tokenExpiredTime == 0 || System.currentTimeMillis() >= tokenExpiredTime || accessToken == null) {
            //token过期或是没有token
            try {
                refreshToken();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hwPush;
    }

    //获取下发通知消息的认证Token
    private static void refreshToken() throws IOException {
        String msgBody = MessageFormat.format(
                "grant_type=client_credentials&client_secret={0}&client_id={1}",
                URLEncoder.encode(appSecret, "UTF-8"), appId);
        String response = httpPost(tokenUrl, msgBody, 5000, 5000);
        JSONObject obj = JSONObject.parseObject(response);
        accessToken = obj.getString("access_token");
        tokenExpiredTime = System.currentTimeMillis() + obj.getLong("expires_in") - 5 * 60 * 1000;
    }

    //获取认证token的请求
    private static String httpPost(String httpUrl, String data, int connectTimeout, int readTimeout) throws IOException {
        OutputStream outPut = null;
        HttpURLConnection urlConnection = null;
        InputStream in = null;

        try {
            URL url = new URL(httpUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            urlConnection.setConnectTimeout(connectTimeout);
            urlConnection.setReadTimeout(readTimeout);
            urlConnection.connect();

            // POST data
            outPut = urlConnection.getOutputStream();
            outPut.write(data.getBytes("UTF-8"));
            outPut.flush();

            // read response
            if (urlConnection.getResponseCode() < 400) {
                in = urlConnection.getInputStream();
            } else {
                in = urlConnection.getErrorStream();
            }

            List<String> lines = IOUtils.readLines(in, urlConnection.getContentEncoding());
            StringBuffer strBuf = new StringBuffer();
            for (String line : lines) {
                strBuf.append(line);
            }
            System.out.println(strBuf.toString());
            return strBuf.toString();
        } finally {
            IOUtils.closeQuietly(outPut);
            IOUtils.closeQuietly(in);
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    /**
     * 消息推送
     *
     * @param deviceTokens 为客户端申请token的方法，可以调用多次以防止申请token失败
     *                     deviceTokens.add("12345678901234561234567890123456");
     * @param title        消息标题
     * @param content      消息内容体
     * @param actionType   打开方式
     *                     （1、自定义行为：行为由参数intent定义；2、打开URL：URL地址由参数url定义；3、打开APP：默认值，打开App的首页）
     * @param msgType      通知栏消息
     *                     1 透传异步消息 3 系统通知栏异步消息    注意：2和4以后为保留后续扩展使用
     * @param param        关于消息点击动作的参数（根据actionType定）
     *                     param.put("appPkgName", "com.zt.capacity.jinan_zwt");
     *                     param.put("intent":"#Intent;compo=com.rvr/.Activity;S.W=U;end");
     * @param ext          用户自定义扩展信息
     *                     ext.put("biTag", "Trump");//设置消息标签，如果带了这个标签，会在回执中推送给CP用于检测某种类型消息的到达率和状态
     *                     ext.put("icon", "http://pic.qiantucdn.com/58pic/12/38/18/13758PIC4GV.jpg");//自定义推送消息在通知栏的图标,value为一个公网可以访问的URL
     * @throws IOException
     */
    public void sendPushMessage(JSONArray deviceTokens, String title, String content, int actionType, int msgType, JSONObject param, JSONObject ext) throws IOException {

        JSONObject body = new JSONObject();//仅通知栏消息需要设置标题和内容，透传消息key和value为用户自定义
        body.put("title", title);//消息标题
        body.put("content", content);//消息内容体


        JSONObject action = new JSONObject();
        action.put("type", actionType);//类型3为打开APP，其他行为请参考接口文档设置
        action.put("param", param);//消息点击动作参数

        JSONObject msg = new JSONObject();
        msg.put("type", msgType);//3: 通知栏消息，异步透传消息请根据接口文档设置
        msg.put("action", action);//消息点击动作
        msg.put("body", body);//通知栏消息body内容

        JSONObject hps = new JSONObject();//华为PUSH消息总结构体
        hps.put("msg", msg);
        hps.put("ext", ext);

        JSONObject payload = new JSONObject();
        payload.put("hps", hps);

        String postBody = MessageFormat.format(
                "access_token={0}&nsp_svc={1}&nsp_ts={2}&device_token_list={3}&payload={4}",
                URLEncoder.encode(accessToken, "UTF-8"),
                URLEncoder.encode("openpush.message.api.send", "UTF-8"),
                URLEncoder.encode(String.valueOf(System.currentTimeMillis() / 1000), "UTF-8"),
                URLEncoder.encode(deviceTokens.toString(), "UTF-8"),
                URLEncoder.encode(payload.toString(), "UTF-8"));

        String postUrl = apiUrl + "?nsp_ctx=" + URLEncoder.encode("{\"ver\":\"1\", \"appId\":\"" + appId + "\"}", "UTF-8");
        httpPost(postUrl, postBody, 5000, 5000);
    }
}
