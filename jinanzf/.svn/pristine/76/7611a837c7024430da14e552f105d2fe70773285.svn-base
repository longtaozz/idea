package com.zt.jinanzf.common.util;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 生成UUID
 * @author tiom
 *
 */
public class UUIDGenerator {
	public UUIDGenerator(){	
	}
	
	/** 
     * 获得一个UUID，静态 
     * @return String UUID 
     */ 
	public static String getUUID(){
		String s=UUID.randomUUID().toString();
		//去掉“-”符号
		return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
	}
	
	/** 
     * 获得一个UUID，非静态 
     * @return String UUID 
     */ 
	public String getUUID2(){
		String s=UUID.randomUUID().toString();
		//去掉“-”符号
		return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
	}
	
	 /** 
     * 获得指定数目的UUID，静态 
     * @param number int 需要获得的UUID数量 
     * @return String[] UUID数组 
     */
	public static String[] getUUID(int number){
		if(number<1){
			return null;
		}
		String[] ss=new String[number];
		for (int i = 0; i < number; i++) {
			ss[i]=getUUID();
		}
		return ss;
	}
	
	/** 
     * 获得指定数目的UUID ,非静态
     * @param number int 需要获得的UUID数量 
     * @return String[] UUID数组 
     */
	public String[] getUUID2(int number){
		if(number<1){
			return null;
		}
		String[] ss=new String[number];
		for (int i = 0; i < number; i++) {
			ss[i]=getUUID2();
		}
		return ss;
	}
	

	//收集实体类中字段为null
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

}
