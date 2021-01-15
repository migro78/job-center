package com.migro.jobcenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.client.DataInOut;
import com.migro.jobcenter.client.DataType;
import com.migro.jobcenter.client.HttpClient;
import com.migro.jobcenter.enums.MsgDataType;
import com.migro.jobcenter.mapper.UploadDataMapper;
import com.migro.jobcenter.model.vo.OrderDetailVO;
import com.migro.jobcenter.model.vo.OrderVO;
import com.migro.jobcenter.model.vo.UnifiedInterfaceDataVO;
import com.migro.jobcenter.service.IUploadDataService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.doublewin.core.builder.DataBuilder;
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
 * @since 2021/1/14 10:06
 */
@Service(interfaceClass = IUploadDataService.class)
@Component
public class UploadDataServiceImpl implements IUploadDataService {
    protected Logger logger = LogManager.getLogger();
    public static final Integer DEFAULT_PAGE_SIZE = 1;

    @Autowired
    UploadDataMapper mapper;

    @Override
    public Integer checkUpdate() {
        List<Integer> list = mapper.checkUpdate();
        if (DataUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public String uploadData(Map<String, Object> param) {
        // 检查是否有更新的上传数据
        Integer type = checkUpdate();
        if (DataUtil.isNotEmpty(type)) {
            String retMsg = "";
            // 上传订单数据
            if (type.equals(MsgDataType.采购订单.value())) {
                // 默认每次上传数据量
                param.put("pageSize", DEFAULT_PAGE_SIZE);
                retMsg = uploadOrder(param);
            }

            return retMsg;
        }
        return "成功执行，无上传数据！";
    }


    /**
     * 订单上传
     *
     * @param
     * @return
     */
    private String uploadOrder(Map<String, Object> param) {
        // 查询订单主表
        List<OrderVO> list = mapper.listOrder(param);
        logger.debug("轮询采购订单，新订单数量 {}", list.size());
        if (DataUtil.isEmpty(list)) {
            return "执行成功.";
        }

        // 循环查询订单明细、查询跟台订单信息
        Map<String, Object> map = DataBuilder.<String, Object>map().build();
        list.stream().forEach(t -> {
            map.put("code", t.getCode());
            // 订单明细
            List<OrderDetailVO> details = mapper.listOrderDetails(map);
            t.setDetails(details);
            // 跟台订单信息

        });


        // 调用接口上传订单
        int status = 1;
        String errMsg = "";
        try {
            UnifiedInterfaceDataVO vo = new UnifiedInterfaceDataVO();
            vo.setDataType(DataType.订单.value());
            vo.setDataInOut(DataInOut.平台.value());
            vo.setCount(list.size());
            vo.setDataContent(JSON.toJSONString(list));
            HttpClient.uploadData(vo);
        } catch (Exception e) {
            logger.error(e, e);
            status = 2;
            errMsg = e.getMessage().substring(0, 200);
        }


        // 更新消息表状态
        for (OrderVO t : list) {
            if (DataUtil.isNotEmpty(t.getMsgId())) {
                Map<String, Object> mapParam = DataBuilder.<String, Object>map().put("id", t.getMsgId()).put("status", status)
                        .put("remark", errMsg).build();
                mapper.updateMsgStatus(mapParam);
            }
        }

        return "执行成功，上传订单数量" + list.size() + "条.";
    }

    /**
     * 耗材上传
     *
     * @param
     * @return
     */
    private String uploadMaterial(Map<String, Object> param) {
        return null;
    }
}
