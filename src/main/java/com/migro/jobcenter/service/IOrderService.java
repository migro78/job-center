package com.migro.jobcenter.service;

import com.migro.jobcenter.model.vo.OrderVO;
import top.doublewin.core.base.IBaseService;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

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
     * 订单上传
     * @param
     * @return
     */
    String uploadOrder(Map<String,Object> param);

    /**
     * 订单上传（异步执行）
     * @param
     * @return
     */
    CompletableFuture<Map> asyncUploadOrder(Map param);
}
