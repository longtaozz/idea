/** 
 *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年9月27日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.card.service;

import java.util.List;
import java.util.Map;

import com.zt.jinanzf.monitor.card.model.Card;
import com.zt.jinanzf.monitor.card.model.SaoCard;

/**
 * ClassName: CardService 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年9月27日
 */

public interface CardService {
	
	/**
	 * 根据cardId 查询card信息
	 */
	SaoCard getCardInfoById(String cardId);
	/**
	 * 查询有效核准证
	 */
	List<Card> getCarValidlCard(Map<String,Object> params);
}
