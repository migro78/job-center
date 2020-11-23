package com.migro.jobcenter.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import top.doublewin.core.base.BaseModel;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 订单响应表
 * </p>
 *
 * @author migro
 * @since 2020-11-20
 */
@ApiModel("订单响应表")
@TableName("BILL_PURCHASE_ORDER_RESPONSE")
@SuppressWarnings("serial")
public class BillPurchaseOrderResponse extends BaseModel {

	@ApiModelProperty("主键id")
	@TableId(value = "ID",type = IdType.AUTO)
	private Long id;
    @ApiModelProperty(value = "平台订单编码")
	@TableField("PL_ORDER_ID")
	private String plOrderId;
    @ApiModelProperty(value = "订单编号")
	@TableField("ORDER_ID")
	private String orderId;
    @ApiModelProperty(value = "计划编码")
	@TableField("PLAN_ID")
	private String planId;
    @ApiModelProperty(value = "耗材编码")
	@TableField("MATERIAL_CODE")
	private String materialCode;
    @ApiModelProperty(value = "响应数量")
	@TableField("RESP_NUM")
	private Double respNum;
    @ApiModelProperty(value = "响应时间")
	@TableField("RESP_TIME")
	private Date respTime;
    @ApiModelProperty(value = "平台耗材编码")
	@TableField("BD_CODE")
	private String bdCode;


	public String getPlOrderId() {
		return plOrderId;
	}

	public void setPlOrderId(String plOrderId) {
		this.plOrderId = plOrderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public Double getRespNum() {
		return respNum;
	}

	public void setRespNum(Double respNum) {
		this.respNum = respNum;
	}

	public Date getRespTime() {
		return respTime;
	}

	public void setRespTime(Date respTime) {
		this.respTime = respTime;
	}

	public String getBdCode() {
		return bdCode;
	}

	public void setBdCode(String bdCode) {
		this.bdCode = bdCode;
	}

}