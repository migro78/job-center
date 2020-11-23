package com.migro.jobcenter.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.migro.jobcenter.model.BillPurchaseOrderResponse;
import com.migro.jobcenter.mapper.BillPurchaseOrderResponseMapper;
import com.migro.jobcenter.model.PurResponseDetails;
import com.migro.jobcenter.model.vo.PurDeliveryVO;
import com.migro.jobcenter.model.vo.PurResponseVO;
import com.migro.jobcenter.service.IBillPurchaseOrderResponseService;
import org.springframework.transaction.annotation.Transactional;
import top.doublewin.core.base.BaseService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
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
                // 明细对象
                List<PurResponseDetails> details = bill.getPurResponseDetails();
                if (DataUtil.isNotEmpty(details)) {
                    for (PurResponseDetails detail : details) {
                        BillPurchaseOrderResponse response = new BillPurchaseOrderResponse();

                        response.setPlOrderId(detail.getOrderId().toString());
                        response.setOrderId(bill.getOrderCode());
                        response.setRespNum(detail.getRespNum());
                        response.setRespTime(new Date());
                        response.setBdCode(detail.getMatId().toString());

                        mapper.insertResponseData(response);
                    }
                }
            }
            return "成功下载响应单" + list.size() + "条";
        }
        return "成功下载响应单0条";
    }

    @Override
    public String importDelivery(List<PurDeliveryVO> list) {
        if (DataUtil.isNotEmpty(list)) {
            // 先删除，后插入
            for (PurDeliveryVO bill : list) {



            }

        }
        return null;
    }
}
