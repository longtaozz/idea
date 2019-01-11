package com.zt.jinanzf.monitor.record.model;  

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

/**
 * 通知记录对象
 */
@Data
@TableName("app_push_record")
public class PushRecord implements Serializable{

    /**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -1518492010490475281L;
	private Integer pushRecordId;//id
    private Integer pushGenreId;//推送类型id
    private String pushGenreName;//推送类型
    private String pushRecordTitle;//标题
    private String pushRecordContent;//内容
    
    private Date pushRecordTime;//推送时间
    
    private Integer userId;//推送人
    private Integer quiltUserId; //接收人
    private Integer pushState;//0、未读1、已读
    private Integer pushDataId;//推送详细内容id
    
    
}
