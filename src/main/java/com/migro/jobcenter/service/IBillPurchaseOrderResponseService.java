package com.migro.jobcenter.service;

import com.alibaba.fastjson.JSONObject;
import com.migro.jobcenter.model.*;
import com.migro.jobcenter.model.vo.PurDeliveryVO;
import com.migro.jobcenter.model.vo.PurResponseVO;
import top.doublewin.core.base.IBaseService;

import java.util.List;

/**
 * <p>
 * 订单响应表  服务类
 * </p>
 *
 * @author migro
 * @since 2020-11-20
 */
public interface IBillPurchaseOrderResponseService extends IBaseService<BillPurchaseOrderResponse> {

    String importResponse(List<PurResponseVO> list);

    String importDelivery(List<PurDeliveryVO> list);

    String importMaterial(List<BdMaterial> list);

    String importMaterialVar(List<BdMaterialVar> list);

    String importSupply(List<SupOrgInfo> list);

    String importLicense(List<OrgCert> list);

    String importFactory(List<DicFactory> list);
}