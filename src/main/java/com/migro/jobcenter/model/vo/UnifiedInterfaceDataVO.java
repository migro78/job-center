package com.migro.jobcenter.model.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <p>
 * 统一接口数据对象
 * </p>
 *
 * @author migro
 * @since 2020/11/5 16:07
 */
public class UnifiedInterfaceDataVO {
    @ApiModelProperty(value = "消息类型  1--订单")
    private Integer dataType;
    @ApiModelProperty(value = "记录条数")
    private Integer count;
    @ApiModelProperty(value = "数据流向  1--平台   2--院内")
    private Integer dataInOut;
    @ApiModelProperty(value = "数据内容(json)")
    private String dataContent;
    @ApiModelProperty(value = "消息id集合,接口处理成功后消息状态修改回写所需参数")
    private List<Long> ids;

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDataInOut() {
        return dataInOut;
    }

    public void setDataInOut(Integer dataInOut) {
        this.dataInOut = dataInOut;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
