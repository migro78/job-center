package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

/**
 * <p>
 * 订单响应明细表
 * </p>
 *
 * @author ty
 * @since 2020-10-14
 */
@ApiModel("订单响应明细表")
@SuppressWarnings("serial")
public class PurResponseDetails extends BaseModel {

    @ApiModelProperty(value = "响应单id")
	private Long respId;
    @ApiModelProperty(value = "订单id")
	private Long orderId;
    @ApiModelProperty(value = "订单明细id")
	private Long orderDetailId;
    @ApiModelProperty(value = "耗材id")
	private Long matId;
    @ApiModelProperty(value = "响应数量")
	private Double respNum;
    @ApiModelProperty(value = "备注")
	private String remark;


	public Long getRespId() {
		return respId;
	}

	public void setRespId(Long respId) {
		this.respId = respId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Long getMatId() {
		return matId;
	}

	public void setMatId(Long matId) {
		this.matId = matId;
	}

	public Double getRespNum() {
		return respNum;
	}

	public void setRespNum(Double respNum) {
		this.respNum = respNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}