package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 医院耗材字典
 * </p>
 *
 * @author migro
 * @since 2021-01-13
 */
@ApiModel("医院耗材字典")
@SuppressWarnings("serial")
public class HosMaterial extends BaseModel {

    @ApiModelProperty(value = "机构id")
	private Long orgId;
    @ApiModelProperty(value = "耗材编码")
	private String code;
    @ApiModelProperty(value = "耗材名称")
	private String name;
    @ApiModelProperty(value = "拼音码")
	private String pinyin;
    @ApiModelProperty(value = "规格型号")
	private String spec;
    @ApiModelProperty(value = "最小单位")
	private String unit;
    @ApiModelProperty(value = "厂商编码")
	private String factoryId;
    @ApiModelProperty(value = "厂商名称")
	private String factory;
    @ApiModelProperty(value = "注册证号")
	private String regCertCode;
    @ApiModelProperty(value = "分类编码")
	private String classCode;
    @ApiModelProperty(value = "进价")
	private Double price;
    @ApiModelProperty(value = "商品类型 1耗材 2试剂 3设备 4器械	")
	private String type;
    @ApiModelProperty(value = "是否高耗")
	private String ishight;
    @ApiModelProperty(value = "功能")
	private String functionInfo;
    @ApiModelProperty(value = "用途")
	private String useInfo;
    @ApiModelProperty(value = "材质")
	private String material;
    @ApiModelProperty(value = "状态 0-停用 1-启用")
	private Integer status;
    @ApiModelProperty(value = "创建时间")
	private Date createTime;
    @ApiModelProperty(value = "更新时间")
	private Date updateTime;



	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getRegCertCode() {
		return regCertCode;
	}

	public void setRegCertCode(String regCertCode) {
		this.regCertCode = regCertCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIshight() {
		return ishight;
	}

	public void setIshight(String ishight) {
		this.ishight = ishight;
	}

	public String getFunctionInfo() {
		return functionInfo;
	}

	public void setFunctionInfo(String functionInfo) {
		this.functionInfo = functionInfo;
	}

	public String getUseInfo() {
		return useInfo;
	}

	public void setUseInfo(String useInfo) {
		this.useInfo = useInfo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}