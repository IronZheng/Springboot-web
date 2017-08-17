/*** Eclipse Class Decompiler plugin, copyright (c) 2016 lsquan (ceo@hb1949.com) ***/
package com.hami.serve.common.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.Expose;

@MappedSuperclass
public class BaseEntity extends IdEntity {
	@Expose
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date creatTime;
	@Expose
	private Integer state;

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
