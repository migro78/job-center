package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 耗材产品表
 * </p>
 *
 * @author migro
 * @since 2020-11-27
 */
@ApiModel("耗材产品表")
@SuppressWarnings("serial")
public class BdMaterial extends BaseModel {

    @ApiModelProperty(value = "品种id")
	private Long varId;
    @ApiModelProperty(value = "耗材编码")
	private String code;
    @ApiModelProperty(value = "耗材品名")
	private String name;
    @ApiModelProperty(value = "拼音码")
	private String pinyin;
    @ApiModelProperty(value = "规格型号")
	private String spec;
    @ApiModelProperty(value = "价格")
	private Double price;
    @ApiModelProperty(value = "计量单位")
	private String unit;
    @ApiModelProperty(value = "包装单位")
	private String pkgUnit;
    @ApiModelProperty(value = "包装系数")
	private Integer pkgFactor;
    @ApiModelProperty(value = "耗材类型  1-普通耗材 2-高值耗材 3-试剂 4-设备 5-器械")
	private Integer type;
    @ApiModelProperty(value = "医保编码单品ID")
	private String ybSkuId;
    @ApiModelProperty(value = "医保耗材DI编码")
	private String udiCode;
    @ApiModelProperty(value = "状态  1--启用 0--停用  2--删除")
	private Integer status;
    @ApiModelProperty(value = "创建时间")
	private Date createTime;
    @ApiModelProperty(value = "创建人")
	private Long createBy;
    @ApiModelProperty(value = "更新时间")
	private Date updateTime;
    @ApiModelProperty(value = "更新人")
	private Long updateBy;
    @ApiModelProperty(value = "备注")
	private String remark;


	public Long getVarId() {
		return varId;
	}

	public void setVarId(Long varId) {
		this.varId = varId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPkgUnit() {
		return pkgUnit;
	}

	public void setPkgUnit(String pkgUnit) {
		this.pkgUnit = pkgUnit;
	}

	public Integer getPkgFactor() {
		return pkgFactor;
	}

	public void setPkgFactor(Integer pkgFactor) {
		this.pkgFactor = pkgFactor;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getYbSkuId() {
		return ybSkuId;
	}

	public void setYbSkuId(String ybSkuId) {
		this.ybSkuId = ybSkuId;
	}

	public String getUdiCode() {
		return udiCode;
	}

	public void setUdiCode(String udiCode) {
		this.udiCode = udiCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}