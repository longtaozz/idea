/** 
  *@Project: jinan-service 
 *@Author: YangXiao
 *@Date: 2018年9月27日 
 *@Copyright: ©2016-2022 http://www.zhtkj.com Inc. All rights reserved. 
 */    
package com.zt.jinanzf.monitor.card.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zt.jinanzf.monitor.card.model.Card;
import com.zt.jinanzf.monitor.card.model.SaoCard;
import com.zt.jinanzf.monitor.card.service.CardService;

/**
 * ClassName: CardController 
 * @Description: TODO
 * @author YangXiao
 * @date 2018年9月27日 
 */
@RestController
@RequestMapping(value = "/project/card")
public class CardController {

 	@Value("${jwt.token.header}")
	protected String header;
 	
 	@Autowired
 	private   CardService  cardService; 
 	
	/**
	 * 查询车辆有效核准证数
	 * effective :  1：查询有效得核准证2：查询无效得核准证0：查询所有
	 */
	@ResponseBody
	@RequestMapping(value = "/getCarValidlCard", method = RequestMethod.POST)
	public  ResponseEntity<List<Card>>  getCarValidlCard(@RequestBody Map<String,Object> params){
		//Integer effective = 1; 为1的时候查询有效核准证
		List<Card> card = cardService.getCarValidlCard(params);
		return new ResponseEntity<List<Card>>(card, HttpStatus.OK);
	}

	
	/**
	 * 
	 * @Description: 扫一扫根据Id获取小证车辆数据
	 * @param params
	 * @return ResponseEntity<SaoCard>  
	 * @author chenlijun
	 * @date 2018年11月12日
	 */
	@RequestMapping(value = "/certificatePointCar", method = RequestMethod.POST)
	public ResponseEntity<SaoCard> certificatePointCar(@RequestBody Map<?, ?> params
			) {
		//Integer cityId = null == params.get("cityId") || params.get("cityId").equals("")? 0 :(Integer)params.get("cityId");
		SaoCard card = cardService.getCardInfoById(params.get("cardId").toString());
		// 设置时间
		/*if (null == card.getLicEndtime()) {
			model.addAttribute("hours", "早01点&nbsp;&nbsp;晚23点");
		}*/
		/**
		 * 设置开始日期显示
		 */
		/*Date startDate = (Date) card.getTranStarttime();
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		int year1 = start.get(Calendar.YEAR);
		model.addAttribute("year1", year1);
		int startMonth = start.get(Calendar.MONTH);
		if (startMonth < 10) {
			model.addAttribute("month1", "0" + startMonth);
		} else {
			model.addAttribute("month1", startMonth);
		}
		int startDay = start.get(Calendar.DAY_OF_MONTH);
		if (startDay < 10) {
			model.addAttribute("day1", "0" + startDay);
		} else {
			model.addAttribute("day1", startDay);
		}*/
		/**
		 * 设置结束日期显示
		 */
		/*Date endDate = (Date) card.get("endTime");
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		int year2 = end.get(Calendar.YEAR);
		model.addAttribute("year2", year2);
		int endMonth = end.get(Calendar.MONTH);
		if (endMonth < 10) {
			model.addAttribute("month2", "0" + endMonth);
		} else {
			model.addAttribute("month2", endMonth);
		}
		int endDay = end.get(Calendar.DAY_OF_MONTH);
		if (endDay < 10) {
			model.addAttribute("day2", "0" + endDay);
		} else {
			model.addAttribute("day2", endDay);
		}

		if (card.get("LuName") == null || "".equals("LuName")) {
			card.put("LuName", card.get("LuName"));
		}*/
		
		//model.addAttribute("cardId", cardId);
		return new ResponseEntity<SaoCard>(card, HttpStatus.OK);
	}
}
