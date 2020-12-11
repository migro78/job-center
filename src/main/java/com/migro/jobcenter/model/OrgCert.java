package com.migro.jobcenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 机构证照资料表
 * </p>
 *
 * @author migro
 * @since 2020-12-08
 */
@ApiModel("机构证照资料表")
@SuppressWarnings("serial")
public class OrgCert extends BaseModel {

    @ApiModelProperty(value = "机构id")
	private Long orgId;
    @ApiModelProperty(value = "证照类型  1--营业执照  2--生产许可证  3--经营许可证  4--授权委托书  5--税务登记证  6--组织机构代码证  7--声明  8--说明书")
	private Integer type;
    @ApiModelProperty(value = "证照编号")
	private String code;
    @ApiModelProperty(value = "证照名称")
	private String name;
    @ApiModelProperty(value = "有效期始")
	private Date startDate;
    @ApiModelProperty(value = "有效期止")
	private Date endDate;
    @ApiModelProperty(value = "备注")
	private String remark;
    @ApiModelProperty(value = "证照附加属性(JSON格式)")
	private String attributes;
    @ApiModelProperty(value = "证照附件(JSON格式,[{orgName:\"营业执照.jpg\",fileName:\"123.jpg\"},{orgName:\"附页.jpg\",fileName:\"456.jpg\"}])")
	private String attachs;
    @ApiModelProperty(value = "状态  1--启用  0--停用")
	private Integer status;
    @ApiModelProperty(value = "创建人")
	private Long createBy;
    @ApiModelProperty(value = "创建时间")
	private Date createTime;
    @ApiModelProperty(value = "更新人")
	private Long updateBy;
    @ApiModelProperty(value = "更新时间")
	private Date updateTime;


	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getAttachs() {
		return attachs;
	}

	public void setAttachs(String attachs) {
		this.attachs = attachs;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}