package com.zt.jinanzf.monitor.consapp.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zt.jinanzf.monitor.buildunit.model.ZtBuildunit;
import com.zt.jinanzf.monitor.company.model.ZtTransportEnterprises;
import com.zt.jinanzf.monitor.constructunit.model.ZtConstructUnit;
import com.zt.jinanzf.monitor.district.model.ZtDistrict;
import com.zt.jinanzf.monitor.gpsfence.model.Gpsfence;

import lombok.Data;

@Data
public class ConsappVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**工地信息主键*/
	private int consappId;
	
	/**开始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date startTime;
	/**结束时间*/
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date endTime;
	/**方量*/
	private String bulidGarbage;
	/**工地电子围栏*/
	private String gongGpsfence;
	/**施工单位Id*/
	private String constructUnitId;
	/**施工单位地址*/
	private String unitIdAddress;
	/**运输公司Id*/
	private Integer transId;
	/**路线fenceId*/
	private String luFenceId;
	/**消纳场fenceId*/
	private String xiaoNaFenceId;
	/**工地fenceId*/
	private String GongFenceId;
	/**工地主签或联运*/
	private String type;
	/**工地Guid*/
	private String gongGuidFence;
	/**路线GUid*/
	private String luGuidFence;
	/**消纳场Guid*/
	private String xiaoGuidfence;
	/**运输企业名称*/
	private String companyName;
	/**消纳场名称*/
	private String unloadingName;
	/**路线名称*/
	private String LuXianName;
	/**工程名称*/
	private String proName;
	/**工地地址*/
	private String proAddress;
	
	private String proType;//项目类型
	
	private String licType;//核准类型 licType 1：正式 2：临时
	
	private String cityId;//城市Id
	
	private String proBelong;//区域Id
	
	private String unitName;//施工单位
	
	private String licNumber;//备案编号
	
	private String buildId;//建筑ID
	
	private String buildName;//建筑单位名称
	
	private String buildRepresentative;//建筑单位负责人
	
	private String buildPhone;//单位电话
	
	private Integer constrId;
	
	private Integer responsId;
	
	private ZtDistrict districtList;//区域
	
	private ZtBuildunit ztBuildunit;//建筑单位
	
	private Integer emissionLoad;//排放量
	
	private ZtConstructUnit ztConstructUnit;
	
	private ZtTransportEnterprises ztTransportEnterprises;//运输企业
	
	private String gdState;//项目状态 gdState 7：在建工地 8：停工工地 9：整顿工地 10：待建工地
	
	private Gpsfence gpsPos;//电子围栏
	
	private String consGUID;//GUID
	
	private String gpsAddress;//关联电子围栏guid 
}
