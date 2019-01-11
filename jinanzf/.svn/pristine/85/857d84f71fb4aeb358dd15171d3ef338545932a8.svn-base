/** 
 *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年9月27日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.card.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zt.jinanzf.monitor.card.model.Card;
import com.zt.jinanzf.monitor.card.model.SaoCard;

/**
 * ClassName: CardMapper 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年9月27日
 */

public interface CardMapper extends BaseMapper<Card>{
	
	/**
	 * 
	 * @Description: 扫二维码获取核准证信息
	 * @param cardId
	 * @return SaoCard  
	 * @author chenlijun
	 * @date 2018年11月20日
	 */
	SaoCard getCardInfoById(String cardId);
	/**
	 * 
	 * @Description: 获取有效核准证
	 * @param params
	 * @return List<Card>  
	 * @author chenlijun
	 * @date 2018年11月20日
	 */
	List<Card> getCarValidlCard(Map<String,Object> params);
}
