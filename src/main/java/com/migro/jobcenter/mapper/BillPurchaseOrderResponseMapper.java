package com.migro.jobcenter.mapper;

import com.migro.jobcenter.model.BillPurchaseOrderResponse;
import com.migro.jobcenter.model.PurDeliveryDetails;
import com.migro.jobcenter.model.vo.PurDeliveryVO;
import top.doublewin.core.base.BaseMapper;
/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author migro
 * @since 2020-11-20
 */
public interface BillPurchaseOrderResponseMapper extends BaseMapper<BillPurchaseOrderResponse> {

    void insertResponseData(BillPurchaseOrderResponse param);

    void insertDelivery(PurDeliveryVO param);

    void deleteDelivery(PurDeliveryVO param);

    void insertDeliveryDetail(PurDeliveryDetails param);

    void deleteDeliveryDetail(PurDeliveryDetails param);
}