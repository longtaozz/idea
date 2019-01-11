package com.zt.jinanzf.monitor.history.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.zt.jinanzf.common.conf.DBTypeEnum;
import com.zt.jinanzf.common.conf.DataSourceSwitch;
import com.zt.jinanzf.monitor.history.mapper.ZtCarHistoryMapper;
import com.zt.jinanzf.monitor.history.model.CarHistory;
import com.zt.jinanzf.monitor.history.model.CarHistoryM;
import com.zt.jinanzf.monitor.history.service.ZtCarHistoryService;

/**
 * ClassName: ZtCarHistoryServiceIplm 
 * @Description: TODO
 * @author chenlijun
 * @date 2018年9月7日
 */

@Service
public class ZtCarHistoryServiceIplm implements ZtCarHistoryService {

	@Autowired
	ZtCarHistoryMapper ztCarHistoryMapper;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	/**
	 * 
	 * (non-Javadoc)
	 * @see com.zt.jinanzf.monitor.history.service.ZtCarHistoryService#selectCarHistory(java.util.Map)
	 */
	@DataSourceSwitch(DBTypeEnum.gateway)
	public List<CarHistory> selectCarHistory(Map<String,Object> param){
		String hour = param.get("hour").toString() == null ? "" : param.get("hour").toString();
		String strMonth = param.get("strMonth").toString();
		List<CarHistory> isNull = null;
		//判断是否查询最近x个小时
		if(null != hour && !hour.equals("")){
				Integer intMonth = Integer.parseInt(strMonth);	
				Map<String ,Object> hourParam = new HashMap<String ,Object>();
				String carNumber = param.get("carNumber").toString();
				hourParam.put("numberPlate",  carNumber);
				//获取小时数
				hourParam.put("hour", hour);
				for(int i = 0;i<intMonth;i++){
					//如果为intMonth为0则当月没有数据 
					if(intMonth == 0){
						return isNull;
					}else{
						//查询当月是否有数据
						hourParam.put("strMonth", intMonth.toString());
				    	CarHistory  carHistorys = ztCarHistoryMapper.selectCarHistoryByHour(hourParam);
				    	//当月有数据则查询当前x个小时的数据并返回
				    	if(null != carHistorys){
				    		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				    		String times = formatter.format(carHistorys.getSendDatetime());
							hourParam.put("time", "'"+times+"'"); 
							List<CarHistory>  carHistoryOneHour = ztCarHistoryMapper.selectCarHistoryListByHour(hourParam);
				    		return carHistoryOneHour;
				    	}else{//当月没有数据则继续查询上一个月的
				    		intMonth = intMonth - 1 ;
				    	}
			    	}
				}
				return isNull;
		}else return ztCarHistoryMapper.selectCarHistory(param);
	}
	
	
	//point中心点,raidus半径：米
		public List<CarHistory> getCircularHistoryDatas(Date startTime, Date endTime, Point point,Double raidus) {
//			Shape geoJsonPolygon = new GeoJsonPolygon(polygon);
			Query query = new Query();
			//多边形
//			query.addCriteria(Criteria.where("receiveTime").lte(endTime.getTime()).gte(startTime.getTime()).and("geo").within(geoJsonPolygon));
			//圆形
			
			//转换为2dsphere的距离，这一步非常重要   
	        Distance distance = new Distance(raidus/1000, Metrics.KILOMETERS);
	        //画一个圆
	        Circle circle = new Circle(point,distance);
			query.addCriteria(Criteria.where("receiveTime").lte(endTime.getTime()).gte(startTime.getTime()).and("geo").withinSphere(circle));
			
			List<CarHistoryM> list = mongoTemplate.find(query, CarHistoryM.class, "zt_car_history_" + new DateTime(startTime).getMonthOfYear());
			// 每辆车只显示一次，取第一个历史点
			Set<String> carSet = new HashSet<String>();
			List<CarHistory> carHistories = new ArrayList<>();
			for (CarHistoryM historyM: list) {
				if (carSet.contains(historyM.getCarNumber())) {
					continue;
				} else {
					CarHistory carHistory = new CarHistory();
					carHistory.setBoxClose(historyM.getBoxClose());
					carHistory.setBoxEmpty(historyM.getBoxEmpty());
					carHistory.setBoxUp(historyM.getBoxUp());
					carHistory.setCarNumber(historyM.getCarNumber());;
					carHistory.setCarState(historyM.getCarState());
					carHistory.setCarWeigui(historyM.getCarWeigui());
					carHistory.setDevPhone(historyM.getDevPhone());
					carHistory.setGpsDirect(historyM.getGpsDirect());
					carHistory.setDriverId(historyM.getDriverId());
					carHistory.setGpsHeight(historyM.getGpsHeight());
					carHistory.setGpsPosX(BigDecimal.valueOf(historyM.getGeo().getX()));
					carHistory.setGpsPosY(BigDecimal.valueOf(historyM.getGeo().getY()));
					carHistory.setGpsSpeed(historyM.getGpsSpeed());
					carHistory.setGpsValid(historyM.getGpsValid());
					carHistory.setSendDatetime(new Date(historyM.getReceiveTime()));
					carHistories.add(carHistory);
					carSet.add(historyM.getCarNumber());
				}
			}
			return carHistories;
		
		}
}
