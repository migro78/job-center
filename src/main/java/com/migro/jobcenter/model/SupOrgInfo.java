package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 供应商基本信息表
 * </p>
 *
 * @author ty
 * @since 2020-09-24
 */
@ApiModel("供应商基本信息表")
@SuppressWarnings("serial")
public class SupOrgInfo extends BaseModel {

	@ApiModelProperty("主键id")
	private Long id;

    @ApiModelProperty(value = "企业登记注册类型")
	private String regType;
    @ApiModelProperty(value = "住所")
	private String address;
    @ApiModelProperty(value = "成立日期")
	private Date foundDate;
    @ApiModelProperty(value = "法人")
	private String legalPerson;
    @ApiModelProperty(value = "法人证件类型")
	private String legalIdType;
    @ApiModelProperty(value = "法人证件号")
	private String legalIdNo;
    @ApiModelProperty(value = "法人手机号")
	private String legalMobile;
    @ApiModelProperty(value = "法人固定电话")
	private String legalTel;
    @ApiModelProperty(value = "注册资本（单位：万）")
	private String regCapital;
    @ApiModelProperty(value = "注册资本币种（人名币、美元）")
	private String regCapitalCurrency;
    @ApiModelProperty(value = "经营范围")
	private String bizScope;
    @ApiModelProperty(value = "企业联系人姓名")
	private String contact;
    @ApiModelProperty(value = "企业电话")
	private String tel;
    @ApiModelProperty(value = "企业邮箱")
	private String email;
    @ApiModelProperty(value = "企业传真")
	private String fax;
    @ApiModelProperty(value = "委托代理人")
	private String agentPerson;
    @ApiModelProperty(value = "代理人证件类型")
	private String agentIdType;
    @ApiModelProperty(value = "代理人证件号")
	private String agentIdNo;
    @ApiModelProperty(value = "代理人手机号")
	private String agentMobile;
    @ApiModelProperty(value = "代理人固定电话")
	private String agentTel;
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


	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalIdType() {
		return legalIdType;
	}

	public void setLegalIdType(String legalIdType) {
		this.legalIdType = legalIdType;
	}

	public String getLegalIdNo() {
		return legalIdNo;
	}

	public void setLegalIdNo(String legalIdNo) {
		this.legalIdNo = legalIdNo;
	}

	public String getLegalMobile() {
		return legalMobile;
	}

	public void setLegalMobile(String legalMobile) {
		this.legalMobile = legalMobile;
	}

	public String getLegalTel() {
		return legalTel;
	}

	public void setLegalTel(String legalTel) {
		this.legalTel = legalTel;
	}

	public String getRegCapital() {
		return regCapital;
	}

	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}

	public String getRegCapitalCurrency() {
		return regCapitalCurrency;
	}

	public void setRegCapitalCurrency(String regCapitalCurrency) {
		this.regCapitalCurrency = regCapitalCurrency;
	}

	public String getBizScope() {
		return bizScope;
	}

	public void setBizScope(String bizScope) {
		this.bizScope = bizScope;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAgentPerson() {
		return agentPerson;
	}

	public void setAgentPerson(String agentPerson) {
		this.agentPerson = agentPerson;
	}

	public String getAgentIdType() {
		return agentIdType;
	}

	public void setAgentIdType(String agentIdType) {
		this.agentIdType = agentIdType;
	}

	public String getAgentIdNo() {
		return agentIdNo;
	}

	public void setAgentIdNo(String agentIdNo) {
		this.agentIdNo = agentIdNo;
	}

	public String getAgentMobile() {
		return agentMobile;
	}

	public void setAgentMobile(String agentMobile) {
		this.agentMobile = agentMobile;
	}

	public String getAgentTel() {
		return agentTel;
	}

	public void setAgentTel(String agentTel) {
		this.agentTel = agentTel;
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}