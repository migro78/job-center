package com.migro.jobcenter.service.impl;

import com.migro.jobcenter.mapper.BillPurchaseOrderResponseMapper;
import com.migro.jobcenter.model.*;
import com.migro.jobcenter.model.vo.PurDeliveryVO;
import com.migro.jobcenter.model.vo.PurResponseVO;
import com.migro.jobcenter.service.IBillPurchaseOrderResponseService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.doublewin.core.base.BaseService;
import top.doublewin.core.util.DataUtil;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 订单响应表 服务实现类
 * </p>
 *
 * @author migro
 * @since 2020-11-20
 */
@Service(interfaceClass = IBillPurchaseOrderResponseService.class)
@Component
public class BillPurchaseOrderResponseServiceImpl extends BaseService<BillPurchaseOrderResponse, BillPurchaseOrderResponseMapper> implements IBillPurchaseOrderResponseService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importResponse(List<PurResponseVO> list) {
        if (DataUtil.isNotEmpty(list)) {
            for (PurResponseVO bill : list) {
                // 先删除原有响应单数据
                BillPurchaseOrderResponse delParam = new BillPurchaseOrderResponse();
                delParam.setPlOrderId(bill.getOrderId().toString());
                super.delete(delParam);
                // 写入明细对象
                List<PurResponseDetails> details = bill.getPurResponseDetails();
                if (DataUtil.isNotEmpty(details)) {
                    for (PurResponseDetails detail : details) {
                        BillPurchaseOrderResponse response = new BillPurchaseOrderResponse();

                        response.setPlOrderId(detail.getOrderId().toString());
                        response.setOrderId(bill.getOrderCode());
                        response.setRespNum(detail.getRespNum());
                        response.setRespTime(new Date());
                        response.setBdCode(detail.getCode());

                        mapper.insertResponseData(response);
                    }
                }
                // 更新订单状态
                mapper.updateOrderStatus(bill);
            }
            return "成功下载响应单" + list.size() + "条";
        }
        return "成功下载响应单0条";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importDelivery(List<PurDeliveryVO> list) {
        if (DataUtil.isNotEmpty(list)) {
            for (PurDeliveryVO bill : list) {
                // 先删除原有配送单
                // 删除明细
                mapper.deleteDeliveryDetail(bill);
                // 删除主表
                mapper.deleteDelivery(bill);

                // 插入主表
                mapper.insertDelivery(bill);
                // 插入明细
                List<PurDeliveryDetails> detailsList = bill.getDetails();
                if(DataUtil.isNotEmpty(detailsList)){
                    detailsList.stream().forEach(t->{
                        mapper.insertDeliveryDetail(t);
                    });
                }
            }
            return "成功下载配送单"+list.size()+"条";
        }
        return "成功下载配送单0条";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importMaterial(List<BdMaterial> list) {
        if(DataUtil.isNotEmpty(list)){
            list.stream().forEach(t->{
                // 先删除旧数据
                mapper.deleteMaterial(t);
                // 插入新数据
                mapper.insertMaterial(t);
            });
            return "成功下载耗材字典"+list.size()+"条";
        }
        return "成功下载耗材字典0条";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importMaterialVar(List<BdMaterialVar> list) {
        if(DataUtil.isNotEmpty(list)){
            list.stream().forEach(t->{
                // 先删除旧数据
                mapper.deleteMaterialVar(t);
                // 插入新数据
                mapper.insertMaterialVar(t);
            });
            return "成功下载耗材品种"+list.size()+"条";
        }
        return "成功下载耗材品种0条";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importSupply(List<SupOrgInfo> list) {
        if(DataUtil.isNotEmpty(list)){
            list.stream().forEach(t->{
                // 检查数据是否存在
                Integer exist = mapper.existSupply(t);
                if(DataUtil.isNotEmpty(exist) && exist==1){
                    // 如果存在则进行更新
                    mapper.updateSupply(t);
                } else {
                    // 插入新数据
                    mapper.insertSupply(t);
                }
            });
            return "成功下载供应商字典"+list.size()+"条";
        }
        return "成功下载供应商字典0条";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importLicense(List<OrgCert> list) {
        if(DataUtil.isNotEmpty(list)){
            list.stream().forEach(t->{
                // 先删除旧数据
                mapper.deleteLicense(t);
                // 插入新数据
                mapper.insertLicense(t);
            });
            return "成功下供应商证照"+list.size()+"条";
        }
        return "成功下供应商证照0条";
    }
}
