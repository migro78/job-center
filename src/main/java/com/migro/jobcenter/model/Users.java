package com.migro.jobcenter.model;

import top.doublewin.core.base.BaseModel;
import com.baomidou.mybatisplus.annotation.TableLogic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author migro
 * @since 2020-04-27
 */
@ApiModel("用户表")
@SuppressWarnings("serial")
public class Users extends BaseModel {

    @ApiModelProperty(value = "用户名")
	private String username;
    @ApiModelProperty(value = "密码")
	private String password;
    @ApiModelProperty(value = "状态")
	private Integer enable;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

}