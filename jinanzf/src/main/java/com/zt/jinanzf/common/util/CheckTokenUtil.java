/** 
 *@Project: jinanzf-service 
 *@Author: chenlijun
 *@Date: 2018年11月21日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.annotation.Configuration;

/**
 * ClassName: CheckTokenUtil 
 * @Description: 判断单点登录
 * @author chenlijun 
 * @date 2018年11月21日
 */

@Configuration
public class CheckTokenUtil {
	 
	/*
	//用户token信息
	public static Map<Object, Object> cacheMap = new HashMap<Object, Object>();
	//用户设备信息
	public static Map<Object, Object> cacheMap2 = new HashMap<Object, Object>();
	
	 
	    //单实例构造方法 
	    public CheckTokenUtil() { 
	        super(); 
	    }  
	    *//**
	     * 根据键获取时间long
	     * @param key
	     * @return
	     *//*
	    public static Long getServerStartdt(String key){ 
	        return (Long)cacheMap.get(key); 
	    } 
	    *//**
	     * 设置布尔值的缓存 
	     * @param key
	     * @param date
	     * @return
	     *//*
	    public synchronized static Map<Object, Object> setSimpleFlag(String key,String token,String devicename){ 
	            cacheMap.put(key, token);
	            cacheMap2.put(key, devicename);
	            return cacheMap;
	    } 
	   
	 
	 
	    *//**
	     * 判断是否存在一个缓存 
	     * @param key
	     * @return
	     *//*
	    public synchronized static boolean hasCache(String key) { 
	        return cacheMap.containsKey(key); 
	    } 
	 
	    *//**
	     * 清除所有缓存 
	     *//*
	    public synchronized static void clearAll() { 
	        cacheMap.clear(); 
	    } 
	 
	    *//**
	     * 清除指定的缓存 
	     * @param key
	     *//*
	    public synchronized static void clearOnly(String key) { 
	        cacheMap.remove(key); 
	    } 
	 
	    *//**
	     * 获取缓存中的大小 
	     * @return
	     *//*
	    public static int getCacheSize() { 
	        return cacheMap.size(); 
	    }
	    *//**
	     * 根据最新的token通过用户名相同删除之前的token
	     * @param token
	     *//*
		public static void existByUserName(String username,String token) {
	        Iterator<Entry<Object, Object>> it = cacheMap.entrySet().iterator();  
	        while(it.hasNext()){  
	            Entry<Object, Object> entry=it.next();  
	            String key=entry.getKey().toString();  
	            if(username.equalsIgnoreCase(key)){
	            	 it.remove();
	            } 
	        }
		}
		*//**
	     * 根据最新的device通过用户名相同删除之前的token
	     * @param devicename
	     *//*
		public static void existByDeviceName(String name,String devicename) {
	        Iterator<Entry<Object, Object>> it = cacheMap2.entrySet().iterator();  
	        while(it.hasNext()){  
	            Entry<Object, Object> entry=it.next();  
	            String key=entry.getKey().toString();  
	            if(name.equalsIgnoreCase(key)){
	            	 it.remove();
	            } 
	        }
		}
		*//**
		 * 
		 * @Description: 根据token判断用户是否已经登录
		 * @param name
		 * @param token
		 * @return boolean  
		 * @author chenlijun
		 * @date 2018年11月22日
		 *//*
		public synchronized static boolean existByToken(String name,String token) {
	        Object d=cacheMap.get(name);
	      //没有用户token信息
	        if(d==null){
	        	cacheMap.put(name,token);
	        	return true;
	        }else{
	        	if(!d.equals(token)){
	        		return false;
	        	}return true;
	        }
		} 
		public synchronized static boolean existByDevice(String name,String devicename) {
	        Object d=cacheMap.get(name);
	      //没有用户token信息
	        if(d==null){
	        	cacheMap.put(name,devicename);
	        	return true;
	        }else{
	        	if(!d.equals(devicename)){
	        		return false;
	        	}return true;
	        }
		} 
*/
}
