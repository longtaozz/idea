package com.zt.jinanzf.monitor.notice.model;

import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
@TableName("zt_notice")
public class Notice implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long noticeId;

	private Integer cityId;

	private String content;//通知内容

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private String sendDatetime;//发送时间

	private String senderUsername;//发送人姓名
	
	private String noticeTitel;
	
	private String noticeFile;

}