package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 跟台订单手术信息
 * </p>
 *
 * @author migro
 * @since 2020-10-22
 */
@ApiModel("跟台订单手术信息")
@SuppressWarnings("serial")
public class PurOrderOper extends BaseModel {

    @ApiModelProperty(value = "订单id")
	private Long ordId;
    @ApiModelProperty(value = "患者性别")
	private String sex;
    @ApiModelProperty(value = "年龄")
	private String age;
    @ApiModelProperty(value = "体重")
	private String weight;
    @ApiModelProperty(value = "手术名称")
	private String operName;
    @ApiModelProperty(value = "部位")
	private String operPosition;
    @ApiModelProperty(value = "手术时间")
	private Date operDate;
    @ApiModelProperty(value = "临床信息")
	private String clinical;


	public Long getOrdId() {
		return ordId;
	}

	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getOperPosition() {
		return operPosition;
	}

	public void setOperPosition(String operPosition) {
		this.operPosition = operPosition;
	}

	public Date getOperDate() {
		return operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	public String getClinical() {
		return clinical;
	}

	public void setClinical(String clinical) {
		this.clinical = clinical;
	}

}