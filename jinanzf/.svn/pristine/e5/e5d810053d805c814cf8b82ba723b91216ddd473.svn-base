package com.zt.jinanzf.monitor.carruntime.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.monitor.car.mapper.CarMapper;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.carruntime.model.CarRuntime;
import com.zt.jinanzf.monitor.carruntime.model.StatisticsInfo;
import com.zt.jinanzf.monitor.carruntime.service.CarRuntimeService;
import com.zt.jinanzf.monitor.consapp.service.ConsappService;
import com.zt.jinanzf.monitor.unloading.service.UnloadingService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/project/carruntime")
public class CarRunTimeController {

	@Value("${jwt.token.header}")
	protected String header;

	@Autowired
	private CarMapper carMapper;

	@Autowired
	private CarRuntimeService carRuntimeService;
	
	@Autowired
	private ConsappService consappService;
	
	@Autowired 
	private UnloadingService unloadingService;
	/**
	 * @Description: 查询车辆实时位置
	 * @param param
	 * @return ResponseEntity<Page<CarRuntime>>
	 * @date 2018年6月14日
	 */
	@ApiOperation(value = "查询车辆实时位置", response = CarRuntime.class)
	@ApiImplicitParam(name = "carNumber", value = "车牌号", dataType = "String", paramType = "path")
	@RequestMapping(value = "selectCarRuntime", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<Page<CarRuntime>> selectCarRuntime(@RequestBody Map<String, Object> params) {
		Integer current = null == params.get("current") || params.get("current").equals("") ? 1
				: (Integer) params.get("current");
		Integer size = null == params.get("size") || params.get("size").equals("") ? 4000
				: (Integer) params.get("size");
		String carNumber = null == params.get("carNumber") || params.get("carNumber").equals("") ? ""
				: params.get("carNumber").toString();
		Map<String, String> param = new HashMap<>();
		param.put("carNumber", carNumber);
		List<String> str = new ArrayList<>();
		if (null != carNumber) {
			List<Car> carNumbers = carMapper.selectNumberPlate(param);
			for (int i = 0; i < carNumbers.size(); i++) {
				str.add(i, carNumbers.get(i).getNumberPlate());
			}
			if (str.isEmpty()) {
				str.add(" . ");
			}
			params.put("str", str);
		}
		Page<CarRuntime> page = new Page<CarRuntime>(current, size);
		Page<CarRuntime> list = carRuntimeService.selectCarRuntime(page, params);
		if (list == null)
			return new ResponseEntity<Page<CarRuntime>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Page<CarRuntime>>(list, HttpStatus.OK);
	} 
	
	
	/**
	 * 
	 * @Description: 实时位置数量统计接口
	 * @param params
	 * @return ResponseEntity<Page<StatisticsInfo>>  
	 * @author YangXiao
	 * @date 2018年10月16日
	 */
	@ApiOperation(value = "统计数量", response = StatisticsInfo.class)
	@RequestMapping(value = "statisticsInfoTotal", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public StatisticsInfo StatisticsInfoTotal() {
		StatisticsInfo  statisticsInfo   =  new StatisticsInfo();
		Map<String, Object>  map = new  HashMap<>();
		statisticsInfo.setConsappTotal(consappService.getAllConsappCount(map));  //工地总数
		statisticsInfo.setUnloadingotal(unloadingService.getUnloadingAreaCount());//消纳场
		statisticsInfo.setCarTotal(carMapper.getCarTotal(map));//车辆总数
		statisticsInfo.setNormalCarTotal(carRuntimeService.getCarRuntimeTotal(map));//这场车辆总数
		return  statisticsInfo;
	}
	
	/**
	 * 正常车辆实时位置
	 * @Description: TODO
	 * @return   
	 * @return StatisticsInfo  
	 * @throws
	 * @author YangXiao
	 * @date 2018年10月16日
	 */
	@RequestMapping(value = "carRuntimeNormal", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<CarRuntime> carRuntimeNormal(){
		Map<String, Object>  map = new  HashMap<>();
		map.put("onlineState", "0");
		List<CarRuntime>  carRuntimeList  = carRuntimeService.getCarRuntime(map);
		return  carRuntimeList;
	}
	
	/**
	 * 查询所有车辆实时位置
	 * @Description: TODO
	 * @return List<CarRuntime>  
	 * @author YangXiao
	 * @date 2018年10月16日
	 */
	@RequestMapping(value = "carRuntimeAll", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public List<CarRuntime> carRuntimeAll(){
		Map<String, Object>  map = new  HashMap<>();
		map.put("onlineState", "0");
		List<CarRuntime>  carRuntimeList  = carRuntimeService.getCarRuntime(map);
		return  carRuntimeList;
	}
}
