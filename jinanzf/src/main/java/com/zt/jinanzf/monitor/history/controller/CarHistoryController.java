package com.zt.jinanzf.monitor.history.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zt.jinanzf.common.util.CoordinateConversion;
import com.zt.jinanzf.common.util.Point;
import com.zt.jinanzf.monitor.history.model.CarHistory;
import com.zt.jinanzf.monitor.history.service.ZtCarHistoryService;

import io.swagger.annotations.ApiOperation;

/**
 * ClassName: CarHistoryController
 * 
 * @Description: 历史记录相关接口
 * @author chenlijun
 * @date 2018年9月7日
 */
@RestController
@RequestMapping("/project/history")
public class CarHistoryController {

	// @Autowired
	// private CarService carService;

	@Value("${jwt.token.header}")
	protected String header;

	@Autowired
	private ZtCarHistoryService ztCarHistoryService;

	// 车辆历史轨迹
	@ApiOperation(value = "查询车辆历史轨迹", response = CarHistory.class)
	@RequestMapping(value = "selectCarHistory", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<CarHistory>> selectCarHistory(@RequestBody Map<String, ?> param) throws ParseException {
		/* 获取当月月份 */
		SimpleDateFormat formatter = new SimpleDateFormat("M");
		String strMonth = formatter.format(new Date());
		Map<String, Object> carParam = new HashMap<String, Object>();
		String hour = null == param.get("hour")?"":param.get("hour").toString();
		carParam.put("time", "");
		carParam.put("hour", hour);
		carParam.put("strMonth", strMonth);
		String carNumber = (null == param.get("carNumber")?"":"'"+param.get("carNumber").toString()+"'");
		carParam.put("carNumber", carNumber);
		// 根据时间查询历史轨迹
		if (null != param.get("startTime").toString() && !param.get("startTime").toString().equals("") && null != param.get("endTime").toString() && !param.get("endTime").toString().equals("")) {
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date date = sdf.parse((String) param.get("startTime"));
			strMonth = formatter.format(date);
			try {
				// 将查询条件传入map
				String starTime = sdf.format(sdf.parse((String) param.get("startTime")));
				String enTime = sdf.format(sdf.parse((String) param.get("endTime")));
				carParam.put("starTime", "'" + starTime + "'");
				carParam.put("enTime", "'" + enTime + "'");
				carParam.put("strMonth", strMonth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		List<CarHistory> carHistory = ztCarHistoryService.selectCarHistory(carParam);
		if (carHistory == null || carHistory.isEmpty() || carHistory.size() == 0) {
			carHistory = Collections.<CarHistory> emptyList();
		}
		return new ResponseEntity<List<CarHistory>>(carHistory, HttpStatus.OK);
	}

	/**
	 * 圆形疑点查车
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "circular", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<CarHistory>> circular(@RequestBody Map<?, ?> param) {
		String startTimeArea = param.get("startTime").toString() == null ? "" : param.get("startTime").toString();
		String endTimeArea = param.get("endTime").toString() == null ? "" : param.get("endTime").toString();
		List<CarHistory> carHistoryLists = new ArrayList<CarHistory>();
		Date startTime = null;
		Date endTime = null;
		if (null != startTimeArea && !startTimeArea.equals("")) {
			startTime = DateTime.parse(startTimeArea, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm")).toDate();
		}
		if (null != endTimeArea && !endTimeArea.equals("")) {
			endTime = DateTime.parse(endTimeArea, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm")).toDate();
		}
		// 坐标
		Double lng = Double.parseDouble(param.get("longitude").toString());
		Double lat = Double.parseDouble(param.get("latitude").toString());
		org.springframework.data.geo.Point pointx = new org.springframework.data.geo.Point(lng, lat);
		// 半径
		Double raidus = Double.parseDouble(param.get("raidus").toString());

		if (new DateTime(startTime)
				.isAfter(DateTime.parse("2017-12-09 00:00:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")))) {
			carHistoryLists = ztCarHistoryService.getCircularHistoryDatas(startTime, endTime, pointx, raidus);
			DecimalFormat df = new DecimalFormat("0.000000");
			for (int i = 0; i < carHistoryLists.size(); i++) {
				CarHistory ztCarHistory = carHistoryLists.get(i);
				double gpsPosX = ztCarHistory.getGpsPosX().doubleValue();
				double gpsPosY = ztCarHistory.getGpsPosY().doubleValue();
				Point point = CoordinateConversion.wgs_bd_encrypts(gpsPosY, gpsPosX);
				ztCarHistory.setGpsPosX(BigDecimal.valueOf(new Double(df.format(point.getLng()).toString())));
				ztCarHistory.setGpsPosY(BigDecimal.valueOf(new Double(df.format(point.getLat()).toString())));
			}
			return new ResponseEntity<List<CarHistory>>(carHistoryLists, HttpStatus.OK);
		}
		return new ResponseEntity<List<CarHistory>>(HttpStatus.NOT_FOUND);
	}
}
