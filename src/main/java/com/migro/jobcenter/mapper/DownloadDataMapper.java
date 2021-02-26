package com.migro.jobcenter.mapper;

import com.migro.jobcenter.model.*;
import com.migro.jobcenter.model.vo.PurDeliveryVO;
import com.migro.jobcenter.model.vo.PurResponseVO;
import top.doublewin.core.base.BaseMapper;
/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author migro
 * @since 2020-11-20
 */
public interface DownloadDataMapper extends BaseMapper<OrderResponse> {

    void updateOrderStatus(PurResponseVO param);

    void insertResponseData(OrderResponse param);

    void insertDelivery(PurDeliveryVO param);

    void deleteDelivery(PurDeliveryVO param);

    void insertDeliveryDetail(PurDeliveryDetails param);

    void deleteDeliveryDetail(PurDeliveryVO param);

    void insertMaterial(BdMaterial param);

    void deleteMaterial(BdMaterial param);

    void insertMaterialVar(BdMaterialVar param);

    void deleteMaterialVar(BdMaterialVar param);

    void insertSupply(SupOrgInfo param);

    Integer existSupply(SupOrgInfo param);

    void updateSupply(SupOrgInfo param);

    void insertLicense(OrgCert param);

    void deleteLicense(OrgCert param);

    void insertFactory(DicFactory param);

    void deleteFactory(DicFactory param);
}