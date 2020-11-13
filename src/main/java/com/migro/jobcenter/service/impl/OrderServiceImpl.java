package com.migro.jobcenter.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.migro.jobcenter.client.HttpClient;
import com.migro.jobcenter.mapper.OrderMapper;
import com.migro.jobcenter.model.vo.OrderDetailVO;
import com.migro.jobcenter.model.vo.OrderVO;
import com.migro.jobcenter.service.IOrderService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.doublewin.core.base.BaseService;
import top.doublewin.core.builder.DataBuilder;
import top.doublewin.core.util.DataUtil;

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


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String listOrder(Map<String, Object> param) {
        // 分页查询订单主表
        IPage<OrderVO> page = super.pagingQuery(param);
        List<OrderVO> list = page.getRecords();

        if (DataUtil.isEmpty(list)) {
            return "执行成功，上传订单数量0条.";
        }

        // 循环查询订单明细
        Map<String, Object> map = DataBuilder.<String, Object>map().build();
        list.stream().forEach(t -> {
            map.put("code", t.getCode());
            List<OrderDetailVO> details = mapper.listDetails(map);
            t.setDetails(details);
        });


        // 调用接口上传订单
        HttpClient.uploadOrders(list);

        // 更新消息表状态
        list.stream().forEach(t -> {
            if(DataUtil.isNotEmpty(t.getMsgId())){
                mapper.updateMsgStatus(t.getMsgId());
            }
        });

        return "执行成功，上传订单数量"+list.size()+"条.";
    }
}
