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
     *
     * @param
     * @return
     */
    String uploadOrder(Map<String, Object> param);


    /**
     * 数据下载更新
     *
     * @param
     * @return
     */
    String dataDownload(Map<String, Object> param);

}
