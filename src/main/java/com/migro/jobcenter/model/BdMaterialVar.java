package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 耗材品种表
 * </p>
 *
 * @author ty
 * @since 2020-09-21
 */
@ApiModel("耗材品种表")
@SuppressWarnings("serial")
public class BdMaterialVar extends BaseModel {

    @ApiModelProperty(value = "品种编码")
	private String code;
    @ApiModelProperty(value = "通用名称")
	private String commonName;
    @ApiModelProperty(value = "通用名拼音码")
	private String pinyin;
    @ApiModelProperty(value = "材质")
	private String material;
    @ApiModelProperty(value = "注册证id")
	private Long regCertId;
    @ApiModelProperty(value = "特征参数")
	private String charact;
    @ApiModelProperty(value = "生产企业id")
	private Long factoryId;
    @ApiModelProperty(value = "经销企业id")
	private Long saleId;
    @ApiModelProperty(value = "品牌")
	private String brand;
    @ApiModelProperty(value = "产地来源（国产、进口）")
	private String origin;
    @ApiModelProperty(value = "管理类别（I   II   III）")
	private String manageCat;
    @ApiModelProperty(value = "状态  1--启用 0--停用 2--删除")
	private Integer status;
    @ApiModelProperty(value = "创建时间")
	private Date createTime;
    @ApiModelProperty(value = "创建人")
	private Long createBy;
    @ApiModelProperty(value = "创建人机构id")
	private Long createOrgId;
    @ApiModelProperty(value = "更新时间")
	private Date updateTime;
    @ApiModelProperty(value = "更新人")
	private Long updateBy;
    @ApiModelProperty(value = "备注")
	private String remark;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Long getRegCertId() {
		return regCertId;
	}

	public void setRegCertId(Long regCertId) {
		this.regCertId = regCertId;
	}

	public String getCharact() {
		return charact;
	}

	public void setCharact(String charact) {
		this.charact = charact;
	}

	public Long getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Long factoryId) {
		this.factoryId = factoryId;
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getManageCat() {
		return manageCat;
	}

	public void setManageCat(String manageCat) {
		this.manageCat = manageCat;
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

	public Long getCreateOrgId() {
		return createOrgId;
	}

	public void setCreateOrgId(Long createOrgId) {
		this.createOrgId = createOrgId;
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