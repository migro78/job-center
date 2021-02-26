package com.migro.jobcenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.client.HttpClient;
import com.migro.jobcenter.enums.MsgDataType;
import com.migro.jobcenter.mapper.DownloadDataMapper;
import com.migro.jobcenter.model.*;
import com.migro.jobcenter.model.vo.PurDeliveryVO;
import com.migro.jobcenter.model.vo.PurResponseVO;
import com.migro.jobcenter.model.vo.UnifiedInterfaceDataVO;
import com.migro.jobcenter.service.IDownloadDataService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.doublewin.core.base.BaseService;
import top.doublewin.core.exception.BusinessException;
import top.doublewin.core.util.DataUtil;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单响应表 服务实现类
 * </p>
 *
 * @author migro
 * @since 2020-11-20
 */
@Service(interfaceClass = IDownloadDataService.class)
@Component
public class DownloadDataServiceImpl extends BaseService<OrderResponse, DownloadDataMapper> implements IDownloadDataService {

    Base64.Decoder decoder = Base64.getDecoder();

    @Autowired
    IDownloadDataService downloadDataService;

    @Override
    public String downloadData(Map<String, Object> param) {
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
                    ret = downloadDataService.importResponse(list);
                }

                if (dataType == MsgDataType.配送单.value()) {
                    List<PurDeliveryVO> list = JSON.parseArray(data, PurDeliveryVO.class);
                    ret = downloadDataService.importDelivery(list);
                }

                if (dataType == MsgDataType.耗材字典.value()) {
                    List<BdMaterial> list = JSON.parseArray(data, BdMaterial.class);
                    ret = downloadDataService.importMaterial(list);
                }

                if (dataType == MsgDataType.耗材品种.value()) {
                    List<BdMaterialVar> list = JSON.parseArray(data, BdMaterialVar.class);
                    ret = downloadDataService.importMaterialVar(list);
                }

                if (dataType == MsgDataType.供应商.value()) {
                    List<SupOrgInfo> list = JSON.parseArray(data, SupOrgInfo.class);
                    ret = downloadDataService.importSupply(list);
                }

                if (dataType == MsgDataType.企业证照.value()) {
                    List<OrgCert> list = JSON.parseArray(data, OrgCert.class);
                    ret = downloadDataService.importLicense(list);
                }

                if(dataType == MsgDataType.生产厂商.value()){
                    List<DicFactory> list = JSON.parseArray(data, DicFactory.class);
                    ret = downloadDataService.importFactory(list);
                }

            }

            // 调用接口更新消息状态
            HttpClient.downloadFinish(vo);
        }

        return ret;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importResponse(List<PurResponseVO> list) {
        if (DataUtil.isNotEmpty(list)) {
            for (PurResponseVO bill : list) {
                // 先删除原有响应单数据
                OrderResponse delParam = new OrderResponse();
                delParam.setPlOrderId(bill.getOrderId().toString());
                super.delete(delParam);
                // 写入明细对象
                List<PurResponseDetails> details = bill.getPurResponseDetails();
                if (DataUtil.isNotEmpty(details)) {
                    for (PurResponseDetails detail : details) {
                        OrderResponse response = new OrderResponse();

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
            return "成功下载供应商证照"+list.size()+"条";
        }
        return "成功下载供应商证照0条";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String importFactory(List<DicFactory> list) {
        if(DataUtil.isNotEmpty(list)){
            list.stream().forEach(t->{
                // 先删除旧数据
                mapper.deleteFactory(t);
                // 插入新数据
                mapper.insertFactory(t);
            });
            return "成功下载生产厂商"+list.size()+"条";
        }
        return "成功下载生产厂商0条";
    }
}
