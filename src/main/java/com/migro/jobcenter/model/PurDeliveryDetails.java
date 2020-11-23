package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 配送单明细
 * </p>
 *
 * @author migro
 * @since 2020-10-20
 */
@ApiModel("配送单明细")
@SuppressWarnings("serial")
public class PurDeliveryDetails extends BaseModel {

    @ApiModelProperty(value = "配送单id")
	private Long shipId;
    @ApiModelProperty(value = "订单id")
	private Long ordId;
    @ApiModelProperty(value = "订单编号")
	private String ordNo;
    @ApiModelProperty(value = "响应单id")
	private Long respId;
    @ApiModelProperty(value = "装箱编号")
	private String pkgNo;
    @ApiModelProperty(value = "耗材id")
	private Long matId;
    @ApiModelProperty(value = "耗材编码")
	private String matCode;
    @ApiModelProperty(value = "耗材名称")
	private String matName;
    @ApiModelProperty(value = "规格")
	private String spec;
    @ApiModelProperty(value = "配送数量")
	private Double sendNum;
    @ApiModelProperty(value = "单位")
	private String unit;
    @ApiModelProperty(value = "生产厂商")
	private String factory;
    @ApiModelProperty(value = "件数")
	private Double pkgNum;
    @ApiModelProperty(value = "每箱数量")
	private Double pkgCapacity;
    @ApiModelProperty(value = "批次")
	private String batchLot;
    @ApiModelProperty(value = "批号")
	private String batchNo;
    @ApiModelProperty(value = "效期")
	private Date validDate;
    @ApiModelProperty(value = "生产日期")
	private Date prodDate;
    @ApiModelProperty(value = "进价")
	private Double price;
    @ApiModelProperty(value = "发票号")
	private String invoiceNo;
    @ApiModelProperty(value = "发票时间")
	private Date invoiceTime;
    @ApiModelProperty(value = "是否装箱   1--装箱  2--未装箱")
	private Integer isPkg;
    @ApiModelProperty(value = "装箱类型   1--整箱  2--拼箱")
	private Integer pkgType;
    @ApiModelProperty(value = "收货数量")
	private Double takeNum;


	public Long getShipId() {
		return shipId;
	}

	public void setShipId(Long shipId) {
		this.shipId = shipId;
	}

	public Long getOrdId() {
		return ordId;
	}

	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}

	public String getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}

	public Long getRespId() {
		return respId;
	}

	public void setRespId(Long respId) {
		this.respId = respId;
	}

	public String getPkgNo() {
		return pkgNo;
	}

	public void setPkgNo(String pkgNo) {
		this.pkgNo = pkgNo;
	}

	public Long getMatId() {
		return matId;
	}

	public void setMatId(Long matId) {
		this.matId = matId;
	}

	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Double getSendNum() {
		return sendNum;
	}

	public void setSendNum(Double sendNum) {
		this.sendNum = sendNum;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public Double getPkgNum() {
		return pkgNum;
	}

	public void setPkgNum(Double pkgNum) {
		this.pkgNum = pkgNum;
	}

	public Double getPkgCapacity() {
		return pkgCapacity;
	}

	public void setPkgCapacity(Double pkgCapacity) {
		this.pkgCapacity = pkgCapacity;
	}

	public String getBatchLot() {
		return batchLot;
	}

	public void setBatchLot(String batchLot) {
		this.batchLot = batchLot;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public Date getProdDate() {
		return prodDate;
	}

	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceTime() {
		return invoiceTime;
	}

	public void setInvoiceTime(Date invoiceTime) {
		this.invoiceTime = invoiceTime;
	}

	public Integer getIsPkg() {
		return isPkg;
	}

	public void setIsPkg(Integer isPkg) {
		this.isPkg = isPkg;
	}

	public Integer getPkgType() {
		return pkgType;
	}

	public void setPkgType(Integer pkgType) {
		this.pkgType = pkgType;
	}

	public Double getTakeNum() {
		return takeNum;
	}

	public void setTakeNum(Double takeNum) {
		this.takeNum = takeNum;
	}

}