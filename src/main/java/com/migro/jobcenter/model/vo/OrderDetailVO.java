package com.migro.jobcenter.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/11/12 16:16
 */
@ApiModel("耗材采购订单明细")
public class OrderDetailVO extends BaseModel {
    @ApiModelProperty(value = "订单id")
    private Long orderId;
    @ApiModelProperty(value = "订单编码")
    private String code;
    @ApiModelProperty(value = "序号")
    private Integer serialNo;
    @ApiModelProperty(value = "耗材id")
    private Long matId;
    @ApiModelProperty(value = "耗材编码")
    private String matCode;
    @ApiModelProperty(value = "耗材名称")
    private String matName;
    @ApiModelProperty(value = "规格型号")
    private String spec;
    @ApiModelProperty(value = "单位")
    private String unit;
    @ApiModelProperty(value = "生产厂商")
    private String factory;
    @ApiModelProperty(value = "采购数量")
    private Double purNum;
    @ApiModelProperty(value = "响应数量")
    private Double respNum;
    @ApiModelProperty(value = "入库数量")
    private Double inNum;
    @ApiModelProperty(value = "单价")
    private Double price;
    @ApiModelProperty(value = "备注")
    private String remark;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
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

    public Double getPurNum() {
        return purNum;
    }

    public void setPurNum(Double purNum) {
        this.purNum = purNum;
    }

    public Double getRespNum() {
        return respNum;
    }

    public void setRespNum(Double respNum) {
        this.respNum = respNum;
    }

    public Double getInNum() {
        return inNum;
    }

    public void setInNum(Double inNum) {
        this.inNum = inNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
