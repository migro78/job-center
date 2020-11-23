package com.migro.jobcenter.model.vo;

import com.migro.jobcenter.model.PurResponse;
import com.migro.jobcenter.model.PurResponseDetails;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PurResponseVO extends PurResponse {

    private List<PurResponseDetails> purResponseDetails;
    @ApiModelProperty(value = "订单编号")
    private String orderCode;


    public List<PurResponseDetails> getPurResponseDetails() {
        return purResponseDetails;
    }

    public void setPurResponseDetails(List<PurResponseDetails> purResponseDetails) {
        this.purResponseDetails = purResponseDetails;
    }


    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String code) {
        this.orderCode = code;
    }


}
