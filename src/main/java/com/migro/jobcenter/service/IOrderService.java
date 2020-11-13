package com.migro.jobcenter.service;

import com.migro.jobcenter.model.vo.OrderVO;
import top.doublewin.core.base.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/11/12 15:06
 */
public interface IOrderService extends IBaseService<OrderVO> {
    /**
     * 查询待处理订单列表
     * @param
     * @return
     */
    String listOrder(Map<String,Object> param);
}
