package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 配送单
 * </p>
 *
 * @author migro
 * @since 2020-10-20
 */
@ApiModel("配送单")
@SuppressWarnings("serial")
public class PurDelivery extends BaseModel {

    @ApiModelProperty(value = "配送单号")
	private String shipNo;
    @ApiModelProperty(value = "响应单号(多个响应单用逗号分隔)")
	private String respNo;
    @ApiModelProperty(value = "订单编号(多个响应单用逗号分隔)")
	private String ordNo;
    @ApiModelProperty(value = "医疗机构id")
	private Long hosId;
    @ApiModelProperty(value = "医疗机构名称")
	private String hosName;
    @ApiModelProperty(value = "供应商id")
	private Long supId;
    @ApiModelProperty(value = "供应商名称")
	private String supName;
    @ApiModelProperty(value = "装车单号")
	private String loadNo;
    @ApiModelProperty(value = "状态  1--新建  2--发货  3--入库  4--拒收")
	private Integer status;
    @ApiModelProperty(value = "送货人")
	private String sender;
    @ApiModelProperty(value = "送货人电话")
	private String senderTel;
    @ApiModelProperty(value = "发货仓库")
	private String shipStore;
    @ApiModelProperty(value = "发货时间")
	private Date shipTime;
    @ApiModelProperty(value = "收货人")
	private String taker;
    @ApiModelProperty(value = "收货人电话")
	private String takerTel;
    @ApiModelProperty(value = "收货地址")
	private String takerAddr;
    @ApiModelProperty(value = "收货仓库")
	private String takerStore;
    @ApiModelProperty(value = "创建时间")
	private Date createTime;
    @ApiModelProperty(value = "创建人")
	private Long createBy;
    @ApiModelProperty(value = "更新时间")
	private Date updateTime;
    @ApiModelProperty(value = "更新人")
	private Long updateBy;


	public String getShipNo() {
		return shipNo;
	}

	public void setShipNo(String shipNo) {
		this.shipNo = shipNo;
	}

	public String getRespNo() {
		return respNo;
	}

	public void setRespNo(String respNo) {
		this.respNo = respNo;
	}

	public String getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
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

	public String getLoadNo() {
		return loadNo;
	}

	public void setLoadNo(String loadNo) {
		this.loadNo = loadNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderTel() {
		return senderTel;
	}

	public void setSenderTel(String senderTel) {
		this.senderTel = senderTel;
	}

	public String getShipStore() {
		return shipStore;
	}

	public void setShipStore(String shipStore) {
		this.shipStore = shipStore;
	}

	public Date getShipTime() {
		return shipTime;
	}

	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}

	public String getTaker() {
		return taker;
	}

	public void setTaker(String taker) {
		this.taker = taker;
	}

	public String getTakerTel() {
		return takerTel;
	}

	public void setTakerTel(String takerTel) {
		this.takerTel = takerTel;
	}

	public String getTakerAddr() {
		return takerAddr;
	}

	public void setTakerAddr(String takerAddr) {
		this.takerAddr = takerAddr;
	}

	public String getTakerStore() {
		return takerStore;
	}

	public void setTakerStore(String takerStore) {
		this.takerStore = takerStore;
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

}