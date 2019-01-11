/** 
 *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年9月27日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.card.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.monitor.card.mapper.CardMapper;
import com.zt.jinanzf.monitor.card.model.Card;
import com.zt.jinanzf.monitor.card.model.SaoCard;
import com.zt.jinanzf.monitor.card.service.CardService;


/**
 * ClassName: CardServiceImpl 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年9月27日
 */
@Service
public class CardServiceImpl implements CardService {

	
	@Autowired
	CardMapper cardMapper;
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.card.service.CardService#getCardInfoById(java.lang.String)
	 */
	public SaoCard getCardInfoById(String cardId){
		return cardMapper.getCardInfoById(cardId);
	}
	
	public List<Card> getCarValidlCard(Map<String,Object> params){
		
		return cardMapper.getCarValidlCard(params);
	}
}
