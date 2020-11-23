package com.migro.jobcenter.model.vo;


import com.migro.jobcenter.model.PurDelivery;
import com.migro.jobcenter.model.PurDeliveryDetails;

import java.util.List;

public class PurDeliveryVO extends PurDelivery {

    private List<PurDeliveryDetails> details;

    public List<PurDeliveryDetails> getDetails() {
        return details;
    }

    public void setDetails(List<PurDeliveryDetails> purDeliveryDetailsVOList) {
        this.details = purDeliveryDetailsVOList;
    }
}
