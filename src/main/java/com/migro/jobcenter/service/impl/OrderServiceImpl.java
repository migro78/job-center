package com.migro.jobcenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.migro.jobcenter.client.DataInOut;
import com.migro.jobcenter.client.DataType;
import com.migro.jobcenter.client.HttpClient;
import com.migro.jobcenter.enums.MsgDataType;
import com.migro.jobcenter.mapper.OrderMapper;
import com.migro.jobcenter.model.*;
import com.migro.jobcenter.model.vo.*;
import com.migro.jobcenter.service.IBillPurchaseOrderResponseService;
import com.migro.jobcenter.service.IOrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.doublewin.core.base.BaseService;
import top.doublewin.core.builder.DataBuilder;
import top.doublewin.core.exception.BusinessException;
import top.doublewin.core.util.DataUtil;

import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/11/12 15:07
 */
@Service(interfaceClass = IOrderService.class)
@Component
public class OrderServiceImpl extends BaseService<OrderVO, OrderMapper> implements IOrderService {

    Base64.Decoder decoder = Base64.getDecoder();

    @Autowired
    IBillPurchaseOrderResponseService responseService;


    @Override
    public String dataDownload(Map<String, Object> param) {
        String ret = "";
        // 检查是否有更新的数据
        Integer dataType = HttpClient.checkUpdate();

        // 如果有更新数据，调用平台数据下载服务
        if (DataUtil.isNotEmpty(dataType)) {
            UnifiedInterfaceDataVO vo = HttpClient.downloadData(dataType);
            // 数据解密
            if(DataUtil.isEmpty(vo.getDataContent())){
                throw new BusinessException("数据下载异常，数据内容为空！");
            }
            String data = new String(decoder.decode(vo.getDataContent()));
            logger.debug("数据下载，解密后的数据：{}", data);

            if (DataUtil.isNotEmpty(data)) {
                // 根据数据类型，分别调用数据写入服务
                if (dataType == MsgDataType.响应单.value()) {
                    List<PurResponseVO> list = JSON.parseArray(data, PurResponseVO.class);
                    ret = responseService.importResponse(list);
                }

                if (dataType == MsgDataType.配送单.value()) {
                    List<PurDeliveryVO> list = JSON.parseArray(data, PurDeliveryVO.class);
                    ret = responseService.importDelivery(list);
                }

                if (dataType == MsgDataType.耗材字典.value()) {
                    List<BdMaterial> list = JSON.parseArray(data, BdMaterial.class);
                    ret = responseService.importMaterial(list);
                }

                if (dataType == MsgDataType.耗材品种.value()) {
                    List<BdMaterialVar> list = JSON.parseArray(data, BdMaterialVar.class);
                    ret = responseService.importMaterialVar(list);
                }

                if (dataType == MsgDataType.供应商.value()) {
                    List<SupOrgInfo> list = JSON.parseArray(data, SupOrgInfo.class);
                    ret = responseService.importSupply(list);
                }

                if (dataType == MsgDataType.企业证照.value()) {
                    List<OrgCert> list = JSON.parseArray(data, OrgCert.class);
                    ret = responseService.importLicense(list);
                }

                if(dataType == MsgDataType.生产厂商.value()){
                    List<DicFactory> list = JSON.parseArray(data, DicFactory.class);
                    ret = responseService.importFactory(list);
                }

            }

            // 调用接口更新消息状态
            HttpClient.downloadFinish(vo);
        }

        return ret;
    }
}
