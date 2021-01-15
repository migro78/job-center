package com.migro.jobcenter.service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * 统一接口客户端服务 Unified interface client service
 * </p>
 *
 * @author migro
 * @since 2020/11/20 16:18
 */
public interface UICService {

    /**
     * 订单上传（异步执行）
     * @param
     * @return
     */
    CompletableFuture<Map> asyncUploadData(Map param);


    /**
     * 统一数据下载更新（异步执行）
     * @param
     * @return
     */
    CompletableFuture<Map> asyncDataDownload(Map param);
}
