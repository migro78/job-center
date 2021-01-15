package com.migro.jobcenter.service;

import java.util.Map;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2021/1/14 10:05
 */
public interface IUploadDataService {

    /**
     * 检查待上传的数据类型
     *
     * @param
     * @return
     */
    Integer checkUpdate();


    /**
     * 统一数据上传接口
     * @param
     * @return
     */
    String uploadData(Map<String, Object> param);


}
