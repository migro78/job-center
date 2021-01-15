package com.migro.jobcenter.mapper;


import com.migro.jobcenter.model.HosMaterial;
import com.migro.jobcenter.model.PurOrderOper;
import com.migro.jobcenter.model.vo.OrderDetailVO;
import com.migro.jobcenter.model.vo.OrderVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据上传Mapper
 * </p>
 *
 * @author migro
 * @since 2021/1/13 16:18
 */
public interface UploadDataMapper {

    /**
     * 检查是否有新的待上传数据
     * @param
     * @return 返回数据类型
     */
    List<Integer> checkUpdate();

    /**
     * 查询订单主表
     *
     * @param
     * @return
     */
    List<OrderVO> listOrder(Map<String, Object> param);

    /**
     * 查询订单明细
     *
     * @param
     * @return
     */
    List<OrderDetailVO> listOrderDetails(Map<String, Object> param);

    /**
     * 查询跟台订单手术信息
     *
     * @param
     * @return
     */
    List<PurOrderOper> getOper(OrderVO param);

    /**
     * 更新消息表状态
     *
     * @param
     * @return
     */
    void updateMsgStatus(Map<String, Object> param);


    /**
     * 查询医院院内耗材字典
     * @param
     * @return
     */
    List<HosMaterial> listHosMaterial(Map<String, Object> param);

}
