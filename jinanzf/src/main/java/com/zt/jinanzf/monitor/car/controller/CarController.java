package com.zt.jinanzf.monitor.car.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.zt.jinanzf.common.util.CheckTokenUtil;
import com.zt.jinanzf.common.util.TokenUtil;
import com.zt.jinanzf.common.util.UserUtil;
import com.zt.jinanzf.monitor.car.model.Car;
import com.zt.jinanzf.monitor.car.service.CarService;
import com.zt.jinanzf.monitor.user.model.User;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/project/car")
public class CarController {

	@Value("${jwt.token.header}")
	protected String header;

	@Autowired
	private TokenUtil tokenUtil;
	@Autowired
	private CarService carService;

	@Autowired
	private static CheckTokenUtil checkTokenUtil;
	
	@Autowired
	private  UserUtil   userUtil;
	
	@Autowired
	private HttpServletRequest request;
	/**
	 * @Description: 查询车辆信息
	 * @param param
	 * @date 2018年6月14日
	 */
	@SuppressWarnings("static-access")
	@ApiOperation(value = "查询车辆信息", response = Car.class)
	@RequestMapping(value = "selectCarAndAll", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> selectCarAndAll(@RequestBody Map<String, String> params) {
		//String name = tokenUtil.getUsercodeFromToken(request.getHeader(this.header));
		//System.out.println(request.getHeader(this.header));
		/*if(!checkTokenUtil.existByToken(name, request.getHeader(this.header),params.get("device"))){
			return new ResponseEntity<Object>("帐号已在别的地方登录！", HttpStatus.OK);
		}*/
		Car car=carService.selectCarAndAll(params);
		return new ResponseEntity<Object>(car, HttpStatus.OK);
	}
	
	/**
	 * @Description: 查询所有车牌
	 * @param param
	 * @date 2018年6月14日
	 */
	@ApiOperation(value = "查询所有车牌", response = Car.class)
	@RequestMapping(value = "selectNumberPlate", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Car>> selectNumberPlate(@RequestBody Map<String, String> params) {
		List<Car> car=carService.selectNumberPlate(params);
		if (car == null)  
			return new ResponseEntity<List<Car>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Car>>(car, HttpStatus.OK);
	}
	
	/**
	 * 查看指定运输公司车辆
	 * @Description: TODO
	 * @param params
	 * @return   
	 * @return ResponseEntity<Page<Car>>  
	 * @throws
	 * @author YangXiao
	 * @date 2018年9月28日
	 */
	@ResponseBody
	@ApiOperation(value = "查看指定運輸公司車輛")
	@RequestMapping(value = "/getEnterpriseCarPage", method = RequestMethod.POST)
	public ResponseEntity<Page<Car>> getEnterpriseCarPage(@RequestBody Map<String,Object> params) {
		User  userObj = userUtil.getYlUserInfo();
		String enterpriseId = userObj.getEnterpriseId().toString();
		params.put("enterpriseId", enterpriseId);
		
		Integer current = null == params.get("current") || params.get("current").equals("")? 1 :(Integer)params.get("current");
		Integer size =  null == params.get("size") || params.get("size").equals("")? 10 :(Integer)params.get("size");
		Page<Car> page = new Page<Car>(current,size);
		Page<Car> carAllInfo = carService.getEnterpriseNumberPlate(page, params); 
		if(null != carAllInfo)
			return new ResponseEntity<Page<Car>>(carAllInfo,HttpStatus.OK);
		
			return new ResponseEntity<Page<Car>>(HttpStatus.NOT_FOUND);
	}
	
	
}
