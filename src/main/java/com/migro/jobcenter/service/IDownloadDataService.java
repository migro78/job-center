package com.migro.jobcenter.service;

import com.migro.jobcenter.model.*;
import com.migro.jobcenter.model.vo.PurDeliveryVO;
import com.migro.jobcenter.model.vo.PurResponseVO;
import top.doublewin.core.base.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单响应表  服务类
 * </p>
 *
 * @author migro
 * @since 2020-11-20
 */
public interface IDownloadDataService extends IBaseService<OrderResponse> {

    /**
     * 数据下载更新
     *
     * @param
     * @return
     */
    String downloadData(Map<String, Object> param);

    String importResponse(List<PurResponseVO> list);

    String importDelivery(List<PurDeliveryVO> list);

    String importMaterial(List<BdMaterial> list);

    String importMaterialVar(List<BdMaterialVar> list);

    String importSupply(List<SupOrgInfo> list);

    String importLicense(List<OrgCert> list);

    String importFactory(List<DicFactory> list);
}