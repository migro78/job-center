package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 订单响应表
 * </p>
 *
 * @author ty
 * @since 2020-10-14
 */
@ApiModel("订单响应表")
@SuppressWarnings("serial")
public class PurResponse extends BaseModel {

    @ApiModelProperty(value = "订单id")
	private Long orderId;
    @ApiModelProperty(value = "医疗机构id")
	private Long hosId;
	@ApiModelProperty(value = "响应单编码")
	private String code;
    @ApiModelProperty(value = "医疗机构名称")
	private String hosName;
    @ApiModelProperty(value = "供应商id")
	private Long supId;
    @ApiModelProperty(value = "供应商名称")
	private String supName;
    @ApiModelProperty(value = "状态  0--保存  1--响应  2--配送完成  3--部分配送 4--作废")
	private Integer status;
    @ApiModelProperty(value = "预计到货时间")
	private Date arriveTime;
    @ApiModelProperty(value = "创建时间")
	private Date createTime;
    @ApiModelProperty(value = "创建人")
	private Long createBy;
    @ApiModelProperty(value = "更新时间")
	private Date updateTime;
    @ApiModelProperty(value = "更新人")
	private Long updateBy;


	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getHosId() {
		return hosId;
	}

	public void setHosId(Long hosId) {
		this.hosId = hosId;
	}

	public String getHosName() {
		return hosName;
	}

	public void setHosName(String hosName) {
		this.hosName = hosName;
	}

	public Long getSupId() {
		return supId;
	}

	public void setSupId(Long supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}