package com.migro.jobcenter.model.vo;

import com.migro.jobcenter.model.PurOrderOper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/11/12 14:00
 */
@ApiModel("耗材采购订单表")
public class OrderVO extends BaseModel {

    @ApiModelProperty(value = "订单编号")
    private String code;
    @ApiModelProperty(value = "医疗机构id")
    private Long hosId;
    @ApiModelProperty(value = "医疗机构名称")
    private String hosName;
    @ApiModelProperty(value = "供应商id")
    private Long supId;
    @ApiModelProperty(value = "供应商名称")
    private String supName;
    @ApiModelProperty(value = "订单类型  1--采购  2--移库")
    private Integer ordType;
    @ApiModelProperty(value = "采购类型  1--线上  2--线下")
    private Integer purType;
    @ApiModelProperty(value = "状态  1--下单  2--完全响应  3--部分响应  4--发货  5--入库   6--拒绝")
    private Integer status;
    @ApiModelProperty(value = "收货人")
    private String recUser;
    @ApiModelProperty(value = "收货人联系电话")
    private String recPhone;
    @ApiModelProperty(value = "收货仓库")
    private String recStock;
    @ApiModelProperty(value = "收货地址id")
    private Long recAddrId;
    @ApiModelProperty(value = "收货地址")
    private String recAddr;
    @ApiModelProperty(value = "加急订单  0--不加急  1--加急")
    private Integer urgent;
    @ApiModelProperty(value = "提交人")
    private String subUser;
    @ApiModelProperty(value = "提交时间")
    private Date subTime;
    @ApiModelProperty(value = "响应人")
    private String respUser;
    @ApiModelProperty(value = "响应时间")
    private Date respTime;
    @ApiModelProperty(value = "预计到货时间")
    private Date expArrTime;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "创建人")
    private Long createBy;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "更新人")
    private Long updateBy;
    @ApiModelProperty(value = "消息id")
    private String msgId;

    private List<OrderDetailVO> details;
    @ApiModelProperty(value = "跟台订单手术信息")
    private PurOrderOper orderOper;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getOrdType() {
        return ordType;
    }

    public void setOrdType(Integer ordType) {
        this.ordType = ordType;
    }

    public Integer getPurType() {
        return purType;
    }

    public void setPurType(Integer purType) {
        this.purType = purType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRecUser() {
        return recUser;
    }

    public void setRecUser(String recUser) {
        this.recUser = recUser;
    }

    public String getRecPhone() {
        return recPhone;
    }

    public void setRecPhone(String recPhone) {
        this.recPhone = recPhone;
    }

    public String getRecStock() {
        return recStock;
    }

    public void setRecStock(String recStock) {
        this.recStock = recStock;
    }

    public Long getRecAddrId() {
        return recAddrId;
    }

    public void setRecAddrId(Long recAddrId) {
        this.recAddrId = recAddrId;
    }

    public String getRecAddr() {
        return recAddr;
    }

    public void setRecAddr(String recAddr) {
        this.recAddr = recAddr;
    }

    public Integer getUrgent() {
        return urgent;
    }

    public void setUrgent(Integer urgent) {
        this.urgent = urgent;
    }

    public String getSubUser() {
        return subUser;
    }

    public void setSubUser(String subUser) {
        this.subUser = subUser;
    }

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public String getRespUser() {
        return respUser;
    }

    public void setRespUser(String respUser) {
        this.respUser = respUser;
    }

    public Date getRespTime() {
        return respTime;
    }

    public void setRespTime(Date respTime) {
        this.respTime = respTime;
    }

    public Date getExpArrTime() {
        return expArrTime;
    }

    public void setExpArrTime(Date expArrTime) {
        this.expArrTime = expArrTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public List<OrderDetailVO> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailVO> details) {
        this.details = details;
    }
}
