package com.migro.jobcenter.service.impl;

import com.migro.jobcenter.service.IDownloadDataService;
import com.migro.jobcenter.service.IUploadDataService;
import com.migro.jobcenter.service.UICService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * 统一接口客户端服务实现类
 * </p>
 *
 * @author migro
 * @since 2020/11/20 16:25
 */
@Service(interfaceClass = UICService.class, timeout = 60000)
@Component
public class UICServiceImpl implements UICService {
    protected Logger logger = LogManager.getLogger();

    @Autowired
    IDownloadDataService downloadDataService;
    @Autowired
    IUploadDataService uploadDataService;

    @Override
    public CompletableFuture<Map> asyncUploadData(Map param) {
        return CompletableFuture.supplyAsync(() -> {
            String ret = uploadDataService.uploadData(param);
            param.put("msg", ret);
            logger.debug("asyncUploadDate completed...! result is {}", ret);
            return param;
        });
    }

    @Override
    public CompletableFuture<Map> asyncDataDownload(Map param) {
        return CompletableFuture.supplyAsync(() -> {
            String ret = downloadDataService.downloadData(param);
            param.put("msg", ret);
            logger.debug("asyncDataDownload completed...! result is {}", ret);
            return param;
        });
    }

}
